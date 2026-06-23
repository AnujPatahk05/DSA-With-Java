/*
    540. Single Element in a Sorted Array
    (Medium)

    You are given a sorted array consisting of only integers where every element 
    appears exactly twice, except for one element which appears exactly once.

    Return the single element that appears only once.

    Your solution must run in O(log n) time and O(1) space.

    Example 1:

    Input: nums = [1,1,2,3,3,4,4,8,8]
    Output: 2
*/


public class _3_SingleElementInaSortedArray {

    // Brute Force Solution: (using XOR : a^a = 0)
    // TC: O(n)
    // SC: O(1)
    public static int singleNonDuplicate(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    // Brute Force Solution: (using Linear search)
    // TC: O(n)
    // SC: O(1)
    public static int singleNonDuplicate2(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return -1;
    }

    // Optimal Solution: Binary Search
    // If left and right are even ->
    //                              if(A[mid+1] == A[mid]) go right
    //                              else go left
    //  If left and right are odd ->
    //                              if(A[mid+1] == A[mid]) go left
    //                              else go right
    // TC: O(log n)
    // SC: O(1)
    public static int singleNonDuplicate3(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }
        
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        int si = 1;
        int ei = nums.length - 2;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            if (mid % 2 == 0) {//even
                if (nums[mid] == nums[mid + 1]) {//right
                    si = mid + 1;
                } else {//left
                    ei = mid - 1;
                }
            } else {//odd
                if (nums[mid] == nums[mid + 1]) {//right
                    ei = mid - 1;
                } else {//left
                    si = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] input1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate3(input1));

        int[] input2 = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(singleNonDuplicate3(input2));

        int[] input3 = {1, 2, 2, 3, 3};
        System.out.println(singleNonDuplicate3(input3));

    }

}
