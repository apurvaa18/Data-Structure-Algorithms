import java.util.*;

public class threeSum {
    public List<List<Integer>> findThreeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    // Skip duplicates for j
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }

        return res;
    }

    // Main method for testing
    public static void main(String[] args) {
        threeSum obj = new threeSum();
        int[] input = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = obj.findThreeSum(input);
        System.out.println("Triplets that sum to zero: " + result);
    }
}
