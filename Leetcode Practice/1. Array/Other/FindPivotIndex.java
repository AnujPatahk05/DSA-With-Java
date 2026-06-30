/*
    724. Find Pivot Index
    (easy)

    Given an array of integers nums, calculate the pivot index of this array.

    The pivot index is the index where the sum of all the numbers strictly to the 
    left of the index is equal to the sum of all the numbers strictly to the index's right.

    If the index is on the left edge of the array, then the left sum is 0 because there 
    are no elements to the left. This also applies to the right edge of the array.

    Return the leftmost pivot index. If no such index exists, return -1.
*/

public class FindPivotIndex {
    // TC: O(n)
    // SC: O(1)
    public static int pivotIndex(int[] nums) {
        int rightSum = 0;
        for(int num:nums) {
            rightSum += num;
        }

        int leftSum = 0;
        for(int i = 0;i < nums.length;i++) {
            leftSum = i == 0 ? 0 : leftSum + nums[i-1];
            rightSum = rightSum - nums[i];
            if(leftSum == rightSum) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,7,3,6,5,6};
        System.out.println(pivotIndex(arr1));

        int[] arr2 = {1,2,3};
        System.out.println(pivotIndex(arr2));
    }
}
