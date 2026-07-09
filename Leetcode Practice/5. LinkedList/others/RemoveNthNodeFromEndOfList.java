/*
    19. Remove Nth Node From End of List
    (Medium)

    Given the head of a linked list, remove the nth node from the end of the list and return its head.

    Example 1:
    Input: head = [1,2,3,4,5], n = 2
    Output: [1,2,3,5]

    Example 2:
    Input: head = [1], n = 1
    Output: []
*/

public class RemoveNthNodeFromEndOfList {
    // Finding size of linked list
    // TC: O(n)
    // SC: O(1)
    private static int size(ListNode head) {
        int size = 0;
        while(head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    // Removal is done in two pass
    // First find size of list: O(n)
    // Then traverse to the node before the node to be removed: O(n)
    // TC: O(n) + O(n) = O(n) 
    // SC: O(1)
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        int size = size(head);

        if(size == n) return head.next;

        ListNode node = head;

        for(int i = 0;i < size - n - 1;i++) {
            node = node.next;
        }

        node.next = node.next.next;

        return head;
    }

    // Two pointer approach (One pass approach)
    // slow fast pointer
    // TC: O(n)
    // SC: O(1)
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast != null) {
            if(n-- < 0) slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;

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
        System.out.println(removeNthFromEnd2(node1, 3));
    }
}
