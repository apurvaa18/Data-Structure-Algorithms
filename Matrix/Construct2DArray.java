import java.util.Arrays;

public class Construct2DArray {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[0][0];
        }

        int[][] result = new int[m][];
        for (int i = 0; i < m; i++) {
            result[i] = Arrays.copyOfRange(original, i * n, i * n + n);
        }
        return result;
    }

    public static void main(String[] args) {
        Construct2DArray solution = new Construct2DArray();

        int[] original = {1, 2, 3, 4, 5, 6};
        int m = 2, n = 3;

        int[][] result = solution.construct2DArray(original, m, n);

        System.out.println("2D Array:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}

