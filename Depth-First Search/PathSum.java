public class PathSum {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;

            // If it's a leaf node, check if the path sum equals the target
            if (root.left == null && root.right == null) {
                return root.val == targetSum;
            }

            // Recursively check the left and right subtrees with the reduced sum
            int remainingSum = targetSum - root.val;
            return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
        }
    }

    // Optional: Main method for testing
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        Solution solution = new Solution();
        int targetSum = 22;
        System.out.println("Has path sum " + targetSum + ": " + solution.hasPathSum(root, targetSum)); // Output: true
    }
}
