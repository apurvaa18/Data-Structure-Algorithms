// Definition for a binary tree node.
class TNode {
    int val;
    TNode left;
    TNode right;

    TNode() {}

    TNode(int val) {
        this.val = val;
    }

    TNode(int val, TNode left, TNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SortedArrayToBST {

    public static TNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static TNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TNode root = new TNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    // Optional: method to print tree in-order for testing
    public static void printInOrder(TNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TNode bstRoot = sortedArrayToBST(nums);
        printInOrder(bstRoot); // Expected Output: -10 -3 0 5 9
    }
}
