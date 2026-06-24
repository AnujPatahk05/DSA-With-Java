
import java.util.Arrays;

/*
    283. Move Zeroes
    (easy)

    Given an integer array nums, move all 0's to the end of it while maintaining 
    the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.

    Example 1:

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
*/
public class MoveZeroes {
    // Solution with extra array
    // TC: O(n)
    // SC: O(n)
    public static void moveZeroes(int[] nums) {
        int[] temp = new int[nums.length];
        int idx = 0;

        for(int num:nums) {
            if(num != 0) temp[idx++] = num;
        }

        System.arraycopy(temp,0,nums,0,nums.length);
    }

    // Two pointer approach:(Optimal solution with constant space)
    // 1st pointer (i) iterates through the array
    // 2nd pointer (idx) keeps track of the position where the next non-zero element should be placed
    // TC: O(n)
    // SC: O(1)
    public static void moveZeroes2(int[] nums) {
        int idx = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                idx++;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr1 = {0,1,0,3,12};
        moveZeroes2(arr1);
        Arrays.stream(arr1).forEach(System.out::println);
    }
}
