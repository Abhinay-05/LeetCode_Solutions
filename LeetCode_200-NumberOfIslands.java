/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/

class Solution {
    // DFS
    // TC : O(m*n)
    // SC : O(1)
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int island = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1'){
                    island++;
                    DFS(i,j,grid);
                }
            }
        }
        return island;
    }

    private void DFS(int i, int j, char[][] grid){
        //out of bound
        // 0
        // already visited
        if((i<0) || (j<0) || (i>=grid.length) || (j>=grid[0].length) || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';//mark visited

        DFS(i-1,j,grid);//up
        DFS(i,j-1,grid);//left
        DFS(i+1,j,grid);//down
        DFS(i,j+1,grid);//right
    }
}
