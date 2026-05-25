/*
    56. Merge Intervals
    (Medium)

    Given an array of intervals where intervals[i] = [starti, endi], 
    merge all overlapping intervals, and return an array of the 
    non-overlapping intervals that cover all the intervals in the input.

    Example:

    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _14_MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1;i < intervals.length;i++){
            if(intervals[i][0] <= end){
                end = Math.max(end,intervals[i][1]);
            }else{
                result.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        result.add(new int[]{start,end});

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,12},{2,6},{8,10},{15,18}};
        int[][] result = merge(intervals);

        for(int[] interval:result){
            for(int i:interval){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
