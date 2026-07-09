/*
    83. Remove Duplicates from Sorted List
    (easy)

    Given the head of a sorted linked list, delete all duplicates such that each element appears only once. 
    Return the linked list sorted as well.

    Example 1:
    Input: head = [1,1,2]
    Output: [1,2]

    Example 2:
    Input: head = [1,1,2,3,3]
    Output: [1,2,3]
 
*/

public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode node = head;

        while(node != null && node.next != null) {
            if(node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 2 -> 3 -> 3
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(2);
        node1.next.next.next = new ListNode(3);
        node1.next.next.next.next = new ListNode(3);

        System.out.println(node1);
        System.out.println(deleteDuplicates(node1));

        System.out.println();

        // 1 -> 1 -> 3 -> 4 -> 4 -> 6
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(1);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(4);
        node2.next.next.next.next = new ListNode(4);
        node2.next.next.next.next.next = new ListNode(6);

        System.out.println(node2);
        System.out.println(deleteDuplicates(node2));

    }
}
