import java.util.*;
public class MakeArrayBeautiful_Bubble
{

    // Function to count swaps required to sort the array in ascending or descending order
    public static int bubbleSortSwaps(int[] arr, boolean ascending) {
        int n = arr.length;
        int swapCount = 0;
        int[] copy = Arrays.copyOf(arr, n); // Make a copy to avoid modifying the original array

        // Perform Bubble Sort on the copied array and count swaps
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Check if the elements are in the wrong order
                if ((ascending && copy[j] > copy[j + 1]) || (!ascending && copy[j] < copy[j + 1])) {
                    // Swap elements
                    int temp = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = temp;
                    swapCount++;
                }
            }
        }
        return swapCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of elements in the array
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Calculate the swap counts for both ascending and descending orders
        int ascendingSwaps = bubbleSortSwaps(arr, true);
        int descendingSwaps = bubbleSortSwaps(arr, false);

        // Output the minimum of the two swap counts
        System.out.println(Math.min(ascendingSwaps, descendingSwaps));
    }
}



