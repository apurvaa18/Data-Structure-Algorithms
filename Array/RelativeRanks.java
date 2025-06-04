import java.util.PriorityQueue;
import java.util.AbstractMap;
import java.util.Map;

public class RelativeRanks {
    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;

        // Using AbstractMap.SimpleEntry as an alternative to Pair
        PriorityQueue<Map.Entry<Integer, Integer>> maxheap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );

        for (int i = 0; i < n; i++) {
            maxheap.add(new AbstractMap.SimpleEntry<>(i, score[i]));
        }

        String[] ans = new String[n];
        int place = 1;

        while (!maxheap.isEmpty()) {
            Map.Entry<Integer, Integer> top = maxheap.poll();
            int curIndex = top.getKey();

            if (place == 1) {
                ans[curIndex] = "Gold Medal";
            } else if (place == 2) {
                ans[curIndex] = "Silver Medal";
            } else if (place == 3) {
                ans[curIndex] = "Bronze Medal";
            } else {
                ans[curIndex] = String.valueOf(place);
            }
            place++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] scores = {5, 4, 3, 2, 1};
        String[] ranks = findRelativeRanks(scores);
        for (String rank : ranks) {
            System.out.println(rank);
        }
    }
}
