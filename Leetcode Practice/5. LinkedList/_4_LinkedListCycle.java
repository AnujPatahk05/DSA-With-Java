/*
    141. Linked List Cycle (Cycle detection)
    (easy)

    Given head, the head of a linked list, determine if the linked list has a cycle in it.

    There is a cycle in a linked list if there is some node in the list that can be reached 
    again by continuously following the next pointer. Internally, pos is used to denote the index of the 
    node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

    Return true if there is a cycle in the linked list. Otherwise, return false.
    
    Example 1:

    Input: head = [3,2,0,-4], pos = 1
    Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
*/

public class _4_LinkedListCycle {
    // Slow - fast pointer approach
    // TC: O(n)
    // SC: O(1)
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        /*
                3 -> 2 -> 0 -> -4 
                     |          |
                      -----------
        
        */

        ListNode node1 = new ListNode(3);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(0);
        node1.next.next.next = new ListNode(-4);
        node1.next.next.next.next = node1.next;

        System.out.println(hasCycle(node1));

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(4);
        node2.next.next.next.next = new ListNode(5);
        node2.next.next.next.next.next = new ListNode(6);

        System.out.println(hasCycle(node2));
    }
}
