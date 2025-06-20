public class LinkedListCycleDetector {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    // Sample usage and cycle creation
    public static void main(String[] args) {
        LinkedListCycleDetector detector = new LinkedListCycleDetector();

        // Creating a linked list: 3 -> 2 -> 0 -> -4 -> back to 2 (cycle)
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;  // Cycle here

        boolean result = detector.hasCycle(head);
        System.out.println("Has Cycle: " + result); // Expected: true
    }
}

