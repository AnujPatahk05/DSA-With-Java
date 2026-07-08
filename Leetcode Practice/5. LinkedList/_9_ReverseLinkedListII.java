/*
    92. Reverse Linked List II
    (Medium)

    Given the head of a singly linked list and two integers left and right where left <= right, 
    reverse the nodes of the list from position left to position right, and return the reversed list.

    Example 1:
    Input: head = [1,2,3,4,5], left = 2, right = 4
    Output: [1,4,3,2,5]

    Example 2:
    Input: head = [5], left = 1, right = 1
    Output: [5]
*/

public class _9_ReverseLinkedListII {
    // TC: O(n)
    // SC: O(n)
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode beforeLeftNode = dummy;
        for(int i = 0;i < left-1;i++) {
            beforeLeftNode = beforeLeftNode.next;
        }

        ListNode leftNode = beforeLeftNode.next;

        ListNode prev = null;
        ListNode curr = leftNode;
        ListNode next;

        for(int i = 0;i < right - left + 1;i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        beforeLeftNode.next = prev;    
        leftNode.next = curr;    

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
        System.out.println(reverseBetween(node1, 1, 4)+"\n");

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(4);
        node2.next.next.next.next = new ListNode(5);
        node2.next.next.next.next.next = new ListNode(6);

        System.out.println(node2);
        System.out.println(reverseBetween(node2, 2, 4));
    }
}
