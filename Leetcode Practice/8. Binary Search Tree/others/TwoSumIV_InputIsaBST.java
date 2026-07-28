/*
    653. Two Sum IV - Input is a BST
    (easy)

    Given the root of a binary search tree and an integer k, return true if there exist two elements 
    in the BST such that their sum is equal to k, or false otherwise.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumIV_InputIsaBST {
    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    // 2 pointer approch
    // TC: O(n)
    // SC: O(n)
    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inorder(root,inorder);

        int i = 0;
        int j = inorder.size() - 1;
        while (i < j) {
            int sum = inorder.get(i) + inorder.get(j);

            if (sum == k) {
                return true;
            }

            if (sum > k) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }

    private boolean util(TreeNode root,int k,Set<Integer> set) {
        if (root == null) return false;

        int need = k - root.val;

        if (set.contains(need)) {
            return true;
        }

        set.add(root.val);

        return util(root.left,k,set) || util(root.right,k,set);
    }

    // HashMap Sol
    // TC: O(n)
    // SC: O(n)
    public boolean findTarget2(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return util (root,k,set);
    }
}