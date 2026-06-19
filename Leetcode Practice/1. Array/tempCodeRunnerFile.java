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