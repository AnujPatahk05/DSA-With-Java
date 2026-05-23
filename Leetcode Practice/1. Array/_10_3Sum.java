/*
    15. 3Sum
    (medium)

    Given an integer array nums, return all the triplets 
    [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, 
    and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.

    Example:

    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Explanation: 
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    The distinct triplets are [-1,0,1] and [-1,-1,2].
    Notice that the order of the output and the order of the triplets does not matter.

*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;



public class _10_3Sum {
    // 1. Brute force approach 
    // TC: O(n^3)
    // SC: O(n^3)
    public static  List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();
        int n = nums.length;

        for(int i = 0;i < n-2;i++){
            for(int j = i+1;j < n-1;j++){
                for(int k = j+1;k < n;k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> input = new ArrayList<>();
                        input.add(nums[i]);
                        input.add(nums[j]);
                        input.add(nums[k]);
                        input.sort((a,b)->a-b);
                        result.add(input);
                    }
                }
            }
        }

        return result.stream().toList();
    }

    //2. Optimal approach
    // TC: O(n log n) + O(n^2) = O(n^2)

    public static  List<List<Integer>> threeSum2(int[] nums) {
        // HashSet<List<Integer>> result = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i = 0;i < n-2;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int j = i+1;
            int k = n-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0){
                    result.add(List.of(nums[i],nums[j],nums[k]));
                    
                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--; 

                }else if(sum < 0){ 
                    j++;
                }else{
                    k--;
                }
            }
        }

        // return result.stream().toList();
        return result;
    }
    

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums2 = {0,1,1};
        int[] nums3 = {0,0,0};

        System.out.println(threeSum2(nums3));
    }
}
