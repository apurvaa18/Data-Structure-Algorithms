import java.util.Arrays;

public class MinimumCostToBuyCandies {

    public int minimumCost(final int[] cost) {
        final int n = cost.length;

        // Sort in ascending order to get the most expensive items last
        Arrays.sort(cost);

        int total = 0;
        int i = n - 1;

        // Buy two candies and skip one (cheapest of three)
        while (i >= 0) {
            for (int j = i; j >= i - 1 && j >= 0; --j) {
                total += cost[j];
            }
            i -= 3; // Skip the third candy (free one)
        }

        return total;
    }

    public static void main(String[] args) {
        MinimumCostToBuyCandies solution = new MinimumCostToBuyCandies();
        int[] cost = {6, 5, 7, 9, 2, 2};
        int result = solution.minimumCost(cost);
        System.out.println("Minimum Cost: " + result); // Example expected: 23
    }
}

