import java.util.Scanner;

public class MinimizeZeros {

    public static int findMaxConsecutiveZeros(int L, int K) {
        // Calculate the number of zeros
        int Z = L - K;

        // If there are no zeros or no ones, return Z as the entire string is zeros
        if (K == 0) {
            return Z;
        }

        // Divide the zeros into K + 1 parts
        int q = Z / (K + 1);  // Base length of zero blocks
        int r = Z % (K + 1);  // Extra zeros to distribute

        // The largest block of zeros will either be q or q + 1
        return (r > 0) ? q + 1 : q;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input length of the binary string
        System.out.println("Enter the length of the binary string (L):");
        int L = scanner.nextInt();

        // Input the number of ones in the binary string
        System.out.println("Enter the number of ones (K):");
        int K = scanner.nextInt();

        // Calculate and print the maximum length of contiguous zeros
        int result = findMaxConsecutiveZeros(L, K);
        System.out.println("The length of the longest contiguous block of zeros is: " + result);

        scanner.close();
    }
}

