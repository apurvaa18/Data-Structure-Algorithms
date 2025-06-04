import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // Max-heap using reverse order comparator
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            heap.add(stone);
        }

        while (heap.size() > 1) {
            int top1 = heap.poll();
            int top2 = heap.poll();
            int diff = Math.abs(top1 - top2);
            if (diff != 0) {
                heap.add(diff);
            }
        }

        return heap.isEmpty() ? 0 : heap.poll();
    }

    // Optional main method for testing
    public static void main(String[] args) {
        LastStoneWeight solution = new LastStoneWeight();
        int[] stones = {2, 7, 4, 1, 8, 1};
        int result = solution.lastStoneWeight(stones);
        System.out.println("Last remaining stone weight: " + result); // Output: 1
    }
}
