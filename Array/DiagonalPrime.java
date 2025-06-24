public class DiagonalPrime {

    public int diagonalPrime(int[][] nums) {
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i][i])) {
                maxi = Math.max(maxi, nums[i][i]);
            }
            if (isPrime(nums[nums.length - i - 1][i])) {
                maxi = Math.max(maxi, nums[nums.length - i - 1][i]);
            }
        }
        return maxi;
    }

    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        DiagonalPrime solution = new DiagonalPrime();

        int[][] matrix = {
                {1, 2, 3},
                {5, 17, 6},
                {7, 11, 13}
        };

        int result = solution.diagonalPrime(matrix);
        System.out.println("Maximum diagonal prime: " + result);
    }
}

