import java.util.*;

public class MilitaryCampBoxes {

    // Function to check if a number is a triangular number
    public static boolean isTriangular(int weight) {
        int n = (int)(Math.sqrt(2 * weight));
        return n * (n + 1) / 2 == weight;
    }

    // Function to simulate the cycles and return the total worker's charge
    public static int calculateWorkerCharge(int[] weights, int N, int K) {
        Queue<Integer> queue = new LinkedList<>();

        // Initialize the queue with the first N boxes
        for (int i = 0; i < N; i++) {
            queue.add(weights[i]);
        }

        int lastBox = -1;
        int cycleCount = 0;

        // Repeat until we get K consecutive cycles where the same box remains
        while (cycleCount < K) {
            int size = queue.size();
            int lastRemainingBox = -1;

            // Cycle: Compare boxes until only one remains
            for (int i = 0; i < size - 1; i++) {
                int box1 = queue.poll();
                int box2 = queue.poll();

                // Send the lighter box to the end of the line
                if (box1 < box2) {
                    queue.add(box1);
                    queue.add(box2);
                } else {
                    queue.add(box2);
                    queue.add(box1);
                }
            }

            // The last remaining box in this cycle
            lastRemainingBox = queue.peek();

            // If the last box remained unshifted, increment the cycle count, otherwise reset it
            if (lastBox == lastRemainingBox) {
                cycleCount++;
            } else {
                cycleCount = 0;
            }

            lastBox = lastRemainingBox;
        }

        // Calculate the total amount to pay the workers excluding triangular weights
        int totalCharge = 0;
        for (int weight : queue) {
            if (!isTriangular(weight)) {
                totalCharge += weight;
            }
        }

        return totalCharge;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input weights of the boxes
        System.out.println("Enter the number of boxes:");
        int numBoxes = scanner.nextInt();
        int[] weights = new int[numBoxes];

        System.out.println("Enter the weights of the boxes:");
        for (int i = 0; i < numBoxes; i++) {
            weights[i] = scanner.nextInt();
        }

        // Input N and K
        System.out.println("Enter the value of N (number of boxes to consider in each cycle):");
        int N = scanner.nextInt();

        System.out.println("Enter the value of K (consecutive cycles to halt the process):");
        int K = scanner.nextInt();

        // Calculate the total charge for the workers
        int result = calculateWorkerCharge(weights, N, K);
        System.out.println("Total amount to pay the workers: " + result);      //print nahi ho raha

        scanner.close();
    }
}
