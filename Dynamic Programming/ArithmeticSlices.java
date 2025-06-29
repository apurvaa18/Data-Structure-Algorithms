public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = 0;
        int diff = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int innerDiff = nums[i + 1] - nums[i];
            if (diff != innerDiff) {
                ans += (n * (n + 1)) / 2;
                n = 0;
                diff = innerDiff;
            } else {
                n++;
            }
        }

        ans += (n * (n + 1)) / 2;
        return ans;
    }

    public static void main(String[] args) {
        ArithmeticSlices solution = new ArithmeticSlices();

        int[] nums = {1, 2, 3, 4, 6, 8, 10}; // Expected arithmetic slices = 3 (1-2-3, 2-3-4, 6-8-10)
        int result = solution.numberOfArithmeticSlices(nums);

        System.out.println("Number of arithmetic slices: " + result);
    }
}
