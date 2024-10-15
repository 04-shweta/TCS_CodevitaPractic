import java.util.Scanner;

public class OrchardChallenge {

    // Function to count the valid selections of 3 trees with no two adjacent trees of the same type
    public static int countValidSelections(String row) {
        int count = 0;
        int n = row.length();

        // Loop through all possible sets of 3 trees such that no two adjacent trees are of the same type
        for (int i = 0; i < n - 2; i++) {
            // Check if trees at index i, i+1, i+2 are valid (no two adjacent trees are the same)
            if (row.charAt(i) != row.charAt(i+1) && row.charAt(i+1) != row.charAt(i+2)) {
                count++;
            }
        }

        return count;
    }

    // Function to validate the input string
    public static boolean isValidInput(String row) {
        for (char c : row.toCharArray()) {
            if (c != 'M' && c != 'L') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input row for Ashok
        System.out.println("Enter the row for Ashok (only M and L are allowed):");
        String rowAshok = scanner.nextLine();

        // Input row for Anand
        System.out.println("Enter the row for Anand (only M and L are allowed):");
        String rowAnand = scanner.nextLine();

        // Validate the input strings
        if (!isValidInput(rowAshok) || !isValidInput(rowAnand)) {
            System.out.println("Invalid input");
            return;
        }

        // Calculate the valid selections for both Ashok and Anand
        int ashokSelections = countValidSelections(rowAshok);
        int anandSelections = countValidSelections(rowAnand);

        // Determine the winner
        if (ashokSelections > anandSelections) {
            System.out.println("Ashok");
        } else if (anandSelections > ashokSelections) {
            System.out.println("Anand");
        } else {
            System.out.println("Draw");
        }

        scanner.close();
    }
}

