// File: patchingarray.java

public class patchingarray {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int result = 0;
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        patchingarray obj = new patchingarray();
        int[] nums = {1, 3};
        int n = 6;
        int result = obj.minPatches(nums, n);
        System.out.println("Minimum patches required: " + result);
        // Expected output: 1
    }
}
