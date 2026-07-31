/*
    103. Binary Tree Zigzag Level Order Traversal
    (Medium)

    Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. 
    (i.e., from left to right, then right to left for the next level and alternate between).

    Input: 
                 3
                / \
               9   20
              /   /  \
             5   15   7

    Output: [[3], [20, 9], [15, 7]]
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _19_BinaryTreeZigzagLevelOrderTraversal {
    private static void reverse(List<Integer> list) {
        int n = list.size();

        for (int i = 0;i < list.size()/2;i++) {
            int temp = list.get(i);
            list.set(i,list.get(n - i - 1));
            list.set(n - i - 1,temp);
        }
    }

    // TC: O(n)
    // SC: O(n)
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0;i < size;i++) {
                TreeNode curr = queue.remove();

                list.add(curr.val);

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            if (level%2 != 0) reverse(list);
            result.add(list);
            level++;
        }

        return result;
    }

    // TC: O(n)
    // SC: O(n)
    public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) return result;

         Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();

            for (int i = 0;i < size;i++) {
                TreeNode curr = queue.remove();

                if (level%2 == 0) list.add(curr.val);
                else list.addFirst(curr.val);

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            result.add(list);
            level++;
        }

        return result;
    }

    public static void main(String[] args) {
/*
                 3
                / \
               9   20
              /   /  \
             5   15   7
*/

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        
        System.out.println(zigzagLevelOrder(root));
        System.out.println(zigzagLevelOrder2(root));
    }
}
