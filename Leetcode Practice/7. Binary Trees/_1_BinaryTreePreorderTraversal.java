/*
    144. Binary Tree Preorder Traversal
    (easy)

    Given the root of a binary tree, return the preorder traversal of its nodes' values.

    Example:
                          1
                        /   \
                       2     3
                     /  \     \
                    4    5     8
                        / \   /
                       6   7 9

        
        Preorder : 1,2,4,5,6,7,3,8,9
*/

import java.util.ArrayList;
import java.util.List;

public class _1_BinaryTreePreorderTraversal {
    // Sol using recursion
    // TC: O(n)
    // SC: O(n)
    private static void preorderTraversal(TreeNode root,List<Integer> result) {
        if (root == null) return;

        result.add(root.val);
        preorderTraversal(root.left,result);
        preorderTraversal(root.right,result);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root,result);
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



        System.out.println(preorderTraversal(root));



    }
}
