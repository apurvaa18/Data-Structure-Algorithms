public class SymmetricTree {

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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return isMirror(root.left, root.right);
        }

        private boolean isMirror(TreeNode n1, TreeNode n2) {
            if (n1 == null && n2 == null) {
                return true;
            }

            if (n1 == null || n2 == null) {
                return false;
            }

            return n1.val == n2.val &&
                    isMirror(n1.left, n2.right) &&
                    isMirror(n1.right, n2.left);
        }
    }

    // Optional: Main method for testing
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println("Tree is symmetric: " + solution.isSymmetric(root)); // Output: true
    }
}
