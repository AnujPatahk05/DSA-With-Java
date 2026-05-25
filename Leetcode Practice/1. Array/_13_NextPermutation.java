/*
    31. Next Permutation
    (medium)

    A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

    For example, for arr = [1,2,3], the following are all the permutations of arr: 
    [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].

    For example, the next permutation of arr = [1,2,3] is [1,3,2].

    Similarly, the next permutation of arr = [2,3,1] is [3,1,2].

    While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] 
    does not have a lexicographical larger rearrangement.

    Example 1:

    Input: nums = [1,2,3]
    Output: [1,3,2]
    Example 2:

    Input: nums = [3,2,1]
    Output: [1,2,3]
    Example 3:

    Input: nums = [1,1,5]
    Output: [1,5,1]
*/


import java.util.ArrayList;
import java.util.Arrays;

public class _13_NextPermutation {
    private static int next = 0;

    public static void permutations(int[] nums,ArrayList<Integer> permutations,ArrayList<ArrayList<Integer>> all,boolean[] isUsed){
        if(permutations.size() == nums.length){
            all.add(new ArrayList<>(permutations));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                permutations.add(nums[i]);
                permutations(nums,permutations,all,isUsed);
                isUsed[i] = false;
                permutations.remove(permutations.size()-1);
            }
        }
    }

    public static void nextPermutation(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> allPermutations = new ArrayList<>();

    }

    public static void nextPermutation2(int[] nums) {

        // STEP 1:
        // Find the pivot element.
        // Pivot = first element from right such that:
        // nums[i] < nums[i+1]
        // This is the point where next permutation can be formed.
        
        int pivot = -1;

        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // STEP 2:
        // If no pivot found, array is in decreasing order.
        // Example: [5,4,3,2,1]
        // This is already the largest permutation.
        // So return smallest permutation by sorting/reversing.

        if(pivot == -1) {
            Arrays.sort(nums);
            return;
        }

        // STEP 3:
        // Find the next greater element than pivot from right side.
        // We choose the first greater element from right
        // to get the immediate next permutation.

        int nextGreaterToPivot = -1;

        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] > nums[pivot]) {
                nextGreaterToPivot = i;
                break;
            }
        }

        // STEP 4:
        // Swap pivot and next greater element.

        int temp = nums[pivot];
        nums[pivot] = nums[nextGreaterToPivot];
        nums[nextGreaterToPivot] = temp;

        // STEP 5:
        // Reverse the suffix part after pivot.
        // Because suffix is currently in decreasing order,
        // reversing makes it smallest possible increasing order.

        int i = pivot + 1;
        int j = nums.length - 1;

        while(i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }

        // Print final next permutation

        Arrays.stream(nums)
                .mapToObj(n -> n + " ")
                .forEach(System.out::print);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,3,2};
        // ArrayList<ArrayList<Integer>> allPermutations = new ArrayList<>();
        // permutations(nums, new ArrayList<>(),allPermutations, new boolean[nums.length]);
        // System.out.println(allPermutations);
        nextPermutation2(nums);
    }
}
