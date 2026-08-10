/*
    173. Binary Search Tree Iterator
    (Medium)

    Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

    BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. 
    The pointer should be initialized to a non-existent number smaller than any element in the BST.

    boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
    int next() Moves the pointer to the right, then returns the number at the pointer.

    Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest 
    element in the BST.

    You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal 
    when next() is called.

 
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _6_BinarySearchTreeIterator {
    // Constructor : TC: O(n) 
    // next(): O(1)
    // hasNext(): O(1)
    // SC: O(n)
    class BSTIterator {
        List<Integer> nodes;
        int pointer;

        private void inorder(TreeNode root,List<Integer> nodes) {
            if (root == null) return;

            inorder(root.left,nodes);
            nodes.add(root.val);
            inorder(root.right,nodes);
        }

        public BSTIterator(TreeNode root) {
            nodes = new ArrayList<>();
            pointer = 0;

            inorder(root,nodes);
        }
        
        public int next() {
            return nodes.get(pointer++);
        }
        
        public boolean hasNext() {
            return pointer < nodes.size();
        }
    }

    // Constructor: O(h)
    // next() : O(1)
    // hasNext() : O(1)
    // SC: O(h)
    class BSTIterator2 {
        private class Node {
            TreeNode node;
            boolean left;

            Node (TreeNode node,boolean left) {
                this.node = node;
                this.left = left;
            }
        }

        Stack<Node> stack;

        public BSTIterator2(TreeNode root) {
            stack = new Stack<>();

            TreeNode left = root;
            while (left != null) {
                stack.push (new Node(left,true));
                left = left.left;
            }
        }
        
        public int next() {
            Node curr = stack.peek();

            if (!curr.left && curr.node.left != null) {
                curr.left = true;
                stack.push (new Node(curr.node.left,false));
                return next();
            }

            stack.pop();
            int next = curr.node.val;

            if (curr.node.right != null) {
                stack.push(new Node(curr.node.right,false));
            }

            return next;
        }
        
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    // More simple
    // Constructor: O(h)
    // next() : O(1)
    // hasNext() : O(1)
    // SC: O(h)
    class BSTIterator3 {
        private Stack<TreeNode> stack;

        public BSTIterator3(TreeNode root) {
            stack = new Stack<>();
            pushLeft(root);
        }

        private void pushLeft(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode curr = stack.pop();

            pushLeft(curr.right);

            return curr.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        
    }
}
