

/*
    101. Symmetric Tree
    (easy)

    Given the root of a binary tree, check whether it is a mirror of itself 
    (i.e., symmetric around its center).

    Example:
                     1
                   /   \
                  2     2
                 / \   / \
                3  4  4   3
    
    Output: true

*/

public class _5_SymmetricTree {
    private static void swap(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        swap(root.left);
        swap(root.right);
    }

    private static boolean isSymmetric(TreeNode n1,TreeNode n2) {
        if (n1 == null || n2 == null) {
            return n1 == n2;
        }

        if(n1.val != n2.val) return false;


        return isSymmetric2(n1.left,n2.left) &&
               isSymmetric2(n1.right,n2.right);

    }

    // Mirror Right Subtree, Compare, and Restore
    // TC: O(n)
    // SC: O(h)
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        swap(root.right);
        boolean result = isSymmetric(root.left,root.right);
        swap(root.right);

        return result;
    }

    private static boolean isSymmetric2(TreeNode n1,TreeNode n2) {
        if (n1 == null || n2 == null) {
            return n1 == n2;
        }

        if(n1.val != n2.val) return false;


        return isSymmetric2(n1.left,n2.right) &&
               isSymmetric2(n1.right,n2.left);
    }

    // Best Solution:
    // Direct Mirror Comparison (Without Modifying Tree)
    // TC: O(n)
    // SC: O(h)
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        return isSymmetric2(root.left,root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left =  new TreeNode(4);
        root.right.right = new TreeNode(3);
  

        System.out.println(isSymmetric(root));
        System.out.println(isSymmetric2(root));
    }
}
