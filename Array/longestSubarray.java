import java.util.*;

public class longestSubarray {

    public static int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> increase = new LinkedList<>();
        LinkedList<Integer> decrease = new LinkedList<>();

        int max = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            while (!increase.isEmpty() && n < increase.getLast()) {
                increase.removeLast();
            }
            increase.add(n);

            while (!decrease.isEmpty() && n > decrease.getLast()) {
                decrease.removeLast();
            }
            decrease.add(n);

            while (decrease.getFirst() - increase.getFirst() > limit) {
                if (nums[left] == decrease.getFirst()) {
                    decrease.removeFirst();
                }
                if (nums[left] == increase.getFirst()) {
                    increase.removeFirst();
                }
                left++;
            }

            int size = i - left + 1;
            max = Math.max(max, size);
        }

        return max;
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        int[] nums = {8, 2, 4, 7};
        int limit = 4;
        int result = longestSubarray(nums, limit);
        System.out.println("Longest subarray length: " + result); // Expected: 2
    }
}
