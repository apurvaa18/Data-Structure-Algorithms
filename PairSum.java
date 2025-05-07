import java.util.Scanner;

public class PairSum {

    // Method to count pairs with the given target sum
    static int pairSum(int[] arr, int target) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter target sum:");
        int target = sc.nextInt();

        // Call pairSum method and display result
        System.out.println("Number of pairs with target sum: " + pairSum(arr, target));

        sc.close(); // Close the scanner
    }
}


