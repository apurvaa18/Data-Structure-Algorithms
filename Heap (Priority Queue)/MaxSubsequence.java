import java.util.*;

public class MaxSubsequence {

    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Comparator.comparingInt(i -> nums[i])
        );

        for (int i = 0; i < nums.length; ++i) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.stream()
                .sorted()
                .mapToInt(i -> nums[i])
                .toArray();
    }

    public static void main(String[] args) {
        MaxSubsequence solution = new MaxSubsequence();

        int[] nums = {2, 1, 3, 3};
        int k = 2;
        int[] result = solution.maxSubsequence(nums, k);

        System.out.println("Max Subsequence of length " + k + ": " + Arrays.toString(result));
    }
}

