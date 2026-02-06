/*
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation:
In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Example 2:
Input: board = [["X"]]
Output: [["X"]]

 
Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
*/

class Solution {
    // TC: O(m*n) + O(m*n)
    // SC: O(m*n) due to recursion stack
//    1
//    mark all the edge O(s) as '$'
//    mark all the connected '$' also as '$'
//    2
//    mark all '$' as 'O'
//    mark all 'O' as 'X'
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        //first and last row
        for(int j = 0 ; j < n ; j++){
            if(board[0][j] == 'O'){
                convert(0, j, board);
            }
            if(board[m-1][j] == 'O'){
                convert(m-1, j, board);
            }
        }
        //first and last column
        for(int i = 0 ; i < m ; i++){
            if(board[i][0] == 'O'){
                convert(i, 0, board);
            }
            if(board[i][n-1] == 'O'){
                convert(i, n-1, board);
            }
        }
        //mark all 'O' as 'X'
        //mark all '$' as 'O'
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == '$'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void convert(int i, int j, char[][] board){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '$'){
            return;
        }
        board[i][j] = '$';
        convert(i-1, j, board);
        convert(i, j-1, board);
        convert(i+1, j, board);
        convert(i, j+1, board);
    }
}
