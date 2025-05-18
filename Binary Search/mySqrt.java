public class mySqrt {

    public static int mySqrt(int x) {
        // For special cases when x is 0 or 1, return x.
        if (x == 0 || x == 1)
            return x;

        // Initialize the search range for the square root.
        int start = 1;
        int end = x;
        int mid;

        // Perform binary search to find the square root of x.
        while (start <= end) {
            mid = start + (end - start) / 2;

            if ((long) mid * mid > x) {
                end = mid - 1;
            } else if (mid * mid == x) {
                return mid;
            } else {
                start = mid + 1;
            }
        }

        // Return the integer square root (rounded down).
        return end;
    }

    public static void main(String[] args) {
        int x = 8;
        int result = mySqrt(x);
        System.out.println("The integer square root of " + x + " is: " + result); // Output: 2
    }
}

