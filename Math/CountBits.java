import java.util.Arrays;

public class CountBits {
    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int sub = 1;

        for (int i = 1; i <= n; i++) {
            if (sub * 2 == i) {
                sub = i;
            }
            dp[i] = dp[i - sub] + 1;
        }

        return dp;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] result = countBits(n);
        System.out.println("Count of 1s from 0 to " + n + ": " + Arrays.toString(result));
    }
}

