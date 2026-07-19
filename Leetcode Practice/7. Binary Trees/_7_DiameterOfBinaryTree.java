/*
    543. Diameter of Binary Tree
    (easy)

    Given the root of a binary tree, return the length of the diameter of the tree.

    The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
    This path may or may not pass through the root.

    The length of a path between two nodes is represented by the number of edges between them.

    Example: 
                            1
                          /   \
                         2     3
                        / \
                       4   5

    Input: root = [1,2,3,4,5]
    Output: 3
    Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
*/

public class _7_DiameterOfBinaryTree {
    private static int height (TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(
            height(root.left),
            height(root.right)
        );
    }

    // Approach:
    // Diameter passing through root : height of left subtree + height of right subtree
    // Diameter not passing through root: Max of left subtree's diameter and right subtree's diameter
    // TC: O(n^2) -> because we are finding height at each level
    // SC: O(h)
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int self = height(root.left) + height(root.right);

        return Math.max(
            self,
            Math.max(left,right)
        );
     }

     private static class Info {
        int height;
        int diameter;

        public Info(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static Info diameterOfBinaryTreeUtil(TreeNode root) {
        if (root == null) return new Info(0, 0);

        Info left = diameterOfBinaryTreeUtil(root.left);
        Info right = diameterOfBinaryTreeUtil(root.right);

        int selfDiameter = left.height + right.height;

        return new Info(
            Math.max(left.height,right.height) + 1,
            Math.max(
                selfDiameter,
                Math.max(left.diameter,right.diameter)
            )
        );
    }

    // Optimal Sol:
    // Same as previous just calculating height and diameter at the same time
    // TC: O(n)
    // SC: O(h)
    public static int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;
        return diameterOfBinaryTreeUtil(root).diameter;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.left = new TreeNode(6);
        root.left.left.left.left = new TreeNode(7);

        root.left.right.right = new TreeNode(8);

        /*
                                  1
                                /   \
                               2     3
                              / \
                             4   5
                            /     \
                           6       8
                         /
                        7
        */

        System.out.println(diameterOfBinaryTree(root));
        System.out.println(diameterOfBinaryTree2(root));


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);

        /*
                        1
                      /   \
                     2     3
                    / \
                   4   5
        */

        System.out.println(diameterOfBinaryTree(root2));
        System.out.println(diameterOfBinaryTree2(root2));
    }
}