public class ValidBST {

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
        private boolean isValid = true;
        private TreeNode pre = null;

        public boolean isValidBST(TreeNode root) {
            helper(root);
            return isValid;
        }

        private void helper(TreeNode root) {
            if (root == null)
                return;

            helper(root.left);

            if (pre != null && pre.val >= root.val) {
                isValid = false;
                return;
            }

            pre = root;

            helper(root.right);
        }
    }

    // Optional: Main method for testing
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println("Is valid BST: " + solution.isValidBST(root)); // Output: true

        TreeNode invalidRoot = new TreeNode(5);
        invalidRoot.left = new TreeNode(1);
        invalidRoot.right = new TreeNode(4);
        invalidRoot.right.left = new TreeNode(3);
        invalidRoot.right.right = new TreeNode(6);

        System.out.println("Is valid BST: " + solution.isValidBST(invalidRoot)); // Output: false
    }
}

