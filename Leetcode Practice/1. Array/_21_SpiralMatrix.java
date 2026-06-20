/*
    54. Spiral Matrix
    (Medium)

    Given an m x n matrix, return all elements of the matrix in spiral order.

    Example:
    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [1,2,3,6,9,8,7,4,5]
*/

import java.util.ArrayList;
import java.util.List;

public class _21_SpiralMatrix {
    // TC: O(m*n)
    // SC: O(1)  (O(m*n) if we include result List)
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int startRow = 0;
        int endRow = matrix.length-1;

        int startCol = 0;
        int endCol = matrix[0].length-1;

        while(startRow <= endRow && startCol <= endCol) {
            // Top
            for(int i = startCol; i <= endCol;i++) {
                result.add(matrix[startRow][i]);
            }

            // Right
            for(int i = startRow+1;i <= endRow;i++) {
                result.add(matrix[i][endCol]);
            }

            // Bottom
            if(startRow != endRow) {
                for(int i = endCol-1;i >= startCol;i--) {
                    result.add(matrix[endRow][i]);
                }
            }

            if(startCol != endCol) {
                for(int i = endRow-1; i > startRow;i--) {
                    result.add(matrix[i][startCol]);
                }
            }

            startRow ++;
            endRow --;
            startCol ++;
            endCol --;

        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                            {1,2,3,4},
                            {12,13,14,5},
                            {11,16,15,6},
                            {10,9,8,7}
        };

        int[][] matrix2 ={
                            {1,2,3,4,5},
                            {12,13,14,15,6},
                            {11,10,9,8,7}
        };

        int[][] matrix3 ={
                            {1,2,3},
                            {12,13,4},
                            {11,14,5},
                            {10,15,6},
                            {9,8,7}
        };

        System.out.println(spiralOrder(matrix));
        System.out.println(spiralOrder(matrix2));
        System.out.println(spiralOrder(matrix3));
    }
}
