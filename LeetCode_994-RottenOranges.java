/*
You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
*/
class Solution {
    // SC: O(m*n)
    // TC: O(m*n)
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        //add first rotten indices
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair<>(i, j));
                }
            }
        }

        int minutes = -1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                Pair<Integer, Integer> curr = q.poll();
                int row = curr.getKey();
                int col = curr.getValue();
                //set adjacent indices
                if((row-1) >= 0 && grid[row-1][col] == 1){
                    grid[row-1][col] = 2;
                    q.offer(new Pair<>(row-1,col));
                }
                if((col-1) >= 0 && grid[row][col-1] == 1){
                    grid[row][col-1] = 2;
                    q.offer(new Pair<>(row,col-1));
                }
                if((row+1) < m && grid[row+1][col] == 1){
                    grid[row+1][col] = 2;
                    q.offer(new Pair<>(row+1,col));
                }
                if((col+1) < n && grid[row][col+1] == 1){
                    grid[row][col+1] = 2;
                    q.offer(new Pair<>(row,col+1));
                }
            }
            minutes++;
        }
        //check for any fresh oranges
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return minutes > -1 ? minutes : 0;//edge case
        //avoids grid with no oranges
    }
}

