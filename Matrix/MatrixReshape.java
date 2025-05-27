public class MatrixReshape {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;

        // If reshaping isn't possible, return original matrix
        if ((rows * cols) != (r * c)) return mat;

        int[][] output = new int[r][c];
        int outputRows = 0;
        int outputCols = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                output[outputRows][outputCols] = mat[i][j];
                outputCols++;

                if (outputCols == c) {
                    outputCols = 0;
                    outputRows++;
                }
            }
        }

        return output;
    }

    // For testing the method
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2},
                {3, 4}
        };
        int r = 1, c = 4;
        int[][] reshaped = matrixReshape(mat, r, c);

        System.out.println("Reshaped Matrix:");
        for (int[] row : reshaped) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
