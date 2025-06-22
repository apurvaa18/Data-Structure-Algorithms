import java.util.Arrays;

public class DeleteGreatestValue {

    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;

        // Sort each row in ascending order
        for (int[] row : grid) {
            Arrays.sort(row);
        }

        // Traverse column-wise and collect max from each column
        for (int j = 0; j < n; j++) {
            int maxVal = 0;
            for (int i = 0; i < m; i++) {
                maxVal = Math.max(maxVal, grid[i][j]);
            }
            sum += maxVal;
        }

        return sum;
    }

    // Main method to test the logic
    public static void main(String[] args) {
        DeleteGreatestValue solver = new DeleteGreatestValue();

        int[][] grid = {
                {1, 2, 4},
                {3, 3, 1}
        };

        int result = solver.deleteGreatestValue(grid);
        System.out.println("Sum of selected values: " + result);
    }
}

