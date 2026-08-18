/*
    297. Serialize and Deserialize Binary Tree
    (Hard)

    Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
    or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

    Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm 
    should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original 
    tree structure.

    Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, 
    so please be creative and come up with different approaches yourself.
*/

import java.util.LinkedList;
import java.util.Queue;

public class _9_SerializeAndDeserializeBinaryTree {
    private static String BFS(TreeNode root) {
        if (root == null) return "";

        StringBuilder bfs = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            boolean allNull = true;

            int size = queue.size();

            for (int i = 0;i < size;i++) {
                TreeNode curr = queue.remove();

                if (curr == null) {
                    bfs.append("n,");
                } else {
                    if(curr.left != null || curr.right != null) allNull = false;
                    bfs.append(curr.val).append(',');

                    queue.add(curr.left);
                    queue.add(curr.right);
                }

            }

            if (allNull) break;
        }

        return bfs.toString();
    }

    private static TreeNode create(String[] values) {
        if (values.length == 0) return null;
        if (values[0].equals("n")) return null;

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode curr = queue.remove();

            if (!values[i].equals("n")) {
                curr.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(curr.left);
            }
            i++;

            if (!values[i].equals("n")) {
                curr.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(curr.right);
            }
            i++;

        } 

        return root;
    }

    // ---------> Sol using BFS of tree <---------
     // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        return BFS(root);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] nodes = data.split(",");

        return create(nodes);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);

        String data = serialize(root);
        System.out.println(data);

        TreeNode de = deserialize(data);
        System.out.println(de.val);
    }
}
