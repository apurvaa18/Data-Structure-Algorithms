public class PerfectSquare {

    public static class Solution {
        public boolean isPerfectSquare(int num) {
            int left = 1, right = num;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                long midSquare = (long) mid * mid;

                if (midSquare == num) {
                    return true;
                } else if (midSquare > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return false;
        }
    }

    // Optional: Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        int test1 = 16;
        System.out.println(test1 + " is perfect square? " + solution.isPerfectSquare(test1)); // true

        int test2 = 14;
        System.out.println(test2 + " is perfect square? " + solution.isPerfectSquare(test2)); // false
    }
}
