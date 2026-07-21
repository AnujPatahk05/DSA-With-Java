
/*
    110. Balanced Binary Tree
    (easy)

    Given a binary tree, determine if it is height-balanced.

    A height-balanced binary tree is a binary tree in which the depth of the two subtrees 
    of every node never differs by more than one.

    Example: 
                    3
                  /   \
                 9     20
                      /  \
                     15   7

    Output: true
*/

public class _10_BalancedBinaryTree {
    // A node is height balanced if difference bet height of left and right subtree is same or differ by 1
    public static int height(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(height(root.left),height(root.right));
    }

    /* a node is height-balanced if 
        - difference bet left height and right is 0 or 1        - And left node is height balanced and right node is height balanced
        TC: O(n^2)  -> because we are calculating height for each node
        SC: O(h)
    */ 
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        boolean leftBalanced = isBalanced(root.left);
        boolean rightBalanced = isBalanced(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 &&
               leftBalanced &&
               rightBalanced;
    }

    /*
        Optimal Sol:
        It calculates height and checks about height balance at the same time
        TC: O(n)
        SC: O(h)
    */

    private static class Info {
        int height;
        boolean isBalanced;

        public Info(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    private static Info isBalancedUtil(TreeNode root) {
        if (root == null) return new Info(0, true);

        Info left = isBalancedUtil(root.left);
        Info right = isBalancedUtil(root.right);

        int height = 1 + Math.max(left.height,right.height);
        boolean isBalanced = Math.abs(left.height - right.height) <= 1 && left.isBalanced && right.isBalanced;

        return new Info(
            height,
            isBalanced
        );
    }

    public static boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        return isBalancedUtil(root).isBalanced;
    }

    public static void main(String[] args) {
        /*
                    3
                  /   \
                 9     20
                      /  \
                     15   7

        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(isBalanced(root));
        System.out.println(isBalanced2(root));

    }
}
