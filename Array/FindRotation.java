public class FindRotation {

    public boolean findRotation(int[][] a, int[][] b) {
        int n = a.length;
        int c90 = 0, c180 = 0, c270 = 0, c0 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i][j] == a[n - j - 1][i]) c90++;
                if (b[i][j] == a[n - i - 1][n - j - 1]) c180++;
                if (b[i][j] == a[j][n - i - 1]) c270++;
                if (b[i][j] == a[i][j]) c0++;
            }
        }

        return c90 == n * n || c180 == n * n || c270 == n * n || c0 == n * n;
    }

    public static void main(String[] args) {
        FindRotation solution = new FindRotation();

        int[][] a = {
                {0, 1},
                {1, 0}
        };

        int[][] b = {
                {1, 0},
                {0, 1}
        };

        boolean result = solution.findRotation(a, b);
        System.out.println("Can matrix A be rotated to match matrix B? " + result);
    }
}
