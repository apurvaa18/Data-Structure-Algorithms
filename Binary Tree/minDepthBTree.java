public class minDepthBTree {

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
        public int minDepth(TreeNode root) {
            if (root == null) return 0;

            // If left subtree is null, recurse on right
            if (root.left == null) {
                return 1 + minDepth(root.right);
            }

            // If right subtree is null, recurse on left
            if (root.right == null) {
                return 1 + minDepth(root.left);
            }

            // If both children exist, return the min depth of the two subtrees
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }

    // Optional: Main method for testing
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        Solution solution = new Solution();
        System.out.println("Minimum depth of the binary tree: " + solution.minDepth(root)); // Output: 2
    }
}
