public class FireDrill1{
    public static void main(String[] args){
        String[] usersA;
        String[] usersB;
        String[] usersC;
        String[] usersD;
        String[] usersE;
        String[] usersF;
//      facebookLikes(usersA));
//      facebookLikes(usersB));
//      facebookLikes(usersC));
//      facebookLikes(usersD));
//      facebookLikes(usersE));
//      facebookLikes(usersF));
    }

    public static int numberOfUsers(String... users){
        int count = users.length;
        int userCount = 0;

        for (int i = 0; i < count; i++){
            if (users[i] == null) continue;
            userCount++;
        }
        return userCount;
    }

    public static String[] usernames(String... users){
        int count = numberOfUsers(users);
        if (count == 0) return null;

        String[] usernames = new String[count];
        int j = 0;
        if (count > 0) {
            for (int i = 0; i < count; i++){
                if (users[i] == null) continue;
                usernames[j] = users[i];
                j++;
            }
        }
        return usernames;
    }

    public static void facebookLikes(String... users){
        int count = numberOfUsers(users);
        String[] user = usernames(users);
        
        switch (count){
            case 0: System.out.println("no one likes this"); break;
            case 1: System.out.printf("%s likes this", users[0]); break;
            case 2: System.out.printf("%s and %s likes this", users[0], users[1]); break;
            case 3: System.out.printf("%s, %s and %s like this", users[0], users[1], users[2]); break;
            default: System.out.printf("%s, %s and %d others like this", user[0], user[1], (count - 2)); break;
        }
    }
}
