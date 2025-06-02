import java.util.Arrays;

public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i]; // sum of min values in pairs
        }

        return sum;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        ArrayPairSum solution = new ArrayPairSum();
        int[] nums = {1, 4, 3, 2};
        int result = solution.arrayPairSum(nums);
        System.out.println("Maximized sum of min pairs: " + result); // Output: 4
    }
}
