class Node {
    int val;
    Node next;
    Node(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public static boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Create a linked list with a cycle:
        // 3 -> 2 -> 0 -> -4
        //      ^         |
        //      |_________|
        Node head = new Node(3);
        Node node2 = new Node(2);
        Node node0 = new Node(0);
        Node nodeMinus4 = new Node(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = nodeMinus4;
        nodeMinus4.next = node2; // Creates the cycle

        boolean result = hasCycle(head);
        System.out.println("Has cycle? " + result);
    }
}
