public class SameTree {

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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            // Base case: if both trees are null, they are identical
            if (p == null && q == null) {
                return true;
            }
            // If only one tree is null or the values are different, they are not identical
            if (p == null || q == null || p.val != q.val) {
                return false;
            }
            // Recursively check if the left and right subtrees are identical
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    // Optional: Main method for testing
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println("Trees are the same: " + solution.isSameTree(tree1, tree2)); // Output: true
    }
}

