/*
    655. Print Binary Tree
    (Medium)

    Given the root of a binary tree, construct a 0-indexed m x n string matrix res that represents a formatted layout of the tree. 
    The formatted layout matrix should be constructed using the following rules:

        The height of the tree is height and the number of rows m should be equal to height + 1.

        The number of columns n should be equal to 2height+1 - 1.

        Place the root node in the middle of the top row (more formally, at location res[0][(n-1)/2]).

        For each node that has been placed in the matrix at position res[r][c], place its left child at res[r+1][c-2height-r-1] and 
        its right child at res[r+1][c+2height-r-1].

        Continue this process until all the nodes in the tree have been placed.

        Any empty cells should contain the empty string "".

    Return the constructed matrix res.

    Example: 
                        1
                    /       \
                   2         3
                   \
                    4

    Output:     [
                    [ "","" , "","1", "", "",""],
                    [ "","2", "", "", "","3",""],
                    [ "","" ,"4", "", "", "",""]
                ]

 
*/

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {
    private static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left) , height(root.right));
    }

    private static void fill(TreeNode root, List<List<String>> result,int row , int i,int j) {
        if (root == null) return;

        int mid = i + (j - i)/2;

        result.get(row).set(mid,Integer.toString(root.val));

        fill(root.left, result, row + 1, i, mid - 1);
        fill(root.right, result, row + 1,mid + 1, j);
    }

    // TC: O(n + 2^h)
    // SC: O(2^h)
    public static List<List<String>> printTree(TreeNode root) {
        int row = height(root);
        int col = (int) Math.pow(2,row) - 1;

        List<List<String>> result = new ArrayList<>();

        for (int i = 0;i < row;i++) {
            result.add(new ArrayList<>());
            for (int j = 0;j < col;j++) {
                result.get(i).add(" ");
            }
        }

        fill(root, result, 0, 0, col-1);

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<String>> result = printTree(root);

        for (List<String> row: result) {
            for (String col:row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
