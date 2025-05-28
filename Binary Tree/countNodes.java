public class countNodes {

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
        int height(TreeNode root) {
            return root == null ? -1 : 1 + height(root.left);
        }

        public int countNodes(TreeNode root) {
            int h = height(root);
            if (h < 0) return 0;

            if (height(root.right) == h - 1) {
                return (1 << h) + countNodes(root.right); // left is full
            } else {
                return (1 << (h - 1)) + countNodes(root.left); // right is full
            }
        }
    }

    // Optional: Main method for testing
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        Solution solution = new Solution();
        System.out.println("Number of nodes: " + solution.countNodes(root)); // Output: 6
    }
}
