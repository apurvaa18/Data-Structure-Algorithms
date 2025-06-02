public class TrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            n /= 5;
            res += n;
        }
        return res;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        TrailingZeroes solution = new TrailingZeroes();
        int n = 100;
        int result = solution.trailingZeroes(n);
        System.out.println("Number of trailing zeroes in " + n + "! is: " + result); // Output: 24
    }
}
