import java.util.Arrays;

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = 1, res = 0;
        while (r < nums.length) {
            int diff = nums[r] - nums[l];
            if (diff == 1) res = Math.max(res, r - l + 1);
            if (diff <= 1) r++;
            else l++;
        }
        return res;
    }

    public static void main(String[] args) {
        LongestHarmoniousSubsequence lhsFinder = new LongestHarmoniousSubsequence();
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        int result = lhsFinder.findLHS(nums);
        System.out.println("Longest Harmonious Subsequence Length: " + result);
    }
}
