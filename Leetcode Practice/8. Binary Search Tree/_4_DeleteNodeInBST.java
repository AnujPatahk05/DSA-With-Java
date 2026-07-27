/*
    450. Delete Node in a BST
    (Medium)

    Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node 
    reference (possibly updated) of the BST.

    Basically, the deletion can be divided into two stages:

    Search for a node to remove.
    If the node is found, delete the node.
*/

public class _4_DeleteNodeInBST {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (root.val > key) {
            root.left =  deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right =  deleteNode(root.right, key);
        } else {
            // 1. if root is leaf node (No child)
            if (root.left == null && root.right == null) {
                return null;
            }

            // 2. if root has only one child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // 3. if root has both childs 

            TreeNode IS = root.right;
            
            while(IS.left != null) {
                IS = IS.left;
            }

            root.val = IS.val;
            deleteNode(root.right, IS.val);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
    }
}