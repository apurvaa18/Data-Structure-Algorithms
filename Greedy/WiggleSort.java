import java.util.Arrays;

public class WiggleSort {

    public static class Solution {
        public void wiggleSort(int[] nums) {
            int[] fr = new int[5001];
            for (int num : nums) fr[num]++;
            int index = 1;
            if (nums.length == 1) return;
            for (int i = 5000; i >= 0; i--) {
                while (fr[i] != 0) {
                    nums[index] = i;
                    fr[i]--;
                    index += 2;
                    if (index > nums.length - 1) index = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 5, 1, 1, 6, 4};
        solution.wiggleSort(nums);
        System.out.println("Wiggle sorted array: " + Arrays.toString(nums));
    }
}
