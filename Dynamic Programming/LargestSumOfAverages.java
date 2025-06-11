public class LargestSumOfAverages {

    public static class Solution {
        public double largestSumOfAverages(int[] nums, int k) {
            int n = nums.length;
            Double[][] dp = new Double[n][k];
            return divide(nums, 0, n, k - 1, dp);
        }

        private double divide(int[] nums, int start, int end, int k, Double[][] dp) {
            if (start >= end) return 0;
            if (dp[start][k] != null) return dp[start][k];

            if (k == 0) {
                double sum = 0;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                return sum / (end - start);
            }

            double max = 0;
            for (int i = start + 1; i < end; i++) {
                double right = divide(nums, i, end, k - 1, dp);

                double leftSum = 0;
                for (int j = start; j < i; j++) {
                    leftSum += nums[j];
                }

                double leftAvg = leftSum / (i - start);
                max = Math.max(max, leftAvg + right);
            }

            dp[start][k] = max;
            return max;
        }
    }

    public static void main(String[] args) {
        int[] nums = {9, 1, 2, 3, 9};
        int k = 3;

        Solution sol = new Solution();
        double result = sol.largestSumOfAverages(nums, k);

        System.out.println("Largest Sum of Averages: " + result);
    }
}
