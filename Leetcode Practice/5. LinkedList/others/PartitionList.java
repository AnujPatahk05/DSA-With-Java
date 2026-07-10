/*
    86. Partition List
    (Medium)

    Given the head of a linked list and a value x, partition it such that all nodes less 
    than x come before nodes greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.

    Example 1:
    Input: head = [1,4,3,2,5,2], x = 3
    Output: [1,2,2,4,3,5]

    Example 2:
    Input: head = [2,1], x = 2
    Output: [1,2]
*/

public class PartitionList {
    // My Solution
    // TC: O(n)
    // SC: O(1)
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode smallerHead = null;
        ListNode greaterHead = null;
        
        ListNode smaller = dummy;
        ListNode greater  = dummy;

        while(smaller != null && smaller.next != null) {
            if(smaller.next.val < x) {
                if(smallerHead == null) smallerHead = smaller.next;
                smaller = smaller.next;
            } else {
                if(greaterHead == null) greaterHead = smaller.next;
                greater.next = smaller.next;
                greater = greater.next;
                smaller.next = smaller.next.next;
            }
        }
        
        greater.next = null;

        if(greaterHead == null) {
            return smallerHead;
        } 

        if(smallerHead == null) {
            return greaterHead;
        }

        smaller.next = greaterHead;
        return smallerHead;
    }

    // More clear solution (Best)
    // TC: O(n)
    // SC: O(1)
    public static ListNode partition2(ListNode head, int x) {
        ListNode smallerDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode smaller = smallerDummy;
        ListNode greater = greaterDummy;

        while (head != null) {
            if(head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        greater.next = null;
        smaller.next = greaterDummy.next;

        return smallerDummy.next;
    }

    public static void main(String[] args) {
        // 1 -> 4 ->  3 -> 2 -> 5 ->  2
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(2);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(2);

        System.out.println(node1);
        System.out.println(partition2(node1, 3));

        System.out.println();

        // 1 -> 2 -> 3 -> 3 -> null
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(3);

        System.out.println(node2);
        System.out.println(partition2(node2, -1));
    }
}
