/*
    108. Convert Sorted Array to Binary Search Tree
    (easy)

    Given an integer array nums where the elements are sorted in ascending order, 
    convert it to a height-balanced binary search tree.

    Example:
    Input: -10,-3,0,5,9
    Output:         
                    0
                  /   \
                -3     9
                /     /
               -10   5
*/

public class _1_ConvertSortedArrayToBinarySearchTree {
    private static void sortedArrayToBST(int[] nums,TreeNode root,int i,int j) {
        if (i > j) {
            return;
        }

        int mid = i + (j - i)/2;

        if (nums[mid] < root.val) {
            root.left = new TreeNode(nums[mid]);

            sortedArrayToBST(nums, root.left, i, mid-1);
            sortedArrayToBST(nums, root.left, mid+1 ,j);
        } else {
            root.right = new TreeNode(nums[mid]);

            sortedArrayToBST(nums, root.right, i, mid-1);
            sortedArrayToBST(nums, root.right, mid+1 ,j);
        }
    }

    // My Solution
    // TC: O(n)
    // SC: O(log n)
    public static TreeNode sortedArrayToBST(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int mid = i + (j - i)/2;

        TreeNode root = new TreeNode(nums[mid]);

        if (nums.length == 1) return root;

        sortedArrayToBST(nums, root, i, mid-1);
        sortedArrayToBST(nums, root, mid+1 ,j);

        return root;
    }

    private static TreeNode sortedArrayToBST2(int[] nums,int i,int j) {
        if (i > j) {
            return null;
        }

        int mid = i + (j - i)/2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST2(nums,i,mid-1);
        root.right = sortedArrayToBST2(nums,mid + 1,j);

        return root;
    }

    // Originl Solution
    // TC: O(n)
    // SC: O(log n)
    public static TreeNode sortedArrayToBST2(int[] nums) {
        return sortedArrayToBST2(nums,0,nums.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST2(arr);
        TreeNode.printBFS(root);
    }
}
