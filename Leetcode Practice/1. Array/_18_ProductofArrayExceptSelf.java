/*
    238. Product of Array Except Self

    Given an integer array nums, return an array answer such that answer[i] is equal 
    to the product of all the elements of nums except nums[i].

    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
        
    You must write an algorithm that runs in O(n) time and without using the division operation.

    Example 1:

    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]
*/


public class _18_ProductofArrayExceptSelf {
    // Brute force:  TC:O(n^2)
    //               SC:O(n)
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        for(int i = 0;i < nums.length;i++) {
            int product = 1;
            for(int j = 0;j < nums.length;j++) {
                if(i != j) product *= nums[j];
            }
            result[i] = product;
        }

        return result;
    }

    // prefix + suffix array approach.
    // TC: O(n) 
    // SC: O(n)

     public static int[] productExceptSelf2(int[] nums) {
        int[] suffixMul = new int[nums.length];
        int[] result = new int[nums.length];

        suffixMul[nums.length-1] = 1;
        int post = 1;
        for(int i = nums.length-2;i >= 0;i--) {
            post *= nums[i+1];
            suffixMul[i] = post;
        }

        result[0] = suffixMul[0];

        int pre = 1;
        for(int i = 1;i < nums.length;i++) {
            pre *= nums[i-1];
            result[i] = pre * suffixMul[i];
        }

        return result;
 
    }

    // BEST

    // prefix + suffix approach (No array , only result array)
    // TC: O(n) 
    // SC: O(n) -> because of result array

    public static int[] productExceptSelf3(int[] nums) {
        int[] result = new int[nums.length];

        result[nums.length-1] = 1;
        int post = 1;
        for(int i = nums.length-2;i >= 0;i--) {
            post *= nums[i+1];
            result[i] = post;
        }

        int pre = 1;
        for(int i = 1;i < nums.length;i++) {
            pre *= nums[i-1];
            result[i] = pre * result[i];
        }

        return result;
 
    }

    public static void main(String[] args) {
        int[] input1 = {1,2,3,4};
        int[] input2 = {-1,1,0,-3,3};
        int[] output1 = productExceptSelf2(input1);

        for(int e:output1){
            System.out.print(e+" ");
        }
    }
}