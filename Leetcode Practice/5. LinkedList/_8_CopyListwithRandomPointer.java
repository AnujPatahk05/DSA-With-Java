/*
    138. Copy List with Random Pointer
    (Medium)

    A linked list of length n is given such that each node contains an additional random pointer, 
    which could point to any node in the list, or null.

    Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, 
    where each new node has its value set to the value of its corresponding original node. 
    Both the next and random pointer of the new nodes should point to new nodes in the copied list 
    such that the pointers in the original list and copied list represent the same list state. None 
    of the pointers in the new list should point to nodes in the original list.

    For example, if there are two nodes X and Y in the original list, where X.random --> Y, 
    then for the corresponding two nodes x and y in the copied list, x.random --> y.

    Return the head of the copied linked list.

    The linked list is represented in the input/output as a list of n nodes. Each node is represented 
    as a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null 
    if it does not point to any node.
    Your code will only be given the head of the original linked list.

    Example 1:
    Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
    Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _8_CopyListwithRandomPointer {
     private static int indexOf(Node head,Node node) {
        int idx = 0;
        while(head != null) {
            if(head == node) {
                return idx;
            }
            head = head.next;
            idx++;
        }
        return -1;
    }

    // TC: O(n^2)
    // SC: O(n)
    public static Node copyRandomList(Node head) {
        if(head == null) return null;

        List<Integer> indexes = new ArrayList<>();
        Node node = head;

        while(node != null) {
            indexes.add(indexOf(head,node.random));
            node = node.next;
        }

        System.out.println(indexes);

        node = head.next;
        Node newHead = new Node(head.val);
        Node temp = newHead;

        List<Node> nodes = new ArrayList<>();
        nodes.add(newHead);

        while(node != null) {
            temp.next = new Node(node.val);
            nodes.add(temp.next);
            node = node.next;
            temp = temp.next;
        }

        temp = newHead;
        for(int i = 0;i < nodes.size();i++) {
            temp.random = indexes.get(i) != -1 ? nodes.get(indexes.get(i)) : null;
            temp = temp.next;
        }

        return newHead;
    }

    // Optimal Sol: 
    // HashMap approach : key: oldNode, value: newNode
    // TC: O(n)
    // SC: O(n)
    public static Node copyRandomList2(Node head) {
        if(head == null) return null;

        Node newHead = new Node(head.val);

        HashMap<Node,Node> map = new HashMap<>();
        
        Node temp1 = head.next;
        Node temp2 = newHead;

        map.put(head,newHead);

        while (temp1 != null) {
            temp2.next = new Node(temp1.val);

            temp2 = temp2.next;
            map.put(temp1,temp2);

            temp1 = temp1.next;
        }

        
        temp1 = head;
        temp2 = newHead;

        while (temp1 != null) {
            temp2.random = map.get(temp1.random);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return newHead;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node head = node1;  

        Node newHead = copyRandomList2(head);

        while(newHead != null) {
            System.out.println(newHead.val + " "+ "random: " +( newHead.random == null ? null : newHead.random.val));
            newHead = newHead.next;
        }

    }   
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
