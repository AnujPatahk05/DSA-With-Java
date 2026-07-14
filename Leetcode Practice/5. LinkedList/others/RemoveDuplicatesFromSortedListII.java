public class RemoveDuplicatesFromSortedListII {
    private static ListNode nextNode(ListNode node) {
        int val = node.val;

        if(node.next == null || node.val != node.next.val) {
            return node;
        }

        while(node != null && node.val == val) {
            node = node.next;
        }

        return node;
    }   

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node = dummy;

        while (node != null && node.next != null) {
            ListNode next = nextNode(node.next);
            node.next = next;

            if (next == null || next.next == null) break;

            if (next.val != next.next.val) {
                node = node.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // 1 -> 1 -> 3 -> 4 -> 4 -> 6
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(9);
        node2.next.next.next.next = new ListNode(9);
        // node2.next.next.next.next.next = new ListNode(3);

        System.out.println(node2);
        System.out.println(deleteDuplicates(node2));
    }

}
