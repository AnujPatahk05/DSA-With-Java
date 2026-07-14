/*
    145. Binary Tree Postorder Traversal
    (easy)

    Given the root of a binary tree, return the postorder traversal of its nodes' values.

    Example:
                          1
                        /   \
                       2     3
                     /  \     \
                    4    5     8
                        / \   /
                       6   7 9

        
    Postorder : 4 6 7 5 2 9 8 3 1
*/

import java.util.ArrayList;
import java.util.List;

public class _3_BinaryTreePostorderTraversal {
    // Recursion approach:
    // TC: O(n)
    // SC: O(h) -> Recursion stack
    //      here h is height of the tree
    //      if tree is skewed then n = h, SC: O(n)
    //      if tree is balanced then n = log n, SC: O(log n)
    private static void postorderTraversal(TreeNode root,List<Integer> result) {
        if (root == null) return;

        postorderTraversal(root.left,result);
        postorderTraversal(root.right,result);
        result.add(root.val);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root,result);
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

        System.out.println(postorderTraversal(root));
    }
}
