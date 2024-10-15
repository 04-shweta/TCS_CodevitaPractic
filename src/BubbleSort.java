import java.util.Scanner;

public class BubbleSort {

        // Function to count swaps needed to sort array in ascending order
        public static int countSwapsToSortAscending(int[] arr) {
            int n = arr.length;
            int swaps = 0;
            int[] temp = arr.clone(); // To avoid modifying the original array

            // Bubble sort to count swaps in ascending order
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (temp[j] > temp[j + 1]) {
                        // Swap elements
                        int t = temp[j];
                        temp[j] = temp[j + 1];
                        temp[j + 1] = t;
                        swaps++;
                    }
                }
            }
            return swaps;
        }

        // Function to count swaps needed to sort array in descending order
        public static int countSwapsToSortDescending(int[] arr) {
            int n = arr.length;
            int swaps = 0;
            int[] temp = arr.clone(); // To avoid modifying the original array

            // Bubble sort to count swaps in descending order
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (temp[j] < temp[j + 1]) {
                        // Swap elements
                        int t = temp[j];
                        temp[j] = temp[j + 1];
                        temp[j + 1] = t;
                        swaps++;
                    }
                }
            }
            return swaps;
        }

        // Function to find minimum swaps to make the array beautiful
        public static int minSwapsToMakeBeautiful(int[] arr) {
            // Count swaps for both ascending and descending order
            int swapsAsc = countSwapsToSortAscending(arr);
            int swapsDesc = countSwapsToSortDescending(arr);

            // Return the minimum of the two
            return Math.min(swapsAsc, swapsDesc);
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Input array size
            System.out.println("Enter the size of the array:");
            int n = scanner.nextInt();

            // Input array elements
            int[] arr = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Find and print minimum swaps to make array beautiful
            int result = minSwapsToMakeBeautiful(arr);
            System.out.println("Minimum swaps to make the array beautiful: " + result);
        }
    }


