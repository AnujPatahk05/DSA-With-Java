/*
    430. Flatten a Multilevel Doubly Linked List
    (Medium)

    You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. 
    This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may 
    have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.

    Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. 
    Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.

    Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.

    Example 1:

    Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]

    1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

    Output: [1,2,3,7,8,11,12,9,10,4,5,6]

    1 - 2 - 3 - 7 - 8 - 11 - 12 - 9 - 10 - 4 - 5 - 6

    Explanation: The multilevel linked list in the input is shown.
    After flattening the multilevel linked list it becomes:
*/

import java.util.Stack;

public class _6_FlattenAMultilevelDoublyLinkedList {
    // TC: O(n)
    // SC: O(n)
    
    public static Node flatten(Node head) {
        if(head == null) return head;

        Stack<Node> stack = new Stack<>();

        Node node = head;
        while(node.child != null || node.next != null) {
            if(node.child != null) {
                if(node.next != null) stack.push(node.next);
                node.next = node.child;
                node.next.prev = node;
                node.child = null;
                continue;
            }
            node = node.next;
        }

        while(!stack.isEmpty()) {
            Node pop = stack.pop();
            pop.prev = node;
            node.next = pop;
            while(node.next != null) {
                node = node.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        /*
            1---2---3---4---5---6--NULL
                    |
                    7---8---9---10--NULL
                        |
                        11--12--NULL
        */


        Node n1 = new Node();  n1.val = 1;
        Node n2 = new Node();  n2.val = 2;
        Node n3 = new Node();  n3.val = 3;
        Node n4 = new Node();  n4.val = 4;
        Node n5 = new Node();  n5.val = 5;
        Node n6 = new Node();  n6.val = 6;

        Node n7 = new Node();  n7.val = 7;
        Node n8 = new Node();  n8.val = 8;
        Node n9 = new Node();  n9.val = 9;
        Node n10 = new Node(); n10.val = 10;

        Node n11 = new Node(); n11.val = 11;
        Node n12 = new Node(); n12.val = 12;

        // Main list: 1-2-3-4-5-6
        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;
        n5.next = n6; n6.prev = n5;

        // Child list: 7-8-9-10
        n7.next = n8; n8.prev = n7;
        n8.next = n9; n9.prev = n8;
        n9.next = n10; n10.prev = n9;

        // Child list: 11-12
        n11.next = n12; n12.prev = n11;

        // Connect child pointers
        n3.child = n7;
        n8.child = n11;

        Node head = n1;

        Node output = flatten(head); // Expected output: 1 2 3 7 8 11 12 9 10 4 5 

        while (output.next != null) {
            System.out.print(output.val + " ");
            output = output.next;
        }
}
}



/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}