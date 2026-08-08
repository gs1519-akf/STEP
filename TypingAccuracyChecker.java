import java.util.Scanner;

public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {

        int matched = 0;
        int firstMismatch = -1;

        // Compare character by character
        int compareLength = Math.min(original.length(), typed.length());

        for (int i = 0; i < compareLength; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else {
                if (firstMismatch == -1) {
                    firstMismatch = i;
                }
            }
        }

        // If typed text is shorter, the remaining characters are mismatches
        if (typed.length() < original.length() && firstMismatch == -1) {
            firstMismatch = typed.length();
        }

        // Calculate accuracy
        double accuracy = (matched * 100.0) / original.length();

        System.out.println("Matched Characters: " + matched);
        System.out.println("Accuracy: " + accuracy + "%");

        if (firstMismatch != -1) {
            System.out.println("First Mismatch Position: " + firstMismatch);
        } else {
            System.out.println("Perfect Match!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original text: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);

        sc.close();
    }
}