import java.util.*;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int idx = 0; idx < nums.length; idx++) {
            int num = nums[idx];

            // Remove elements smaller than current from the back
            while (!deque.isEmpty() && nums[deque.getLast()] < num) {
                deque.pollLast();
            }
            deque.addLast(idx);

            // Remove the element which is out of this window
            if (deque.getFirst() <= idx - k) {
                deque.pollFirst();
            }

            // Start adding to result once we reach the window size
            if (idx >= k - 1) {
                res.add(nums[deque.getFirst()]);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    // Optional main method for testing
    public static void main(String[] args) {
        MaxSlidingWindow solution = new MaxSlidingWindow();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        // Output: [3, 3, 5, 5, 6, 7]
    }
}
