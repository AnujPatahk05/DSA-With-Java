/*
169. Majority Element
(easy) --> https://dsa.apnacollege.in/

Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/

public class _1_MajorityElement {
    // Divide and conquer approach : O(nlogn)
    private int majorityElementP(int[] arr,int si,int ei){
        if(si == ei) return arr[si];

        int mid = si + (ei - si)/2;

        int left = majorityElementP(arr,si,mid);
        int right= majorityElementP(arr,mid+1,ei);

        if(left == right) return left;

        int leftCount = 0;
        int rightCount = 0;

        for(int i = si;i <= ei;i++){
            if(arr[i] == left) leftCount++;
            if(arr[i] == right) rightCount++;
        }

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElementP(nums,0,nums.length-1);
    }   


    public static void main(String[] args) {
        
    }
}
