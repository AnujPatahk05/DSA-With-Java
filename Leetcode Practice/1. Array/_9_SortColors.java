
import java.util.Arrays;

/*
    75. Sort Colors
    (medium)

    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the 
    same color are adjacent, with the colors in the order red, white, and blue.

    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

    You must solve this problem without using the library's sort function.

    Example:

    Input: nums = [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]
*/

public class _9_SortColors {
    public static void sortColors(int[] nums){
        int[] countArr = new int[3];

        for(int num:nums){
            countArr[num]++;
        }

        int idx = 0;

        for(int i = 0;i < 3;i++){
            while(countArr[i] > 0){
                nums[idx++] = i;
                countArr[i]--;
            }   
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        Arrays.stream(arr).mapToObj(n -> n+" ").forEach(System.out::print);
    }
}
