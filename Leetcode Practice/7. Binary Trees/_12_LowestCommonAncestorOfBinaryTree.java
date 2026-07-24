
import java.util.ArrayList;
import java.util.List;

/*
    236. Lowest Common Ancestor of a Binary Tree
    (Medium)

    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has 
    both p and q as descendants (where we allow a node to be a descendant of itself).”

    Example:
                            3
                        /       \
                       5         1
                     /   \     /   \
                    6     2   0     8
                         / \
                        7   4

    Input: p = 5, q = 1
    Output: 3

    Input: p = 7, q = 6
    Output: 5

     ->  All Node.val are unique.
     ->  p != q
     ->  p and q will exist in the BST.
*/

public class _12_LowestCommonAncestorOfBinaryTree {
    private static boolean getPath(TreeNode root,TreeNode node, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root == node) {
            return true;
        }

        if (getPath(root.left, node, path) ||
            getPath(root.right, node, path)
        ) {
            return true;
        }

        path.remove(path.size()-1);

        return false;
    }

    // First find path of both nodes
    // The first mismatch node in the path will be the LCA
    // TC: O(n)
    // SC: O(n)
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        getPath(root, p, path1);
        getPath(root, q, path2);

        TreeNode LCA = root;

        int i = 0;
        
        while (i < path1.size() && i < path2.size()) {
            if (path1.get(i) != path2.get(i)) {
                return LCA;
            }
            LCA = path1.get(i);
            i++;
        }

        return LCA;
    }

    

    public static void main(String[] args) {
/*
                        3
                    /       \
                   5         1
                 /   \ 
                6    2 
*/

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        List<TreeNode> path = new ArrayList<>();
        getPath(root, root.left.right, path);

        System.out.println(lowestCommonAncestor(root, root.left.left, root).val);
    }
}
