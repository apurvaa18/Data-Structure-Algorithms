public class CountNegatives {

    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int row = m - 1;
        int col = 0;
        int result = 0;

        while (row >= 0 && col < n) {
            if (grid[row][col] < 0) {
                result += n - col;
                row--;
            } else {
                col++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CountNegatives solution = new CountNegatives();

        int[][] grid = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };

        int result = solution.countNegatives(grid);
        System.out.println("Number of negative numbers: " + result);
    }
}
