/*
    74. Search a 2D Matrix
    (Medium)

    You are given an m x n integer matrix matrix with the following two properties:

    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.
    Given an integer target, return true if target is in matrix or false otherwise.

    You must write a solution in O(log(m * n)) time complexity.

    Example 1:


    Input: matrix = [[1 ,3 ,5 ,7 ],
                     [10,11,16,20],
                     [23,30,34,60]
                    ], target = 3
    Output: true
*/


public class _12_SearchA2DMatrix {
    //Complexity -> O(m*n)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int x = 0;
        int y = n-1;

        while(x >= 0 && x < m && y >=0 && y < n){
            if(matrix[x][y] == target) return true;
            else if(matrix[x][y] > target) y--;
            else x++;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{ 1, 3, 5, 7},
                          {10,11,16,20},
                          {23,30,34,60}
                        };

        System.out.println(searchMatrix(matrix, 61));
    }
}
