import java.util.*;

public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isForward = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> levelArr = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (isForward) {
                    levelArr.addLast(node.val);
                } else {
                    levelArr.addFirst(node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            ans.add(levelArr);
            isForward = !isForward;
        }

        return ans;
    }
}
