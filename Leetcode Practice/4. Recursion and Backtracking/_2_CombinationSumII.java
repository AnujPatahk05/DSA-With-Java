/*
    40. Combination Sum II
    (medium)

    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

    Each number in candidates may only be used once in the combination.

    Note: The solution set must not contain duplicate combinations.

    

    Example 1:

    Input: candidates = [10,1,2,7,6,1,5], target = 8
    Output: 
        [
            [1,1,6],
            [1,2,5],
            [1,7],
            [2,6]
        ]
    Example 2:

    Input: candidates = [2,5,2,1,2], target = 5
    Output: 
        [
            [1,2,2],
            [5]
        ]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _2_CombinationSumII {
    private static void combinationSum2Util(int[] candidates, 
                                           int target,
                                           int sum,
                                           int i,
                                           List<Integer> currResult,
                                           HashSet<List<Integer>> result) {
        
        if (sum == target) {
            result.add(new ArrayList<>(currResult));
            return;
        }

        if(sum > target || i == candidates.length) {
            return;
        }

        currResult.add(candidates[i]);
        combinationSum2Util(candidates, target, sum+candidates[i], i+1, currResult, result);
        currResult.remove(currResult.size() - 1);

        combinationSum2Util(candidates, target, sum, i+1, currResult, result);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> result = new HashSet<>();
        combinationSum2Util(candidates, target, 0, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] arr1 = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(arr1, target));
    }
}
