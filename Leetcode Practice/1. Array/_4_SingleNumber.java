/*
    136. Single Number
    (easy) --> https://dsa.apnacollege.in/

    Given a non-empty array of integers nums, every element appears twice except
    for one. Find that single one.

    You must implement a solution with a linear runtime complexity and use only 
    constant extra space.

    Example:

    Input: nums = [2,2,1]

    Output: 1
*/

public class _4_SingleNumber {
    //Solved using XOR property: x^x = 0
    // TC:O(n)
    // SC:O(1)
    public static int singleNumber(int[] nums){
        int result = 0;
        for(int num:nums){
            result ^= num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,1,3,5};
        System.out.println(singleNumber(nums));
    }
}
