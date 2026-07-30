
/*
    1038. Binary Search Tree to Greater Sum Tree

    Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is 
    changed to the original key plus the sum of all keys greater than the original key in BST.

    As a reminder, a binary search tree is a tree that satisfies these constraints:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

    Input:
                        4
                    /       \
                   1         6
                  / \      /   \
                 0   2    5     7
                      \          \
                       3          8


    Output:             
                       30
                    /       \
                   36        21
                  / \      /   \
                36   35   26    15
                      \          \
                       33         8

*/

public class _15_BinarySearchTreeToGreaterSumTree {
    public static void util(TreeNode root,int[] sum) {
        if (root == null) return;

        util(root.right, sum);

        sum[0] += root.val;
        root.val = sum[0];

        util(root.left, sum);
    }

    // Sol using inorder traversal but in reverse order : right - root - left
    // TC: O(n)
    // SC: O(n)
    public static TreeNode bstToGst(TreeNode root) {
        util(root, new int[]{0});
        return root;
    }

    private static int sum = 0;

    public static void dfs(TreeNode root) {
       if (root == null) return;

       dfs(root.right);

       sum += root.val;
       root.val = sum;

       dfs(root.left);
    }

    // Same as previous but using a common sum variable
    public static TreeNode bstToGst2(TreeNode root) {
        sum = 0;
        dfs(root);
        return root;
    }

    public static void main(String[] args) {
/*
                        4
                    /       \
                   1         6
                  / \      /   \
                 0   2    5     7
                      \          \
                       3          8
*/

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(8);

        TreeNode.printBFS(root);

        bstToGst(root);
        System.out.println();

        TreeNode.printBFS(root);
    }
}
