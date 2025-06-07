import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node() {
        this.val = 0;
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class allPossibleFBT {
    static Map<Integer, List<Node>> saved = new HashMap<>();

    public List<Node> allPossibleFBT(int n) {
        if (n % 2 == 0)
            return new ArrayList<>();

        if (!saved.containsKey(n)) {
            List<Node> list = new ArrayList<>();

            if (n == 1)
                list.add(new Node(0));
            else {
                for (int i = 1; i <= n - 1; i += 2) {
                    List<Node> lTrees = allPossibleFBT(i);
                    List<Node> rTrees = allPossibleFBT(n - i - 1);

                    for (Node lt : lTrees) {
                        for (Node rt : rTrees) {
                            list.add(new Node(0, lt, rt));
                        }
                    }
                }
            }

            saved.put(n, list);
        }
        return saved.get(n);
    }
}
