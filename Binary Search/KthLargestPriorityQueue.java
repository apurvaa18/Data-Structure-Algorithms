import java.util.PriorityQueue;

public class KthLargestPriorityQueue {
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargestPriorityQueue(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.offer(num);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.offer(val);
            minHeap.poll();
        }
        return minHeap.peek();
    }

    // Optional main method for testing
    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        KthLargestPriorityQueue kthLargest = new KthLargestPriorityQueue(3, nums);
        System.out.println(kthLargest.add(3));  // Output: 4
        System.out.println(kthLargest.add(5));  // Output: 5
        System.out.println(kthLargest.add(10)); // Output: 5
        System.out.println(kthLargest.add(9));  // Output: 8
        System.out.println(kthLargest.add(4));  // Output: 8
    }
}
