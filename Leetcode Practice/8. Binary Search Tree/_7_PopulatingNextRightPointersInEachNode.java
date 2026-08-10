/*
    116. Populating Next Right Pointers in Each Node
    (Medium)

    You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. 
    The binary tree has the following definition:

    struct Node {
    int val;
    Node *left;
    Node *right;
    Node *next;
    }
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should 
    be set to NULL.

    Initially, all next pointers are set to NULL.
*/

import java.util.ArrayDeque;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class _7_PopulatingNextRightPointersInEachNode {
    // Using BFS
    // TC: O(n)
    // SC: O(n)
    public static Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;

            for (int i = 0;i < size;i++) {
                Node curr = queue.remove();

                if (prev != null) {
                    prev.next = curr;
                }

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);

                prev = curr;
            }
        }

        return root;
    }

    // TC: O(n)
    // SC: O(1)
    public static Node connect2(Node root) {
        if (root == null) return null;

        Node left = root;

        while (left != null && left.left != null) {
            Node curr = left;

            while (curr != null) {
                curr.left.next = curr.right;
                
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }

                curr = curr.next;
            }

            left = left.left;
        }

        return root;
    }

    public static void main(String[] args) {
        
    }
}
