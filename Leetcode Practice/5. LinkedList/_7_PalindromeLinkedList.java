/*
    234. Palindrome Linked List
    (easy)

    Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

    Example 1:
    Input: head = [1,2,2,1]
    Output: true

    Example 2:
    Input: head = [1,2]
    Output: false
*/

import java.util.ArrayList;
import java.util.List;

public class _7_PalindromeLinkedList {
    // Store elements in array list then check for palindrome
    // TC: O(n)
    // SC: O(n)
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }

        for(int i = 0;i < list.size()/2;i++) {
            if(!list.get(i).equals(list.get(list.size()-i-1))) {
                return false;
            }
        }

        return true;
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

    // Reverse second half , then check for palindrome
    // TC:
    // SC:
    public static boolean isPalindrome2(ListNode head) {
        // Find Mid node
        ListNode mid = midNode(head);

        // Reverse second half
        ListNode prev = null;
        ListNode curr = mid;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Compare left half and right half
        ListNode left = head;
        ListNode right = prev;

        boolean isPalindrome = true;

        while (right != null) {
            if(left.val != right.val) {
                isPalindrome = false;
                break;
            }
            left = left.next;
            right = right.next;
        }

        //4. Restoring the second half

        curr = prev;
        prev = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return isPalindrome;
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 2 -> 1
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(2);
        node1.next.next.next.next = new ListNode(1);

        System.out.println(node1);
 
        // 1 -> 2 -> 3 -> 3 -> 2 -> 1
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(3);
        node2.next.next.next.next = new ListNode(2);
        node2.next.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome2(node2));

    }
}
