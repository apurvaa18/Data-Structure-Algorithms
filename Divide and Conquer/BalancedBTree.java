public class BalancedBTree {

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
        public boolean isBalanced(TreeNode root) {
            int[] result = dfs(root);
            return result[0] == 1;
        }

        private int[] dfs(TreeNode node) {
            if (node == null) return new int[]{1, 0}; // {isBalanced, height}

            int[] left = dfs(node.left);
            int[] right = dfs(node.right);

            boolean isBalanced = left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1;

            return new int[]{isBalanced ? 1 : 0, 1 + Math.max(left[1], right[1])};
        }
    }

    // Optional: Main method for testing
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        Solution solution = new Solution();
        System.out.println("Tree is balanced: " + solution.isBalanced(root)); // Output: false
    }
}
