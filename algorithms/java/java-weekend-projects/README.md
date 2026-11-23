# Java Weekend Project Challenge

This repository contains the four independent, standard-library console applications from the challenge PDF. The source targets Java 17 and has explanatory comments beside the implementation steps. Menu handling is kept apart from each application's business rules.

## Run an application

From this directory, compile and run one application:

```sh
javac --release 17 -d out 01-safebank/src/safebank/App.java
java -cp out safebank.App
```

Change the source path and main class to one of:

| Project | Source | Main class |
|---|---|---|
| SafeBank | `01-safebank/src/safebank/App.java` | `safebank.App` |
| TextLab | `02-textlab/src/textlab/App.java` | `textlab.App` |
| StudyVault | `03-studyvault/src/studyvault/App.java` | `studyvault.App` |
| CohortHub | `04-cohorthub/src/cohorthub/App.java` | `cohorthub.App` |

TextLab and StudyVault accept multi-line content; enter a single period (`.`) on its own line to finish. StudyVault creates `notes/` and `backups/` under the current working directory. CohortHub keeps its records in memory until the process exits.

## Checks

Run all dependency-free acceptance checks with:

```sh
sh run-checks.sh
```

The script compiles for Java 17 in a temporary directory and removes that directory when it exits. Checks cover rejected and successful SafeBank transactions, TextLab word boundaries and palindrome handling, StudyVault UTF-8 persistence/appending/export/restore/path rejection, and CohortHub uniqueness/cleanup/FIFO behavior.

**Actual results:** all four check programs pass when `sh run-checks.sh` is run. The script prints `SafeBank checks passed.`, `TextLab checks passed.`, `StudyVault checks passed.`, and `CohortHub checks passed.` in order.

### Acceptance checklist

| Project | Check | Expected result |
|---|---|---|
| SafeBank | Deposit `-500` | Rejected; balance and history unchanged |
| SafeBank | Withdraw more than balance | Rejected; balance unchanged |
| SafeBank | Withdraw `₦120,000` from `₦200,000` | Rejected by the single-withdrawal limit |
| SafeBank | Enter letters for amount, then perform a valid transaction | Helpful numeric-input message; app continues |
| TextLab | Search `Java` in `Java JavaScript JAVA` | Frequency is 2 |
| TextLab | Clean spaces, tabs, and line breaks | One ordinary space between remaining text |
| TextLab | Check `A man, a plan, a canal: Panama!` | Palindrome |
| TextLab | Analyze punctuation with no words | No crash and zero word tokens |
| StudyVault | Save and reopen text containing `₦` | Content persists in UTF-8 |
| StudyVault | Append text | Previous content remains and new text follows |
| StudyVault | Export a note | Backup bytes exactly match the note |
| StudyVault | Restore where destination exists | Restore is refused; existing note is not overwritten |
| CohortHub | Reuse an ID or case-insensitive email | Registration rejected |
| CohortHub | Add a learner to a group twice | One membership |
| CohortHub | Request support for two learners | Attended in arrival order |
| CohortHub | Remove a learner with group/queue references | Memberships and pending request removed |

### Sample console interaction

```text
Account holder: Ada
Opening balance (₦): 200000
SafeBank — 1 Deposit | 2 Withdraw | 3 Balance/history | 0 Exit
Choice: 2
Withdrawal amount (₦): 120000
Transaction rejected: A single withdrawal cannot exceed ₦100,000.
```

## Design notes and assumptions

- **SafeBank:** `Account` enforces transaction rules; checked custom exceptions distinguish invalid amounts, insufficient funds, and a withdrawal-limit violation. Only successful operations are recorded. Monetary values use `double` for this learning exercise; production financial software should use `BigDecimal`.
- **TextLab:** A word is a maximal sequence of Unicode letters or digits. Whole-word operations are case-insensitive. Sentence counts ignore punctuation-only fragments. Character counts use Java UTF-16 code units, as returned by `String.length()`. Palindromes compare letters/digits only. Longest-word duplicates are deduplicated without regard to case, preserving the first spelling.
- **StudyVault:** Titles map to `.txt` files and allow letters, digits, spaces, dots, underscores, and hyphens, except traversal names or separators. Searches are case-insensitive substring searches within each line. A new line is inserted before appended content when a note is non-empty. Export replaces a same-named backup; restore never replaces a note.
- **CohortHub:** IDs are exact, trimmed strings; group names are unique without regard to case. Email validation checks a simple `local@domain.suffix` shape, not full RFC compliance. The Map supports ID lookup, each Set prevents duplicate membership, the Queue provides FIFO support, and a fresh List is sorted for display without changing lookup storage.

## Known limitations

- SafeBank uses floating-point amounts and does not implement the optional two-account transfer.
- TextLab's sentence segmentation follows the requested punctuation boundaries and does not model abbreviations.
- StudyVault stores notes as local plain-text files without encryption or multi-process locking.
- CohortHub does not persist data, as persistence is optional in the challenge.

## Reflection (complete before submission)

**Name:** _Add your name._

1. Which project was most challenging, and why? _Write your reflection._
2. Where did you use concepts from another topic? _Write your reflection._
3. What would you improve with more time? _Write your reflection._

## Extra exercise for you

Implement SafeBank's optional **transfer between two accounts**. Validate the source account, destination account, positive finite amount, available balance, and the ₦100,000 per-withdrawal limit before changing either balance. If any check fails, both balances and both histories must remain exactly as they were. Add checks for a successful transfer and for each rejection case.