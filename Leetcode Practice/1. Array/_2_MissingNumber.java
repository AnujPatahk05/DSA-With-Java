/*
    268. Missing Number
    (easy) --> https://dsa.apnacollege.in/

    Given an array nums containing n distinct numbers in the range [0, n],
    return the only number in the range that is missing from the array.

    Example:

    Input: nums = [3,0,1]
    Output: 2
    Explanation:
    n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
    2 is the missing number in the range since it does not appear in nums.

 */

public class _2_MissingNumber {

    // Solution using XOR(^)
    // Idea: a^a = 0
    // TC: O(n)
    // SC: O(1)
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int result = 0;

        for(int i = 0;i <= n;i++){
            result ^= i;
        }

        for(int num:nums){
            result ^= num;
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = {4,1,0,3};
        System.out.println(missingNumber(nums));
    }
}
