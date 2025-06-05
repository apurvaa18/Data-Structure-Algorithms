public class MaxProduct {
    public int maxProduct(int[] nums) {
        int firstMax = 0;
        int secondMax = 0;

        for (int num : nums) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else {
                secondMax = Math.max(secondMax, num);
            }
        }

        return (firstMax - 1) * (secondMax - 1);
    }

    // Optional main method for testing
    public static void main(String[] args) {
        MaxProduct solution = new MaxProduct();
        int[] nums = {3, 4, 5, 2};
        int result = solution.maxProduct(nums);
        System.out.println("Max product: " + result);  // Output: 12
    }
}
