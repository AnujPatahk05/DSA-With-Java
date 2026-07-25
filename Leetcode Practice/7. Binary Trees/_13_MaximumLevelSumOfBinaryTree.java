
import java.util.ArrayDeque;
import java.util.Queue;

/*
    1161. Maximum Level Sum of a Binary Tree
    (Medium)

    Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

    Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

    Example:    
                            1
                          /   \
                         7     0
                       /  \
                      7   -8

    Input: root = [1,7,0,7,-8,null,null]
    Output: 2

    Explanation: 

    Level 1 sum = 1.
    Level 2 sum = 7 + 0 = 7.
    Level 3 sum = 7 + -8 = -1.

    So we return the level with the maximum sum which is level 2.
*/

public class _13_MaximumLevelSumOfBinaryTree{
    // BFS Solution
    // TC: O(n)
    // SC: O(n)
    public static int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int max = Integer.MIN_VALUE;
        int maxLevel = 1;

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            int sum = 0;

            for (int i = 0;i < size;i++) {
                TreeNode curr = queue.remove();

                sum += curr.val;

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            if (sum > max) {
                max = sum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        root.right = new TreeNode(0);

        System.out.println(maxLevelSum(root));
    }
}
