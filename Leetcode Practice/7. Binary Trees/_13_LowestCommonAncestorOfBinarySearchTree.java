/*
    236. Lowest Common Ancestor of a Binary Search Tree
    (Medium)

    Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q 
    as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

    Example:            
                                6
                          /           \
                         2             8
                      /     \       /     \
                     0       4     7       9
                           /   \
                          3     5

    Input: p = 2, q = 8
    Output: 6

    Input: p = 3, q = 7
    Output: 6

    Input: p = 3, q = 0
    Output: 2
*/

import java.util.ArrayList;
import java.util.List;

public class _13_LowestCommonAncestorOfBinarySearchTree {
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

    // Optimal Sol:
    // Using property of BST
    // TC: O(h)
    // SC: O(1)
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        
    }
}
