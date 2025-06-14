import java.util.LinkedList;
import java.util.Queue;

public class SecondMinimumValue {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null) return -1;

        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);
        int secondMin = Integer.MAX_VALUE;
        int minVal = root.val;
        boolean found = false;

        while (!nodesQueue.isEmpty()) {
            TreeNode currentNode = nodesQueue.poll();

            if (currentNode.left != null) {
                nodesQueue.add(currentNode.left);
                nodesQueue.add(currentNode.right);

                if (currentNode.left.val > minVal) {
                    secondMin = Math.min(secondMin, currentNode.left.val);
                    found = true;
                }

                if (currentNode.right.val > minVal) {
                    secondMin = Math.min(secondMin, currentNode.right.val);
                    found = true;
                }
            }
        }

        return found ? secondMin : -1;
    }

    // Optional: test the method
    public static void main(String[] args) {
        SecondMinimumValue solver = new SecondMinimumValue();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println("Second Minimum Value: " + solver.findSecondMinimumValue(root));
    }
}

