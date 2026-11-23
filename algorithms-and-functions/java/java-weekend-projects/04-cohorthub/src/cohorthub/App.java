package cohorthub;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

// Hosts the menu while CohortManager owns collection-based learner and group rules.
public class App {
    // Runs the in-memory learner, group, and mentor-support application.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CohortManager manager = new CohortManager();
        boolean running = true;
        while (running) {
            System.out.println("\nCohortHub — 1 Register | 2 Find | 3 Update | 4 Remove");
            System.out.println("5 List learners | 6 Create group | 7 Assign learner | 8 Learner groups");
            System.out.println("9 Queue support | 10 Attend next | 11 Statistics | 0 Exit");
            System.out.print("Choice: ");
            try {
                switch (input.nextLine().trim()) {
                    case "1" -> register(input, manager);
                    case "2" -> System.out.println(manager.findLearner(readId(input)));
                    case "3" -> update(input, manager);
                    case "4" -> manager.removeLearner(readId(input));
                    case "5" -> manager.sortedLearners().forEach(System.out::println);
                    case "6" -> {
                        System.out.print("Group name: ");
                        manager.createGroup(input.nextLine());
                    }
                    case "7" -> assign(input, manager);
                    case "8" -> System.out.println(manager.groupsFor(readId(input)));
                    case "9" -> manager.requestSupport(readId(input));
                    case "10" -> System.out.println("Attending: " + manager.attendNext());
                    case "11" -> System.out.println(manager.statistics());
                    case "0" -> running = false;
                    default -> System.out.println("Choose a listed menu number.");
                }
            } catch (IllegalArgumentException exception) {
                System.out.println("Operation failed: " + exception.getMessage());
            }
        }
        System.out.println("Goodbye.");
    }

    // Reads and registers a learner, letting the manager enforce uniqueness.
    private static void register(Scanner input, CohortManager manager) {
        System.out.print("Learner ID: ");
        String id = input.nextLine();
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Email: ");
        manager.registerLearner(id, name, input.nextLine());
        System.out.println("Learner registered.");
    }

    // Reads the learner identity and replacement values for an update.
    private static void update(Scanner input, CohortManager manager) {
        String id = readId(input);
        System.out.print("New name: ");
        String name = input.nextLine();
        System.out.print("New email: ");
        manager.updateLearner(id, name, input.nextLine());
        System.out.println("Learner updated; ID remains unchanged.");
    }

    // Reads a group and learner ID, then makes the assignment idempotently.
    private static void assign(Scanner input, CohortManager manager) {
        System.out.print("Group name: ");
        String group = input.nextLine();
        String id = readId(input);
        manager.assignToGroup(group, id);
        System.out.println("Learner assigned (existing membership is not duplicated).");
    }

    // Reads one learner ID from the console.
    private static String readId(Scanner input) {
        System.out.print("Learner ID: ");
        return input.nextLine();
    }

    // Applies business rules while choosing collections that fit each access pattern.
    static final class CohortManager {
        private static final Comparator<Learner> LEARNER_ORDER =
                Comparator.comparing(Learner::getName, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Learner::getId);
        private final Map<String, Learner> learnersById = new HashMap<>();
        private final Map<String, Set<String>> groupMembers = new HashMap<>();
        private final Queue<String> supportQueue = new ArrayDeque<>();

        // Registers a unique immutable ID and case-insensitively unique email address.
        void registerLearner(String id, String name, String email) {
            validateRequired(id, "ID");
            validateRequired(name, "Name");
            validateEmail(email);
            if (learnersById.containsKey(id.trim())) {
                throw new IllegalArgumentException("Learner ID already exists.");
            }
            ensureEmailAvailable(email, null);
            learnersById.put(id.trim(), new Learner(id.trim(), name.trim(), email.trim()));
        }

        // Finds a learner by the map key and reports when the ID is unknown.
        Learner findLearner(String id) {
            Learner learner = learnersById.get(id == null ? null : id.trim());
            if (learner == null) {
                throw new IllegalArgumentException("Learner not found: " + id);
            }
            return learner;
        }

        // Updates a learner's mutable details while preserving unique ID and email constraints.
        void updateLearner(String id, String name, String email) {
            Learner learner = findLearner(id);
            validateRequired(name, "Name");
            validateEmail(email);
            ensureEmailAvailable(email, learner.getId());
            learner.update(name.trim(), email.trim());
        }

        // Removes the learner and every reference to that ID in groups and the support queue.
        void removeLearner(String id) {
            String normalizedId = id == null ? null : id.trim();
            if (learnersById.remove(normalizedId) == null) {
                throw new IllegalArgumentException("Learner not found: " + id);
            }
            groupMembers.values().forEach(members -> members.remove(normalizedId));
            supportQueue.removeIf(queuedId -> queuedId.equals(normalizedId));
        }

        // Returns a new sorted List without changing the map's lookup behavior.
        List<Learner> sortedLearners() {
            List<Learner> result = new ArrayList<>(learnersById.values());
            result.sort(LEARNER_ORDER);
            return result;
        }

        // Creates a group with unique membership storage and rejects duplicate group names.
        void createGroup(String groupName) {
            validateRequired(groupName, "Group name");
            String normalized = groupName.trim();
            boolean exists = groupMembers.keySet().stream()
                    .anyMatch(existing -> existing.equalsIgnoreCase(normalized));
            if (exists) {
                throw new IllegalArgumentException("Group already exists.");
            }
            groupMembers.put(normalized, new HashSet<>());
        }

        // Adds a registered learner to a group Set, which prevents duplicate membership.
        void assignToGroup(String groupName, String learnerId) {
            Learner learner = findLearner(learnerId);
            Set<String> members = findGroupMembers(groupName);
            if (members == null) {
                throw new IllegalArgumentException("Study group not found: " + groupName);
            }
            members.add(learner.getId());
        }

        // Lists every group containing the given registered learner.
        List<String> groupsFor(String learnerId) {
            Learner learner = findLearner(learnerId);
            return groupMembers.entrySet().stream()
                    .filter(entry -> entry.getValue().contains(learner.getId()))
                    .map(Map.Entry::getKey)
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .toList();
        }

        // Adds one pending support request per registered learner.
        void requestSupport(String learnerId) {
            Learner learner = findLearner(learnerId);
            if (supportQueue.contains(learner.getId())) {
                throw new IllegalArgumentException("Learner already has a pending support request.");
            }
            supportQueue.add(learner.getId());
        }

        // Removes the earliest support request, reporting the empty-queue condition helpfully.
        Learner attendNext() {
            String learnerId = supportQueue.poll();
            if (learnerId == null) {
                throw new IllegalArgumentException("No learners are waiting for support.");
            }
            return findLearner(learnerId);
        }

        // Produces totals and membership counts without exposing the underlying collections.
        String statistics() {
            StringBuilder result = new StringBuilder("Learners: ")
                    .append(learnersById.size())
                    .append(", groups: ").append(groupMembers.size())
                    .append(", waiting for support: ").append(supportQueue.size());
            groupMembers.forEach((name, members) ->
                    result.append("\n").append(name).append(" members: ").append(members.size()));
            return result.toString();
        }

        // Ensures an email is unused by every learner except the record being updated.
        private void ensureEmailAvailable(String email, String exceptId) {
            boolean duplicate = learnersById.values().stream()
                    .anyMatch(learner -> !learner.getId().equals(exceptId)
                            && learner.getEmail().equalsIgnoreCase(email.trim()));
            if (duplicate) {
                throw new IllegalArgumentException("Email address already exists.");
            }
        }

        // Resolves a group name without regard to case while retaining its registered spelling.
        private Set<String> findGroupMembers(String groupName) {
            if (groupName == null) {
                return null;
            }
            return groupMembers.entrySet().stream()
                    .filter(entry -> entry.getKey().equalsIgnoreCase(groupName.trim()))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElse(null);
        }

        // Rejects an email that is blank or lacks a basic local@domain form.
        private static void validateEmail(String email) {
            validateRequired(email, "Email");
            if (!email.trim().matches("[^\\s@]+@[^\\s@]+\\.[^\\s@]+")) {
                throw new IllegalArgumentException("Enter a valid email address.");
            }
        }

        // Rejects null or blank required text fields.
        private static void validateRequired(String value, String field) {
            if (value == null || value.isBlank()) {
                throw new IllegalArgumentException(field + " must not be blank.");
            }
        }
    }

    // Stores mutable display/contact fields and an immutable learner identity.
    static final class Learner {
        private final String id;
        private String name;
        private String email;

        // Creates the learner; only CohortManager handles the registration rules.
        Learner(String id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        // Returns the immutable ID used as a map key and membership reference.
        String getId() {
            return id;
        }

        // Returns the current display name used in sorted views.
        String getName() {
            return name;
        }

        // Returns the current contact address.
        String getEmail() {
            return email;
        }

        // Changes only mutable fields after the manager has validated them.
        private void update(String newName, String newEmail) {
            name = newName;
            email = newEmail;
        }

        // Formats a readable learner record for the console.
        @Override
        public String toString() {
            return id + " — " + name + " <" + email + ">";
        }
    }
}
