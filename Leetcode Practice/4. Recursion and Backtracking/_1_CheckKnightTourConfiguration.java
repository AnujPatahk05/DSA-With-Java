/*
    2596. Check Knight Tour Configuration
    (Medium)

    There is a knight on an n x n chessboard. In a valid configuration, the knight starts at the top-left cell of the 
    board and visits every cell on the board exactly once.

    You are given an n x n integer matrix grid consisting of distinct integers from the range [0, n * n - 1] where grid[row][col] 
    indicates that the cell (row, col) is the grid[row][col]th cell that the knight visited. The moves are 0-indexed.

    Return true if grid represents a valid configuration of the knight's movements or false otherwise.

    Note that a valid knight move consists of moving two squares vertically and one square horizontally, or two squares 
    horizontally and one square vertically. The figure below illustrates all the possible eight moves of a knight from some cell.

    Input: grid = [
                  [0 ,11,16,5 ,20],
                  [17,4 ,19,10,15],
                  [12,1 ,8 ,21,6 ],
                  [3 ,18,23,14,9 ],
                  [24,13,2 ,7 ,22]
    ]
    Output: true
    Explanation: The above diagram represents the grid. It can be shown that it is a valid configuration.
*/

public class _1_CheckKnightTourConfiguration {
    // O(n²) Simulation | Traverse the Knight's Tour by Checking Only 8 Possible Moves | O(1) Space
    // Iteration Approach / No recursion
    // TC: O(n²)
    // SC: O(1)
    public static boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;

        int n = grid.length;

        int[][] moves = {
            {-2,-1}, {-2,1},
            {-1,-2}, {-1,2},
            {2,-1},{2,1},
            {1,-2},{1,2}
        };

        int x = 0;
        int y = 0;
        for(int i = 1;i < n*n;i++) {
            boolean found = false;
            for(int j = 0;j < moves.length;j++) {
                int nextX = x + moves[j][0];
                int nextY = y + moves[j][1];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;

                if(grid[nextX][nextY] == i) {
                    x = nextX;
                    y = nextY;
                    found = true;
                    break;
                }
            }

            if(!found){
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        int[][] grid = {
            {0,11,16,5,20},
            {17,4,19,10,15},
            {12,1,8,21,6},
            {3,18,23,14,9},
            {24,13,2,7,22}
        };

        System.out.println(checkValidGrid(grid));
    }
}
