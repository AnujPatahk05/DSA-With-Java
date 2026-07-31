/*
    662. Maximum Width of Binary Tree
    (Medium)

    Given the root of a binary tree, return the maximum width of the given tree.

    The maximum width of a tree is the maximum width among all levels.

    The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), 
    where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level 
    are also counted into the length calculation.

    It is guaranteed that the answer will in the range of a 32-bit signed integer.

    Input:      
                   1
                /    \
               3      2
             /  \      \
            5    3      9

    Output: 4 
    Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

*/

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class _16_MaximumWidthOfBinaryTree {
    // My Sol:
    // Time Limit Exceeded (Not an optimal Sol)
    // TC: O(2 ^ h)
    // SC: O(2 ^ h)
    public static int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int max = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int firstNonNull = -1;
            int lastNonNull = -1;

            boolean allNull = true;

            for (int i = 0;i < size;i++) {
                TreeNode curr = queue.remove();

                if (firstNonNull == -1 && curr != null) {
                    firstNonNull = i;
                }

                if (curr != null) {
                    lastNonNull = i;
                    allNull = false;
                }

                if (curr != null) {
                    queue.add(curr.left);
                    queue.add(curr.right);
                    if (curr.left != null || curr.right != null) allNull = false;
                } else {
                    queue.add(null);
                    queue.add(null);
                }

            }

            max = Math.max(max,lastNonNull - firstNonNull + 1);


            if (allNull) {
                break;
            }

        }
        return max;
    }

    
    private static class NodeInfo {
        TreeNode node;
        int index;

        public NodeInfo(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    // Optimal Sol: 
    // Index of a node:
    // Root → 0 (i)
    // Left child → 2*i
    // Right child → 2*i + 1

    // TC: O(n)
    // SC: O(n)
    public static int widthOfBinaryTree2(TreeNode root) {
        Queue<NodeInfo> queue = new ArrayDeque<>();
        queue.add(new NodeInfo(root,0));

        int max = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            int firstIndex = -1;
            int lastIndex = -1;

            for (int i = 0;i < size;i++) {
                NodeInfo info = queue.remove();

                if (i == 0) firstIndex = info.index;
                if (i == size - 1) lastIndex = info.index;

                if (info.node.left != null) queue.add(new NodeInfo(info.node.left, 2*info.index));
                if (info.node.right != null) queue.add(new NodeInfo(info.node.right, 2*info.index + 1));
            }

            max = Math.max(max,lastIndex - firstIndex + 1);
        }

        return max;
    }

    public static void main(String[] args) {

/*
                  1
                /    \
               3      2
             /  \      \
            5    3      9
*/
        TreeNode root = new TreeNode(1);
        root.left  = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        TreeNode.printBFS(root);

        System.out.println(widthOfBinaryTree2(root));
    }
}