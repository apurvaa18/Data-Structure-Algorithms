// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class MaximumBinaryTree {

    // Helper to find maximum value and its index in a subarray
    public int[] find(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = start; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return new int[]{max, index};
    }

    // Recursively build the tree
    public TreeNode helper(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }

        int[] maxInfo = find(nums, start, end);
        int index = maxInfo[1];

        TreeNode root = new TreeNode(nums[index]);
        root.left = helper(nums, start, index);
        root.right = helper(nums, index + 1, end);

        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    // Optional: Test method
    public static void main(String[] args) {
        MaximumBinaryTree solution = new MaximumBinaryTree();
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = solution.constructMaximumBinaryTree(nums);
        System.out.println("Tree constructed successfully.");
    }
}

