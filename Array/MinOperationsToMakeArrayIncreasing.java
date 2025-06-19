public class MinOperationsToMakeArrayIncreasing {

    public int minOperations(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];
        int count = 0;

        // Copy original array
        for (int i = 0; i < len; i++) {
            arr[i] = nums[i];
        }

        // Ensure each element is greater than the previous one
        for (int i = 0; i < len - 1; i++) {
            if (arr[i + 1] <= arr[i]) {
                arr[i + 1] = arr[i] + 1;
            }
        }

        // Calculate total operations
        for (int i = 0; i < len; i++) {
            count += arr[i] - nums[i];
        }

        return count;
    }

    public static void main(String[] args) {
        MinOperationsToMakeArrayIncreasing solution = new MinOperationsToMakeArrayIncreasing();
        int[] nums = {1, 1, 1};
        int result = solution.minOperations(nums);
        System.out.println("Minimum operations: " + result); // Output: 3
    }
}
