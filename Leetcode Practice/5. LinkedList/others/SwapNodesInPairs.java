/*
    24. Swap Nodes in Pairs
    (Medium)

    Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in 
    the list's nodes (i.e., only nodes themselves may be changed.)

    Example:
    Input: head = [1,2,3,4]
    Output: [2,1,4,3]
*/

public class SwapNodesInPairs {
    // Two pointer approach
    // TC: O(n)
    // SC: O(1)
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode one = head;

        while(one != null && one.next != null) {
            ListNode two = one.next;
            ListNode nextOne = two.next;

            two.next = one;
            prev.next = two;
            one.next = nextOne;

            prev = one;
            one = nextOne;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        System.out.println(node1);
        System.out.println(swapPairs(node1));
    }
}
