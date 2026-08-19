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

    private static void preorder(TreeNode root,StringBuilder ans) {
        if (root == null) {
            ans.append("n,");
            return;
        }

        ans.append(root.val).append(",");
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

    private static int i = 0;

    private static TreeNode create2(String[] preorder) {
        if (i >= preorder.length || preorder[i].equals("n")) {
            i++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(preorder[i]));
        i++;
        root.left = create2(preorder);
        
        i++;
        root.right = create2(preorder);

        return root;
    }

    // ---------> Sol using preorder DFS of tree <---------
    public static String serialize2(TreeNode root) {
        StringBuilder preorder = new StringBuilder();
        preorder(root,preorder);
        return preorder.toString();
    }

    public static TreeNode deserialize2(String data) {
        String[] nodes = data.split(",");
        return create2(nodes);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);

        // TreeNode root = new TreeNode(10);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(12);


        String data = serialize2(root);
        System.out.println(data);

        TreeNode de = deserialize2(data);
        System.out.println(de.left.val);

        // StringBuilder preorder = new StringBuilder();
        // preorder(root, preorder);
        // System.out.println(preorder);
    }
}
