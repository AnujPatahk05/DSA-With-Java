/*
    94. Binary Tree Inorder Traversal
    (easy)

    Given the root of a binary tree, return the inorder traversal of its nodes' values.

    Example:
                          1
                        /   \
                       2     3
                     /  \     \
                    4    5     8
                        / \   /
                       6   7 9

        
        Inorder : 4 2 6 5 7 1 3 9 8
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _2_BinaryTreeInorderTraversal {
    // Recursion approach:
    // TC: O(n)
    // SC: O(h)
    private static void inorderTraversal(TreeNode root,List<Integer> result) {
        if (root == null) return;

        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right,result);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    // Iteration approach using stack
    // TC: O(n)
    // SC: O(h) -> extra stack
    //      here h is height of the tree
    //      if tree is skewed then n = h, SC: O(n)
    //      if tree is balanced then n = log n, SC: O(log n)
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null ||!stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            result.add(curr.val);

            curr = curr.right;
        }

        return result;
    }

    public static void main(String[] args) {
        
/*
                          1
                        /   \
                       2     3
                     /  \     \
                    4    5     8
                        / \   /
                       6   7 9

*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);

        System.out.println(inorderTraversal(root));
        System.out.println(inorderTraversal2(root));

    }
}
