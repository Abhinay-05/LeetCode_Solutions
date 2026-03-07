/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.


Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 
Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 200
*/

class Solution {
    // MEMOIZATION
    // TC: O(m*n)
    // SC: O(m*n)
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return minPathSum(grid, 0, 0, m, n, dp);
    }
        private int minPathSum(int[][] grid,int i, int j, int m, int n, int[][] dp){
        if(i == (m-1) && j == (n-1)){
            dp[i][j] =  grid[i][j];//destination
        }
        if(dp[i][j] != (-1)){
            return dp[i][j];
        }

        int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
        if((j+1) < n){
            right = minPathSum(grid, i, j+1, m, n, dp);
        }
        if((i+1) < m){
            down = minPathSum(grid, i+1, j, m, n, dp);
        }
        dp[i][j] = Math.min(right, down) + grid[i][j];
        return dp[i][j];
    }
}
