/*
    119. Pascal's Triangle II
    (easy)

    Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
    
    Example:
    Input: rowIndex = 3
    Output: [1,3,3,1]

             [1] -> 0
            [1,1] -> 1
           [1,2,1] -> 2
          [1,3,3,1] -> 3
         [1,4,6,4,1] -> 4
 */

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    // TC: O(numRows^2)
    // SC: O(numRows^2)
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> fullResult = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();

            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(fullResult.get(i - 1).get(j - 1) + fullResult.get(i - 1).get(j));
            }

            if (i > 0) {
                row.add(1);
            }

            fullResult.add(row);
        }

        return fullResult.get(rowIndex);
    }

    // TC: O(numRows^2)
    // SC: O(numRows)
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> prev = List.of(1);
        if(rowIndex == 0) return prev;

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();

            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(prev.get(j - 1) + prev.get(j));
            }

            if (i > 0) {
                row.add(1);
            }

            prev = row;
        }

        return prev;

    }       

    public static void main(String[] args) {
        System.out.println(getRow2(3));
    }
}
