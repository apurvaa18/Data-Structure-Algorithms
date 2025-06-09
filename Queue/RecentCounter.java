public class RecentCounter {
    private static final int[] records = new int[10000]; // Stores recent pings
    private int start;
    private int end;

    public RecentCounter() {
        start = 0;
        end = 0;
    }

    public int ping(int t) {
        while (start < end && (t - records[start] > 3000)) {
            start++; // Remove pings older than 3000ms
        }
        records[end++] = t; // Add current ping time
        return end - start; // Count of valid pings within 3000ms window
    }

    // Optional main method for quick testing
    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));     // Output: 1
        System.out.println(rc.ping(100));   // Output: 2
        System.out.println(rc.ping(3001));  // Output: 3
        System.out.println(rc.ping(3002));  // Output: 3
    }
}
