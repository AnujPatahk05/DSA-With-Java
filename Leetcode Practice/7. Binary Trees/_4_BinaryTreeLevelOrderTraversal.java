/*
    102. Binary Tree Level Order Traversal
    (Medium)

    Example:
                          1
                        /   \
                       2     3
                     /  \     \
                    4    5     8
                        / \   /
                       6   7 9

        
    Level Order Traversal: [
                                [1]
                                [2,3]
                                [4,5,8]
                                [6,7,9]
                           ]
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class _4_BinaryTreeLevelOrderTraversal {
    // Best way
    // Solution without using null
    // So we are using ArrayDeque for Queue because it can not store null and more effective then using linkedlist
    // TC: O(n)
    // SC: O(n)
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            
            for (int i = 0;i < size;i++) {
                TreeNode node = queue.remove();

                level.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            result.add(level);
        }

        return result;
    }

    // Solution using null marker
    // So we uses LinkedList for queue because it can store null, but ArrayDeque can not.
    // TC: O(n)
    // SC: O(n)
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;    

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> level = new ArrayList<>();

        while(!queue.isEmpty()) {
            TreeNode curr = queue.remove();

            if (curr == null) {
                result.add(level);
                level = new ArrayList<>();
                if(queue.isEmpty()) break;
                queue.add(null);
            } else {
                level.add(curr.val);

                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
/*
                          1
                        /   \
                       2     3
                     /  \     \
                    4    5     8
                        / \   /
                       6   7 9

*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);

        System.out.println(levelOrder(root));
        System.out.println(levelOrder2(root));
    }
}
