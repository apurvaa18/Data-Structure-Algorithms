import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {

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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<>();
            if (root != null) {
                dfs(root, "", paths);
            }
            return paths;
        }

        private void dfs(TreeNode node, String path, List<String> paths) {
            if (node.left == null && node.right == null) {
                paths.add(path + node.val);
                return;
            }
            if (node.left != null) {
                dfs(node.left, path + node.val + "->", paths);
            }
            if (node.right != null) {
                dfs(node.right, path + node.val + "->", paths);
            }
        }
    }

    // Optional: Main method for testing
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        Solution solution = new Solution();
        List<String> result = solution.binaryTreePaths(root);
        System.out.println("Binary Tree Paths: " + result); // Output: [1->2->5, 1->3]
    }
}
