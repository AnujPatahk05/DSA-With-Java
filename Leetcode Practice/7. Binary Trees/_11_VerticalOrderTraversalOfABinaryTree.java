/*
    987. Vertical Order Traversal of a Binary Tree
    (hard)

    Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

    For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. 
    The root of the tree is at (0, 0).

    The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and 
    ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

    Return the vertical order traversal of the binary tree.

    Example:

    Input: root = [1,2,3,4,5,6,7]

                                    1
                                 /      \
                                2        3
                              /   \    /   \
                             4     5  6     7

    Output: [[4],[2],[1,5,6],[3],[7]]

    Explanation:
    Column -2: Only node 4 is in this column.
    Column -1: Only node 2 is in this column.
    Column 0: Nodes 1, 5, and 6 are in this column.
            1 is at the top, so it comes first.
            5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
    Column 1: Only node 3 is in this column.
    Column 2: Only node 7 is in this column.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class _11_VerticalOrderTraversalOfABinaryTree {
    private static class Info {
        TreeNode node;
        int col;

        public Info(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        HashMap<Integer,List<Integer>> map = new HashMap<>();

        Queue<Info> queue = new ArrayDeque<>();
        queue.add(new Info(root,0));

        int min = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            Integer lastCol = null;

            for (int i = 0;i < size;i++) {
                Info curr = queue.remove();

                if (curr.node.left != null) {
                    queue.add(new Info(curr.node.left, curr.col - 1));
                }

                if (curr.node.right != null) {
                    queue.add(new Info(curr.node.right, curr.col + 1));
                }

                if (!map.containsKey(curr.col)) {
                    map.put(curr.col,new ArrayList<>());
                }

                List<Integer> currList = map.get(curr.col);

                if (lastCol != null && lastCol == curr.col && currList.get(currList.size()-1) > curr.node.val) {
                    int temp = currList.remove(currList.size()-1);
                    currList.add(curr.node.val);
                    currList.add(temp);
                } else {
                    currList.add(curr.node.val);
                }

                lastCol = curr.col;

                min = Math.min(min,curr.col);
                max = Math.max(max,curr.col);
            }
        }

        for (int i = min; i <= max;i++) {
            if(map.containsKey(i)) {
                result.add(map.get(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(verticalTraversal(root));
    }
}
