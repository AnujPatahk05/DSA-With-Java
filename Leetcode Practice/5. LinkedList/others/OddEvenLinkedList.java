/*
    328. Odd Even Linked List
    (Medium)

    Given the head of a singly linked list, group all the nodes with odd indices together followed 
    by the nodes with even indices, and return the reordered list.

    The first node is considered odd, and the second node is even, and so on.

    Note that the relative order inside both the even and odd groups should remain as it was in the input.

    You must solve the problem in O(1) extra space complexity and O(n) time complexity.

    Example 1:
    Input: head = [1,2,3,4,5]
    Output: [1,3,5,2,4]

    Example 2:
    Input head = [2,1,3,5,6,4,7]
    Output: [2,3,6,7,1,5,4]
*/

public class OddEvenLinkedList {
    // My sol
    // TC: O(n)
    // SC: O(1)
    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;

        ListNode evenHead = even;

        while(even != null && even.next != null && odd != null && odd.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

        
            odd = odd.next;

            if(even.next == null) {
                even.next = null;
                break;
            }
            even = even.next;
        }

        if(odd.next != null) {
            odd.next = null;
        }

        odd.next = evenHead;
        
        return head;
    }

    // Cleaner code
    // TC: O(n)
    // SC: O(1)
    public static ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);


        System.out.println(node1);
        System.out.println(oddEvenList(node1));
    }
}
