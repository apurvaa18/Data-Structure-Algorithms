public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int leftTotal = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightTotal = total - leftTotal - nums[i];
            if (rightTotal == leftTotal) {
                return i;
            }
            leftTotal += nums[i];
        }

        return -1;
    }

    // Optional: main method for quick testing
    public static void main(String[] args) {
        PivotIndex pi = new PivotIndex();
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println("Pivot Index: " + pi.pivotIndex(nums));
    }
}
