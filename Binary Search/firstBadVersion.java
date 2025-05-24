
// Simulated VersionControl class with isBadVersion API
class VersionControl {
    // Replace this with your actual logic or simulated value
    int bad = 4; // Example: version 4 is the first bad version

    boolean isBadVersion(int version) {
        return version >= bad;
    }
}

// Main solution extending VersionControl
public class firstBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
        int l = 1, h = n; // version numbers start from 1
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isBadVersion(mid)) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // Optional: Main method for testing
    public static void main(String[] args) {
        firstBadVersion solution = new firstBadVersion();
        int n = 5; // total number of versions
        System.out.println("First bad version: " + solution.firstBadVersion(n)); // Output: 4
    }
}
