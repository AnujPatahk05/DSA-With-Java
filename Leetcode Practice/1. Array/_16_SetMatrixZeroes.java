/*
    73. Set Matrix Zeroes
    (Medium)

    Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
    You must do it in place.

    Example:

    Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
    Output: [[1,0,1],[0,0,0],[1,0,1]]
*/


public class _16_SetMatrixZeroes {
    //Brute forch approach:
    //TC: O(m*n*(m+n))
    //SC: O(m*n)

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] zero = new boolean[m][n];

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == 0){
                    //Horizontaly
                    for(int col = 0;col < n;col++){
                        zero[i][col] = true; 
                    }

                    //Vertically
                    for(int row = 0;row < m;row++){
                        zero[row][j] = true;
                    }
                }
            }
        }

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(zero[i][j]){
                    matrix[i][j] = 0;
                }
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};

        for(int[] row:matrix){
            for(int i:row){
                System.out.print(i+" ");
            }
            System.out.println();
        }

        System.out.println("---------");

        setZeroes(matrix);
     }
}
