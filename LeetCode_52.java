class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return queens(board,0);
    }

    int queens(boolean[][] board, int row){
        if(row == board.length){
            return 1;
        }

        int count = 0;

        for(int col = 0 ; col < board[0].length ; col++){
            if(isSafe(board,row,col)){
                board[row][col] = true;
                count += queens(board, row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    boolean isSafe(boolean[][] board, int row, int col){
        
        for(int i = 0 ; i < row ; i++){
            if(board[i][col]){
                return false;
            }
        }

        int leftMoves = Math.min(row, col);
        for(int i = 1 ; i <= leftMoves ; i++){
            if(board[row-i][col-i]){
                return false;
            }
        }

        int rightMoves = Math.min(row, board[0].length - 1 - col);
        for(int i = 1 ; i <= rightMoves ; i++){
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }
}
