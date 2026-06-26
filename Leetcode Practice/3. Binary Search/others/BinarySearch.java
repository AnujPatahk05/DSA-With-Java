/*
    704. Binary Search
    (easy)

    Given an array of integers nums which is sorted in ascending order, and an integer target, 
    write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

    You must write an algorithm with O(log n) runtime complexity.

    Example 1:

    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: 9 exists in nums and its index is 4
*/

public class BinarySearch {
    // Binary Search using Recursion:
    // TC: O(log n)
    // SC: O(log n) -> call stack
    private static int searchUtil(int[] nums,int target,int si,int ei) {
        if(si > ei) return -1;

        int mid = si + (ei - si)/2;

        if(nums[mid] == target) return mid;

        if(nums[mid] < target) return searchUtil(nums, target, mid + 1, ei);
        else return searchUtil(nums, target, si, mid - 1);
    }

    public static int search(int[] nums,int target) {
        return searchUtil(nums, target, 0, nums.length - 1);
    }

    // Binary Search using Iteration
    // Better approach than Recursive approach -> no stack overflow 
    //                                         -> no extra memory
    // TC: O(log n)
    // SC: O(1)
    public static int search2(int[] nums,int target) {
        int si = 0;
        int ei = nums.length - 1;
        
        while(si <= ei) {
            int mid = si + (ei - si)/2;

            if(nums[mid] == target) return mid;

            if(nums[mid] < target) si = mid + 1;
            else ei = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] input1 = {-4,-2,0,1,4,6,77,900};
        int target1 = 4;
        System.out.println(search2(input1, target1));

        int[] input2 = {-1,0,3,5,9,12};
        int target2 = 2;
        System.out.println(search2(input2, target2));
    }
}
