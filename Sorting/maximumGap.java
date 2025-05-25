public class maximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // Find the maximum number in nums
        int m = nums[0];
        for (int i = 1; i < nums.length; i++) {
            m = Math.max(m, nums[i]);
        }

        int exp = 1; // 1, 10, 100, 1000 ...
        int R = 10;  // base 10 digits

        int[] aux = new int[nums.length];

        while (m / exp > 0) { // Process all digits from LSB to MSB
            int[] count = new int[R];

            // Count occurrences of digits
            for (int i = 0; i < nums.length; i++) {
                count[(nums[i] / exp) % 10]++;
            }

            // Accumulate counts
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            // Build aux array in stable manner
            for (int i = nums.length - 1; i >= 0; i--) {
                aux[--count[(nums[i] / exp) % 10]] = nums[i];
            }

            // Copy aux back to nums
            for (int i = 0; i < nums.length; i++) {
                nums[i] = aux[i];
            }

            exp *= 10;
        }

        int max = 0;
        // Compute maximum gap between consecutive sorted elements
        for (int i = 1; i < aux.length; i++) {
            max = Math.max(max, aux[i] - aux[i - 1]);
        }

        return max;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        maximumGap mg = new maximumGap();
        int[] nums = {3, 6, 9, 1};
        System.out.println("Maximum gap is: " + mg.maximumGap(nums)); // Expected output: 3
    }
}
