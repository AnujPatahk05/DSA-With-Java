/*
    61. Rotate List
    (Medium)

    Given the head of a linked list, rotate the list to the right by k places.

    Example 1:
    Input: head = [1,2,3,4,5], k = 2
    Output: [4,5,1,2,3]

    Example 2:
    Input: head = [0,1,2], k = 4
    Output: [2,0,1]
 
*/

public class _11_RotateList {
    private static int size(ListNode head) {
        int size = 0;
        while(head != null) {
            size ++;
            head = head.next;
        }
        return size;
    }

    // TC: O(n)
    // SC: O(1)
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        int size = size(head);

        k = k%size;

        if(k == 0) return head;

        ListNode temp = head;

        for(int i = 0;i < size - k - 1;i++) {
            temp = temp.next;
        } 

        ListNode newHead = temp.next;
        temp.next = null;

        temp = newHead;

        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = head;

        return newHead;
    }

    private static class Info {
        int size;
        ListNode lastNode;

        public Info(int size, ListNode lastNode ) {
            this.size = size;
            this.lastNode = lastNode;
        }
    }

    private static Info getSizeAndLastNode (ListNode head) {
        int size = 0;
        ListNode lastNode = null;

        while(head != null) {
            size++;
            lastNode = head;
            head = head.next;
        }

        return new Info(size,lastNode);
    }


    // TC: O(n)
    // SC: O(1)
    public static ListNode rotateRight2(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        Info info = getSizeAndLastNode(head);

        k = k%info.size;

        if(k == 0) return head;

        ListNode temp = head;

        for(int i = 0;i < info.size - k - 1;i++) {
            temp = temp.next;
        } 

        ListNode newHead = temp.next;
        temp.next = null;

        info.lastNode.next = head;

        return newHead;
    }


    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        System.out.println(node1);
        System.out.println(rotateRight2(node1, 1));

        System.out.println();

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(4);
        node2.next.next.next.next = new ListNode(5);
        node2.next.next.next.next.next = new ListNode(6);

        System.out.println(node2);
        System.out.println(rotateRight2(node2, 3));
    }
}