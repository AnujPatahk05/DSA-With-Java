
import java.util.ArrayList;
import java.util.List;

/*
    783. Minimum Distance Between BST Nodes
    (easy)

    Given the root of a Binary Search Tree (BST), return the minimum difference 
    between the values of any two different nodes in the tree.


*/

public class _6_MinimumDistanceBetweenBSTNodes {
    private static void inorder(TreeNode root,List<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    /*
        Performs an inorder traversal.
        Stores values in sorted order (property of BST).
        Computes the minimum difference between consecutive values.
        Returns the correct answer.

        TC: O(n)
        SC: O(n) => store inorder -> O(n)
                    Find inorder -> O(h)
    */
    public static int minDiffInBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        List<Integer> inorder = new ArrayList<>();
        inorder(root,inorder);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1;i < inorder.size();i++) {
            minDiff = Math.min(minDiff,inorder.get(i) - inorder.get(i-1));
        }

        return minDiff;
    }

    private static Integer prev = null;
    private static int minDiff = Integer.MAX_VALUE;


    private static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null) {
            minDiff = Math.min(minDiff,root.val - prev);
        }

        prev = root.val;

        inorder(root.right);
    }
    
    /*
        Best Solution:
        Directly tracking prev without storing inorder
        TC: O(n)
        SC: O(h)
    */
    public static int minDiffInBST2(TreeNode root) {
        prev = null;
        minDiff = Integer.MAX_VALUE;

        inorder(root);

        return minDiff;
    }
    

    public static void main(String[] args) {
        /*
                    4
                  /   \
                 2     6
                / \
               1   3
        */

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);

        System.out.println(minDiffInBST(root));
        System.out.println(minDiffInBST2(root));
    }
}
