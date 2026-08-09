/*
    99. Recover Binary Search Tree

    You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree 
    were swapped by mistake. Recover the tree without changing its structure.

    Example:

    Input:

            1
           /
          3
          \
           2

    Output:

            3
           /
          1
          \
           2
*/

import java.util.ArrayList;
import java.util.List;

public class _5_RecoverBinarySearchTree {
    public static void inorder(TreeNode root,List<TreeNode> nodes) {
        if (root == null) return;

        inorder(root.left,nodes);
        nodes.add(root);
        inorder(root.right,nodes);
    }

    // TC: O(n)
    // SC: O(n)
    public static void recoverTree(TreeNode root) {
       List<TreeNode> nodes = new ArrayList<>();
       
       inorder(root,nodes);

       TreeNode first = null;
       TreeNode second = null;

       for (int i = 1;i < nodes.size();i++) {
            if (nodes.get(i - 1).val > nodes.get(i).val) {
                if (first == null) {
                    first = nodes.get(i - 1);
                }
                second = nodes.get(i);
            }
       }

       int temp = first.val;
       first.val = second.val;
       second.val = temp;
    }

    public static void main(String[] args) {
        
    }
}
