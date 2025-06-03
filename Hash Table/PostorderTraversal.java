import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    public static List<Integer> postorderTraversal(Node root) {
        Stack<Node> s = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        Node cur = root;

        while (cur != null || !s.isEmpty()) {
            while (!isLeaf(cur)) {
                s.push(cur);
                cur = cur.left;
            }

            if (cur != null) ans.add(cur.val);

            while (!s.isEmpty() && cur == s.peek().right) {
                cur = s.pop();
                ans.add(cur.val);
            }

            cur = s.isEmpty() ? null : s.peek().right;
        }

        return ans;
    }

    private static boolean isLeaf(Node r) {
        if (r == null) return true;
        return r.left == null && r.right == null;
    }
}
