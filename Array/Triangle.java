import java.util.*;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] memo = new int[row];

        for (int i = 0; i < row; i++) {
            memo[i] = triangle.get(row - 1).get(i);
        }

        for (int r = row - 2; r >= 0; r--) {
            for (int c = 0; c <= r; c++) {
                memo[c] = Math.min(memo[c], memo[c + 1]) + triangle.get(r).get(c);
            }
        }

        return memo[0];
    }

    // Main method for testing
    public static void main(String[] args) {
        Triangle obj = new Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        int result = obj.minimumTotal(triangle);
        System.out.println("Minimum total path sum: " + result);
    }
}
