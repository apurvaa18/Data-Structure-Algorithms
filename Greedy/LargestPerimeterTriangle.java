import java.util.Arrays;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 1; i > 1; i--) {
            // Triangle inequality check
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }

        return 0;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        LargestPerimeterTriangle solution = new LargestPerimeterTriangle();
        int[] nums = {2, 1, 2};
        System.out.println("Largest Perimeter: " + solution.largestPerimeter(nums));
    }
}
