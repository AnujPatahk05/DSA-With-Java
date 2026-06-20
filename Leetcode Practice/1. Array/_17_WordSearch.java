/*
    79. Word Search
    (medium) --> https://dsa.apnacollege.in/

    Given an m x n grid of characters board and a string word, return true if word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are 
    horizontally or vertically neighboring. The same letter cell may not be used more than once.

    Example:

    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    Output: true
*/


public class _17_WordSearch {
    // Time Complexity  : O(m * n *  3^L), 3 mean we have to visit 3 directions, L is length of word
    // Space Complexity : O(m*n) -> extra space
    //                    O(L) -> memory stack
    // So overall : O(m*n*L)
    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++){
                if(board[i][j] == word.charAt(0) && dfs(board,i,j,word,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board,int x,int y, String word,int i,boolean[][] visited) {
        if(visited[x][y]){
            return false;
        }

        if(word.charAt(i) != board[x][y]) {
            return false;
        }

        if(i == word.length()-1) {
            return true;
        }

        visited[x][y] = true;

        boolean found = (x+1 < board.length && dfs(board,x+1,y,word,i+1,visited)) ||
            (x-1 >= 0 && dfs(board,x-1,y, word,i+1,visited)) ||
            (y+1 < board[0].length && dfs(board,x,y+1, word,i+1,visited)) ||
            (y-1 >= 0 && dfs(board,x,y-1, word,i+1,visited));
        

        visited[x][y] = false;

        return found;
    }

    // Solution without using extra space : O(m*n)
    // Space Complexity : O(L)

    public static boolean exist2(char[][] board, String word) {
        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                if(board[i][j] == word.charAt(0) && dfs2(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs2(char[][] board,String word,int row,int col,int i) {
        if(i == word.length()) {
            return true;
        }

        if(row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length
         ){
            return false;
         }

         if(board[row][col] != word.charAt(i)){
            return false;
         }

         char temp = board[row][col];
         board[row][col] = '#';

         boolean found = 
            dfs2(board, word,row+1, col, i+1) ||
            dfs2(board, word,row-1, col, i+1) ||
            dfs2(board, word,row, col+1, i+1) ||
            dfs2(board, word,row, col-1, i+1);

        board[row][col] = temp;
        
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                            {'S','F','C','S'},
                            {'A','D','E','E'}
        };

        String word = "ABCCED";

        System.out.println(exist2(board, word));


    }


}
