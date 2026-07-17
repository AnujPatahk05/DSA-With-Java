import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void printBFS(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0;i < size;i++) {
                TreeNode node = queue.remove();

                System.out.print(node.val + " ");

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            System.out.println();
        }
    }
}
