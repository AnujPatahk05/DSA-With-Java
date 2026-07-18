/*
    105. Construct Binary Tree from Preorder and Inorder Traversal
    (Medium)

    Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary 
    tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

    Example: 

    Preorder: 3,9,20,15,7
    Inorder: 9,3,15,20,7

    Output: 
                3
              /   \
             9     20
                  /  \
                 15   7
*/

public class _17_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private static boolean isLeft(int[] inorder,int root,int val) {
        for(int i:inorder) {
            if(i == root) return false;
            if(i == val) return true;
        }
        return false;
    }

    /*
        My Solution: (Iterative approach)
        TC: O(n^2)
        SC: O(1) (If ignore output tree)
    */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for(int i = 1;i < preorder.length;i++) {
            TreeNode temp = root;

            while (true) { 
                if (isLeft(inorder, temp.val, preorder[i])) {
                    if (temp.left != null) {
                        temp = temp.left;
                    } else {
                        temp.left = new TreeNode(preorder[i]);
                        break;
                    }
                } else {
                    if (temp.right != null) {
                        temp = temp.right;
                    } else {
                        temp.right = new TreeNode(preorder[i]);
                        break;
                    }
                }
            }
        }

        return root;
    }



    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);

        TreeNode.printBFS(root);
    }
}
