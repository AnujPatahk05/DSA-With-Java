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

public class _6_BinarySearchTreeIterator {
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

    public static void main(String[] args) {
        
    }
}
