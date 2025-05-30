class Node {
    int val;
    Node left;
    Node right;
    Node(int val) { this.val = val; }
}

public class countNodes {
    private int height(Node root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    public int count(Node root) {
        int h = height(root);
        return h < 0 ? 0 :
                height(root.right) == h - 1 ? (1 << h) + count(root.right)
                        : (1 << (h - 1)) + count(root.left);
    }
}
