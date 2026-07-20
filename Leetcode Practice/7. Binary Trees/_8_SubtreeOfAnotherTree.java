/*
    572. Subtree of Another Tree
    (easy)

    Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure 
    and node values of subRoot and false otherwise.

    A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. 
    The tree tree could also be considered as a subtree of itself.

    Example: 
                  root                 subRoot

                    3                     4
                  /   \                 /   \ 
                 4     5               1     2
                / \
               1   2

    Output : true
*/

public class _8_SubtreeOfAnotherTree {
    private static boolean equals(TreeNode root1,TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.val == root2.val &&
               equals(root1.left, root2.left) && 
               equals(root1.right, root2.right);
    }

    // TC: O(m * n)
    // SC: O(h1 + h2)
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (equals(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        /*
                  root                 subRoot

                    3                     4
                  /   \                 /   \ 
                 4     5               1     2
                / \
               1   2

        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println(isSubtree(root, subRoot));
    }
}
