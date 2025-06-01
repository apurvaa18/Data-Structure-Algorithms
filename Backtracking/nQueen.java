import java.util.*;

public class nQueen {

    // Helper function to check if placing a queen at position (row, col) is safe
    private boolean isSafePlace(int n, char[][] nQueens, int row, int col) {
        // Check if there's any queen in the same column above current position
        for (int i = 0; i < n; i++) {
            if (nQueens[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal for any queen
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (nQueens[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal for any queen
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (nQueens[i][j] == 'Q') {
                return false;
            }
        }

        return true; // If no conflicts found, position is safe
    }

    // Recursive helper function to solve N-Queens problem
    private void solveNQueens(int n, List<List<String>> output, char[][] nQueens, int row) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] rowArray : nQueens) {
                solution.add(new String(rowArray));
            }
            output.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafePlace(n, nQueens, row, col)) {
                nQueens[row][col] = 'Q'; // Place queen
                solveNQueens(n, output, nQueens, row + 1); // Recursively solve for next row
                nQueens[row][col] = '.'; // Backtrack
            }
        }
    }

    // Main function to solve N-Queens problem
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();
        char[][] nQueens = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
        }

        solveNQueens(n, output, nQueens, 0);
        return output;
    }

    // Main method for testing
    public static void main(String[] args) {
        nQueen solver = new nQueen();
        int n = 4;
        List<List<String>> solutions = solver.solveNQueens(n);

        System.out.println("Solutions for " + n + "-Queens:");
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
