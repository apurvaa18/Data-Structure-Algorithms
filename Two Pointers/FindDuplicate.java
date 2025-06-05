public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect cycle
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }

        // Phase 2: Find entry point of the cycle
        int slow2 = nums[0];
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }

    // Optional: Main method for quick test
    public static void main(String[] args) {
        FindDuplicate solution = new FindDuplicate();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println("Duplicate number is: " + solution.findDuplicate(nums)); // Output: 2
    }
}
