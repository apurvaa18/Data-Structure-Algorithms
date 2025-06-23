import java.util.ArrayList;
import java.util.List;

public class ShiftGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = grid.length, col = grid[0].length;

        for (int r = 0; r < rows; r++)
            result.add(new ArrayList<>());

        k %= (rows * col);
        int dimension = rows * col;
        int begin = dimension - k;
        int x = 0;

        for (int i = begin; i < begin + dimension; i++) {
            int r = (i / col) % rows, c = i % col;
            result.get(x / col).add(grid[r][c]);
            x++;
        }
        return result;
    }

    public static void main(String[] args) {
        ShiftGrid solution = new ShiftGrid();

        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int k = 1;

        List<List<Integer>> result = solution.shiftGrid(grid, k);

        System.out.println("Shifted Grid:");
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}

