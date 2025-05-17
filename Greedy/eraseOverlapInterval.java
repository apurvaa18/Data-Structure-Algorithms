// File: eraseOverlapInterval.java

import java.util.Arrays;

public class eraseOverlapInterval {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);  // Sort by end time
        int prev_end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (prev_end > intervals[i][0]) {
                res++;  // Overlap detected, remove one interval
            } else {
                prev_end = intervals[i][1];  // No overlap, update end
            }
        }

        return res;
    }

    public static void main(String[] args) {
        eraseOverlapInterval obj = new eraseOverlapInterval();
        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
        int result = obj.eraseOverlapIntervals(intervals);
        System.out.println("Minimum number of intervals to remove: " + result);
        // Expected output: 1
    }
}
