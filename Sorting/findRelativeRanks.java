// File: findRelativeRanks.java

import java.util.*;

public class findRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        // Max heap sorted by score descending
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> maxheap =
                new PriorityQueue<>((p1, p2) -> p2.getValue() - p1.getValue());

        for (int i = 0; i < n; i++) {
            maxheap.add(new AbstractMap.SimpleEntry<>(i, score[i]));
        }

        String[] ans = new String[n];
        int place = 1;

        while (!maxheap.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> top = maxheap.poll();
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
        findRelativeRanks obj = new findRelativeRanks();
        int[] scores = {10, 3, 8, 9, 4};
        String[] ranks = obj.findRelativeRanks(scores);
        System.out.println("Ranks: " + Arrays.toString(ranks));
        // Expected output: [Gold Medal, 5, Bronze Medal, Silver Medal, 4]
    }
}

