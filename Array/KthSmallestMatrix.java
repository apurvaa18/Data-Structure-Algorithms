public class KthSmallestMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = lessEqual(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Count how many numbers are less than or equal to the target
    public int lessEqual(int[][] matrix, int target) {
        int count = 0, len = matrix.length, i = len - 1, j = 0;

        while (i >= 0 && j < len) {
            if (matrix[i][j] > target) {
                i--;
            } else {
                count += i + 1;
                j++;
            }
        }
        return count;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        KthSmallestMatrix solution = new KthSmallestMatrix();
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        int result = solution.kthSmallest(matrix, k);
        System.out.println("The " + k + "th smallest element is: " + result); // Output: 13
    }
}
