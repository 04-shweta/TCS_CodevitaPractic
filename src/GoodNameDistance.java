
    import java.util.Scanner;

    public class GoodNameDistance {

        // Function to calculate the distance between two characters
        public static int getDistance(char a, char b) {
            return Math.abs(a - b);  // Return the absolute difference of ASCII values
        }

        // Function to find the nearest good letter to a given character
        public static char findNearestGoodLetter(char ch, String goodString, char previousGoodLetter) {
            char nearest = goodString.charAt(0);
            int minDistance = getDistance(ch, nearest);

            for (char goodLetter : goodString.toCharArray()) {
                int currentDistance = getDistance(ch, goodLetter);
                if (currentDistance < minDistance ||
                        (currentDistance == minDistance && getDistance(previousGoodLetter, goodLetter) < getDistance(previousGoodLetter, nearest))) {
                    nearest = goodLetter;
                    minDistance = currentDistance;
                }
            }

            return nearest; // Return the nearest good letter
        }

        // Function to calculate the total distance for converting the name to a good name
        public static int calculateTotalDistance(String name, String goodString) {
            int totalDistance = 0;
            char previousGoodLetter = goodString.charAt(0);  // The first letter of goodString is initially the previous good letter

            for (char ch : name.toCharArray()) {
                // If the letter is already a good letter, no need to change it
                if (goodString.indexOf(ch) != -1) {
                    previousGoodLetter = ch;
                    continue;
                }

                // Find the nearest good letter and calculate the distance
                char nearestGoodLetter = findNearestGoodLetter(ch, goodString, previousGoodLetter);
                totalDistance += getDistance(ch, nearestGoodLetter);
                previousGoodLetter = nearestGoodLetter;  // Update the previous good letter
            }

            return totalDistance; // Return the total distance
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Input good string
            System.out.println("Enter the good string:");
            String goodString = scanner.nextLine();

            // Input student's name
            System.out.println("Enter the student's name:");
            String name = scanner.nextLine();

            // Calculate and print the total distance
            int totalDistance = calculateTotalDistance(name, goodString);
            System.out.println("Total distance to convert the name: " + totalDistance);

            scanner.close();
        }
    }


