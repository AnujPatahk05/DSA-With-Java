/*
    1932. Merge BSTs to Create Single BST
    (Hard)

    You are given n BST (binary search tree) root nodes for n separate BSTs stored in an array trees (0-indexed). 
    Each BST in trees has at most 3 nodes, and no two roots have the same value. In one operation, you can:

    Select two distinct indices i and j such that the value stored at one of the leaves of trees[i] is equal to the 
    root value of trees[j].
    Replace the leaf node in trees[i] with trees[j].
    Remove trees[j] from trees.
    Return the root of the resulting BST if it is possible to form a valid BST after performing n - 1 operations, 
    or null if it is impossible to create a valid BST.

    A BST (binary search tree) is a binary tree where each node satisfies the following property:

    Every node in the node's left subtree has a value strictly less than the node's value.
    Every node in the node's right subtree has a value strictly greater than the node's value.
    A leaf is a node that has no children.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _8_MergeBSTsToCreateSingleBST {
    // TC: O(n)
    // SC: O(n)

    /*
    - Store every tree root in a Map using its value as the key.
    - Store all leaf values of every tree in a Set.
    - Find the root whose value does not appear in the leaf set. This is the final root.
    - Remove the final root from the map.
    - Traverse the final tree:
       - If a leaf's value exists in the map, merge that tree at the leaf.
       - Remove the merged tree from the map.
    - After merging, if the map is not empty, return null.
    - Check whether the final tree is a valid BST.
    - If valid, return the root; otherwise return null.
    
    */
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer,TreeNode> map = new HashMap<>();
        Set<Integer> leaves = new HashSet<>();

        for (int i = 0;i < trees.size();i++) {
            if (trees.get(i).left != null) leaves.add(trees.get(i).left.val);
            if (trees.get(i).right != null) leaves.add(trees.get(i).right.val);

            map.put(trees.get(i).val,trees.get(i));
        }

        TreeNode root = null;
        
        for (TreeNode tree: trees) {
            if(!leaves.contains(tree.val)) {
                if (root != null) return null;

                root = tree;
            }
        }

        if (root == null) return null;

        map.remove(root.val);

        merge(root,map);

        if (!map.isEmpty()) return null;

        return validBST(root,Long.MIN_VALUE,Long.MAX_VALUE) ? root : null;

    }

    private boolean validBST(TreeNode root, long min, long max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return validBST(root.left, min, root.val)
            && validBST(root.right, root.val, max);
    }

    private void merge(TreeNode root,Map<Integer,TreeNode> map) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            TreeNode tree = map.remove(root.val);

            if (tree != null) {
                root.left = tree.left;
                root.right = tree.right;
            }
        }

        merge(root.left,map);
        merge(root.right,map);
    }

    public static void main(String[] args) {
        
    }
}