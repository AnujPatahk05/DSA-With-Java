/*
    118. Pascal's Triangle
    (easy)

    Given an integer numRows, return the first numRows of Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


    

    Example 1:

    Input: numRows = 5
    Output: [
             [1],
            [1,1],
           [1,2,1],
          [1,3,3,1],
         [1,4,6,4,1]
    ]
*/

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    // TC: O(numRows^2)
    // SC: O(numRows^2)
    public static List<List<Integer>> generate(int numRows) {
         List<List<Integer>> result = new ArrayList<>();
         
         for(int i = 0;i < numRows;i++) {
            List<Integer> row = new ArrayList<>();

            row.add(1);

            for(int j = 1;j < i;j++) {
                row.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }

            if(i > 0) {
                row.add(1);
            }

            result.add(row);
         }

         return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(3));
        System.out.println(generate(5));
    }
}