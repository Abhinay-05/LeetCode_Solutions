/*
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Example 1:
Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

Example 2:
Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] is either 0 or 1.
*/

//find corner land(s) and turn all the connected land(s) into water along with it
class Solution {
// TC: O(mn)
// SC: O(mn)
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max = Math.max(m,n);
        // first and last rows and columns
        for(int i = 0 ; i < max ; i++){//if the index is invalid, then it will return on base case
            convert(0,i,grid,m,n);//first row
            convert(m-1,i,grid,m,n);//last row
            convert(i,0,grid,m,n);//first column
            convert(i,n-1,grid,m,n);//last column
        }

        //count number of lands left
        int count1 = 0;
        for(int i = 1 ; i < m-1 ; i++){
            for(int j = 1 ; j < n-1 ; j++){
                if(grid[i][j] == 1){
                    count1++;
                }
            }
        }
        return count1;
    }
    //convert all land connected to corner land into water
    // DFS
    private void convert(int i, int j, int[][] grid, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == 0){
            return;
        }
        
        grid[i][j] = 0;// convert land into water

        convert(i-1,j,grid,m,n);
        convert(i,j-1,grid,m,n);
        convert(i+1,j,grid,m,n);
        convert(i,j+1,grid,m,n);
    }
}
