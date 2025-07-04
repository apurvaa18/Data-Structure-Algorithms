import java.util.*;

public class tribonacci {

    public static int tribonacci(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return helper(n, memo);
    }

    private static int helper(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result;
        if (n == 0) {
            result = 0;
        } else if (n == 1 || n == 2) {
            result = 1;
        } else {
            result = helper(n - 1, memo) + helper(n - 2, memo) + helper(n - 3, memo);
        }

        memo.put(n, result);
        return result;
    }

    // Optional: main method to test
    public static void main(String[] args) {
        int n = 25;
        int result = tribonacci(n);
        System.out.println("The " + n + "th Tribonacci number is: " + result); // Expected: 1389537
    }
}
