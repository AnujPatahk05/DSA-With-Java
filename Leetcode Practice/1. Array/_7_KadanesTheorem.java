/*
    53. Maximum Subarray
    (Medium) --> https://dsa.apnacollege.in/

    Given an integer array nums, find the subarray with the largest sum, 
    and return its sum.

    Example:

    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: The subarray [4,-1,2,1] has the largest sum 6.
*/

public class _7_KadanesTheorem {
    //Solved using Kadane's theorem:
    // TC: O(n)
    // SC: O(1)
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];

        for(int i = 0;i < nums.length;i++){
            currSum = Math.max(currSum+nums[i],nums[i]);
            maxSum = Math.max(maxSum,currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new _7_KadanesTheorem().maxSubArray(nums));
    }
}
