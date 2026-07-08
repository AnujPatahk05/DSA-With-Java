/*
    25. Reverse Nodes in k-Group
    (Hard)

    Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

    k is a positive integer and is less than or equal to the length of the linked list. 
    If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

    You may not alter the values in the list's nodes, only nodes themselves may be changed.

    Example 1:
    Input: head = [1,2,3,4,5], k = 2
    Output: [2,1,4,3,5]

    Example 2:
    Input: head = [1,2,3,4,5], k = 3
    Output: [3,2,1,4,5]
*/

public class _10_Reverse_Nodes_In_k_Group {
    // Finding size of LinkedList 
    // TC: O(n)
    // SC: O(1)
    private static int size(ListNode head) {
        int idx = 0;
        while(head != null) {
            head = head.next;
            idx++;
        }
        return idx;
    }

    // Compute the length. O(n)
    // Reverse exactly size / k groups. O(n)
    // TC: O(n) + O(n) = O(n)
    // SC: O(1)
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;

        int size = size(head);

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode beforeLeft = dummy;
        ListNode left = head;

        for(int i = 0;i < size/k;i++) {
            ListNode prev = null;
            ListNode curr = left;
            ListNode next;

            for(int j = 0;j < k;j++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            beforeLeft.next = prev;
            left.next = curr;

            beforeLeft = left;
            left = curr;
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
        System.out.println(reverseKGroup(node1, 3));

        System.out.println();

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(4);
        node2.next.next.next.next = new ListNode(5);
        node2.next.next.next.next.next = new ListNode(6);

        System.out.println(node2);
        System.out.println(reverseKGroup(node2, 2));
    }
}
