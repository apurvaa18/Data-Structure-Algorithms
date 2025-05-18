public class searchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bot = matrix.length - 1;

        // Binary search to find the correct row
        while (top <= bot) {
            int mid = (top + bot) / 2;

            if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target) {
                top = mid;
                break;
            } else if (matrix[mid][0] > target) {
                bot = mid - 1;
            } else {
                top = mid + 1;
            }
        }

        if (top > bot) return false; // No valid row found

        int row = top;
        int left = 0;
        int right = matrix[row].length - 1;

        // Binary search within the row
        while (left <= right) {
            int mid = (left + right) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 3;
        boolean result = searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + result); // Output: true
    }
}

