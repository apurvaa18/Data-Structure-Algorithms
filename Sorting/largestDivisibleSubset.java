// File: largestDivisibleSubset.java

import java.util.*;

public class largestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxi = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxi]) {
                maxi = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = maxi; i >= 0; i = prev[i]) {
            res.add(nums[i]);
            if (prev[i] == -1) break;
        }

        return res;
    }

    public static void main(String[] args) {
        largestDivisibleSubset obj = new largestDivisibleSubset();
        int[] nums = {1, 2, 4, 8};
        List<Integer> result = obj.largestDivisibleSubset(nums);
        System.out.println("Largest divisible subset: " + result);
        // Expected output: [8, 4, 2, 1] (or in reverse)
    }
}
