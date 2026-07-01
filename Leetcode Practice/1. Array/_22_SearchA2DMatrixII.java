/*
    240. Search a 2D Matrix II
    (Medium)

    Write an efficient algorithm that searches for a value target in an m x n integer 
    matrix matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

    Example 1:
    Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
    Output: true
*/

public class _22_SearchA2DMatrixII {
    // Brute force approach
    // TC: O(m*n)
    // SC: O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int[] row:matrix) {
            for(int col:row) {
                if(col == target) return true;
            }
        }
        return false;
    }


    // Optimal Sol
    // Start from the top-right corner and eliminate one row or one column in each step based on the comparison with the target.
    // TC: O(m + n)
    // SC: O(1)
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n-1;

        while(i >= 0 && i < m && j >= 0 && j < n) {
            if(matrix[i][j] == target) return true;

            if(matrix[i][j] > target) j--;
            else i++;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30}
        };

        System.out.println(searchMatrix2(matrix, 5));
        System.out.println(searchMatrix2(matrix, 20));
    }
}
