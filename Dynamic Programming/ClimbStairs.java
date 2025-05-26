public class ClimbStairs {
    public static int climbStairs(int n) {
        if (n <= 3) return n;

        int prev1 = 3;
        int prev2 = 2;
        int cur = 0;

        for (int i = 3; i < n; i++) {
            cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }

        return cur;
    }

    public static void main(String[] args) {
        int steps = 5;
        int ways = climbStairs(steps);
        System.out.println("Ways to climb " + steps + " stairs: " + ways);
    }
}
