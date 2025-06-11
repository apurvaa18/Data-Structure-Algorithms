import java.util.*;

public class NonOverlappingRectangles {

    static class Solution {

        Random random;
        TreeMap<Integer, int[]> map;
        int areaSum = 0;

        public Solution(int[][] rects) {
            this.random = new Random();
            this.map = new TreeMap<>();

            for (int[] rect : rects) {
                int length = rect[2] - rect[0] + 1;
                int breadth = rect[3] - rect[1] + 1;

                areaSum += length * breadth;
                map.put(areaSum, rect);
            }
        }

        public int[] pick() {
            int key = map.ceilingKey(random.nextInt(areaSum) + 1);
            int[] rect = map.get(key);

            int length = rect[2] - rect[0] + 1;
            int breadth = rect[3] - rect[1] + 1;

            int x = rect[0] + random.nextInt(length);
            int y = rect[1] + random.nextInt(breadth);

            return new int[]{x, y};
        }
    }

    // Testing the Solution class
    public static void main(String[] args) {
        int[][] rects = {
                {1, 1, 5, 5},
                {10, 10, 13, 13},
                {7, 2, 9, 4}
        };

        Solution solution = new Solution(rects);

        // Run some sample picks
        for (int i = 0; i < 5; i++) {
            int[] point = solution.pick();
            System.out.println("Random point: (" + point[0] + ", " + point[1] + ")");
        }
    }
}
