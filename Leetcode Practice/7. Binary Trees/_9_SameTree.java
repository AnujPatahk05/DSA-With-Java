/*
    100. Same Tree
    (easy)

    Given the roots of two binary trees p and q, write a function to check if they are the same or not.

    Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

    Example:            p                   q

                        1                   1
                      /   \               /   \
                     2     3             2     3

    Output: true
*/

public class _9_SameTree {
    // TC: O(n)
    // SC: O(n)
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val &&
               isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        /*
                        p                   q

                        1                   1
                      /   \               /   \
                     2     3             2     3
        */

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(isSameTree(p, q));
    }
}
