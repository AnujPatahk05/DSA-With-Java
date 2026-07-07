/*
    142. Linked List Cycle II
    (Medium)

    Given the head of a linked list, return the node where the cycle begins. If there is no cycle, 
    return null.

    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously 
    following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is 
    connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

    Do not modify the linked list.

    Example 1:

    Input: head = [3,2,0,-4], pos = 1
    Output: tail connects to node index 1
    Explanation: There is a cycle in the linked list, where tail connects to the second node.
*/

public class _3_LinkedListCycleII {
    // Slow - fast pointer approach
    // TC: O(n)
    // SC: O(1)
    public static ListNode detectCycle(ListNode head) {
        boolean isCycle = false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                isCycle = true;
                break;
            }
        }

        if(!isCycle) return null;

        slow = head;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
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

        System.out.println(detectCycle(node1).value);
    }
}
