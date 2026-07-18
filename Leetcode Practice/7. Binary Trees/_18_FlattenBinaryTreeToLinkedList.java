import java.util.ArrayList;
import java.util.List;

public class _18_FlattenBinaryTreeToLinkedList {
    private static void preorder(TreeNode root,List<TreeNode> list) {
        if(root == null) return;

        list.add(root);
        preorder(root.left,list);
        preorder(root.right,list);
    }

    // Approach 1: Preorder + ArrayList
    // TC: O(n)
    // SC: O(n)
    public static void flatten(TreeNode root) {
        if(root == null) return;

        List<TreeNode> preorder = new ArrayList<>();
        preorder(root,preorder);

        root.left = null;
        
        for(int i = 1;i < preorder.size();i++) {
            root.right = preorder.get(i);

            root = root.right;
            root.left = null;
        }
    }

    private static void preorder2(TreeNode root,TreeNode result) {
        
    }

    public static void flatten2(TreeNode root) {
        
    }

    public static void main(String[] args) {
        
    }
}
