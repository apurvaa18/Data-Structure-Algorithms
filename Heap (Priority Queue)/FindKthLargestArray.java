
import java.util.Arrays;

public class FindKthLargestArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // Optional main method for testing
    public static void main(String[] args) {
        FindKthLargestArray solution = new FindKthLargestArray();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = solution.findKthLargest(nums, k);
        System.out.println("Kth largest element: " + result);  // Output: 5
    }
}
