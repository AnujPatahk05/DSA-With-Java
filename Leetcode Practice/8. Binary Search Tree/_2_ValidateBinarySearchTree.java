
import java.util.ArrayList;
import java.util.List;

public class _2_ValidateBinarySearchTree {
    private static void inorder(TreeNode root,List<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private static boolean isSorted(List<Integer> list) {
        if (list == null || list.isEmpty() || list.size() == 1) {
            return true;
        }

        for (int i = 0;i < list.size() -1;i++) {
            if (list.get(i) >= list.get(i+1)) {
                return false;
            }
        }

        return true;
    }

    // Solving by checking inorder is in increasing order or not
    // Because inoreder of a BST is always in increasing order
    // TC: O(n)
    // SC: O(n)
    public static boolean isValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorder(root,inorder);
        return isSorted(inorder);
    }

    private static Integer prev = null;

    public static boolean isValidBST2(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST2(root.left)) {
            return false;
        }

        if (prev != null && prev >= root.val) {
            return false;
        }

        prev = root.val;

        return isValidBST2(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(isValidBST2(root));
    }
}
