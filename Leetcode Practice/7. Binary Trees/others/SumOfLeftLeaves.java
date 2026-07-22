/*
    404. Sum of Left Leaves
    (easy)

    Given the root of a binary tree, return the sum of all left leaves.

    A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

    Example:

    Input: root = [3,9,20,null,null,15,7]

                        3
                      /   \
                     9     20
                         /    \
                        15     7


    Output: 24
    Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
*/


public class SumOfLeftLeaves {
    private static int sum = 0;

    private static void sumOfLeftLeavesUtil(TreeNode root,boolean left) {
        if (left && root.left == null && root.right == null) {
            sum += root.val;
        }

        if (root.left != null) sumOfLeftLeavesUtil(root.left,true);
        if (root.right != null) sumOfLeftLeavesUtil(root.right,false);
    }

    // Solving using a global state sum
    // And using a left marker
    // TC: O(n)
    // SC: O(h)
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        
        sum = 0;

        sumOfLeftLeavesUtil(root,false);

        return sum;
    }

    private static int sumOfLeftLeavesUtil2(TreeNode root,boolean left) {
        if (left && root.left == null && root.right == null) {
            return root.val;
        }

        int leftSum = root.left != null ? sumOfLeftLeavesUtil2(root.left,true) : 0;
        int rightSum = root.right != null ? sumOfLeftLeavesUtil2(root.right,false) : 0;

        return leftSum + rightSum;
    }

    // Best Solution: Without using global state
    // TC: O(n)
    // SC: O(h)
    public static int sumOfLeftLeaves2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        
        return sumOfLeftLeavesUtil2(root,false);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(sumOfLeftLeaves(root));
        System.out.println(sumOfLeftLeaves2(root));
    }
}
