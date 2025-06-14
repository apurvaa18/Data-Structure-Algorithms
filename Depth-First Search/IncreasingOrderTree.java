import java.util.ArrayList;

public class IncreasingOrderTree {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void inorder(ArrayList<TreeNode> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(ans, root.left);
        ans.add(root);
        inorder(ans, root.right);
    }

    public static TreeNode tree(ArrayList<TreeNode> ans, int i) {
        if (i == ans.size()) {
            return null;
        }
        TreeNode root = ans.get(i);
        root.left = null;
        root.right = tree(ans, i + 1);
        return root;
    }

    public TreeNode increasingBST(TreeNode root) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        inorder(ans, root);
        return tree(ans, 0);
    }

    // Optional: testing
    public static void main(String[] args) {
        IncreasingOrderTree solver = new IncreasingOrderTree();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);
        root.left.left.left = new TreeNode(1);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        TreeNode result = solver.increasingBST(root);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.right;
        }
    }
}
