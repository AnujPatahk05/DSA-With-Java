/*
    143. Reorder List
    (Medium)

    You are given the head of a singly linked-list. The list can be represented as:

    L0 → L1 → … → Ln - 1 → Ln
    Reorder the list to be on the following form:

    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    You may not modify the values in the list's nodes. Only nodes themselves may be changed.

    Example 1:
    Input: head = [1,2,3,4]
    Output: [1,4,2,3]

    Example 2:
    Input: head = [1,2,3,4,5]
    Output: [1,5,2,4,3]
*/

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    // Solution : by storing all nodes in a List and then reordering 
    // TC: O(n)
    // SC: O(n)
    public static void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode node = head;

        while(node != null) {
            nodes.add(node);
            node = node.next;
        }

        int i = 0;
        int j = nodes.size() - 1;

        while(i < j) {
            if(i != 0) {
                head.next = nodes.get(i);
                head = head.next;
            }

            head.next = nodes.get(j);
            head = head.next;

            i++;
            j--;
        }

        if(i == j) {
            head.next = nodes.get(i);
            head = head.next;
        }

        head.next = null;
    }


    private static ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        return slow;
    }

    // Optimal solution: Reverse second half and then reorder
    // TC: O(n)
    // SC: O(1)
    public static void reorderList2(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode mid = midNode(head);

        ListNode prev = null;
        ListNode curr = mid.next;
        ListNode next;

        mid.next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        while (head != null && prev != null) {
            ListNode nextToHead = head.next;
            ListNode nextToPrev = prev.next;

            head.next = prev;
            prev.next = nextToHead;

            head = nextToHead;
            prev = nextToPrev;
        }

    }

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        System.out.println(node1);
        reorderList(node1);
        System.out.println(node1);
    }
}