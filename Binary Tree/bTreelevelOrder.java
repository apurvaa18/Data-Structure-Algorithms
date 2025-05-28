import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class bTreelevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> finalAns = new ArrayList<>();

        if (root == null) {
            return finalAns;
        }

        q.add(root);
        while (!q.isEmpty()) {
            int levels = q.size();
            List<Integer> subLevels = new ArrayList<>();

            for (int i = 0; i < levels; i++) {
                TreeNode current = q.remove();

                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }

                subLevels.add(current.val);
            }

            finalAns.add(subLevels);
        }

        return finalAns;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Construct sample tree:
        //       3
        //      / \
        //     9  20
        //        / \
        //       15  7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        bTreelevelOrder obj = new bTreelevelOrder();
        List<List<Integer>> result = obj.levelOrder(root);

        System.out.println("Level-order traversal: " + result);
    }
}
