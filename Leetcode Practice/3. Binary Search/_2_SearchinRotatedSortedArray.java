/*
    33. Search in Rotated Sorted Array
    (Medium)

    There is an integer array nums sorted in ascending order (with distinct values).

    Prior to being passed to your function, nums is possibly left rotated at an 
    unknown index k (1 <= k < nums.length) such that the resulting array is 
    [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
    For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

    Given the array nums after the possible rotation and an integer target, 
    return the index of target if it is in nums, or -1 if it is not in nums.

    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4
*/

public class _2_SearchinRotatedSortedArray {
    // Iterative approach: Best
    // TC: O(log n)
    // SC: O(1)
    public static int search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length-1;

        while(si <= ei) {
            int mid = si + (ei - si)/2;

            if(nums[mid] == target) return mid;

            if(nums[mid] >= nums[si]) {//L1
                if(target >= nums[si] && target < nums[mid]) ei = mid - 1;
                else si = mid + 1;
            }else{//L2
                if(target <= nums[ei] && target > nums[mid]) si = mid + 1;
                else ei = mid - 1;
            }
        }
        return -1;
    }

    // Recursive approach: 
    // TC: O(log n)
    // SC: O(log n) -> call stack
    private static int searchP(int[] arr,int target,int si,int ei){
        if(si > ei)return -1;
        
        int mid = si + (ei-si)/2;
        if(arr[mid] == target){
            return mid;
        }

        //L1
        if(arr[si] <= arr[mid]){
            if(target >= arr[si] && target < arr[mid]){
                return searchP(arr, target, si, mid-1);
            }else{
                return searchP(arr, target, mid+1, ei);
            }
        }

        //L2
        else{
            if(target > arr[mid] && target <= arr[ei]){
                return searchP(arr, target, mid+1, ei);
            }else{
                return searchP(arr, target, si, mid-1);
            }
        }
    }

    public static int search2(int[] nums, int target) {
        return searchP(nums, target, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {6,7,8,1,2,3,4,5};
        System.out.println(search(arr, 8));

        int[] arr2 = {4,5,6,7,0,1,2};
        System.out.println(search(arr2, 0));

    }
}
