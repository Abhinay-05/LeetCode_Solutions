/*
You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

If isWater[i][j] == 0, cell (i, j) is a land cell.
If isWater[i][j] == 1, cell (i, j) is a water cell.
You must assign each cell a height in a way that follows these rules:

The height of each cell must be non-negative.
If the cell is a water cell, its height must be 0.
Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
Find an assignment of heights such that the maximum height in the matrix is maximized.

Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.

Example 1:
Input: isWater = [[0,1],[0,0]]
Output: [[1,0],[2,1]]
Explanation: The image shows the assigned heights of each cell.
The blue cell is the water cell, and the green cells are the land cells.

Example 2:
Input: isWater = [[0,0,1],[1,0,0],[0,0,0]]
Output: [[1,1,0],[0,1,1],[1,2,2]]
Explanation: A height of 2 is the maximum possible height of any assignment.
Any height assignment that has a maximum height of 2 while still meeting the rules will also be accepted.
 
Constraints:
m == isWater.length
n == isWater[i].length
1 <= m, n <= 1000
isWater[i][j] is 0 or 1.
There is at least one water cell.
*/
// TC: O(mn)
// SC: O(mn)
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        boolean[][] visit = new boolean[m][n];//visited 
        int[][] dist = new int[m][n];//distance collection

        Queue<int[]> q = new LinkedList<>();//int[] = {i, j, dist}
        
        //add original 0(s) to the queue
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(isWater[i][j] == 1){
                    q.offer(new int[]{i,j,0});
                    visit[i][j] = true;
                }
            }
        }

        int[] node = {0, 0 ,0};
        while(!q.isEmpty()){
            node = q.poll();
            int i = node[0];
            int j = node[1];
            int dis = node[2];//distance [i][j]
            dist[i][j] = dis;

            if((i-1) >= 0 && !visit[i-1][j]){//up
                q.offer(new int[]{i-1, j, dis+1});
                visit[i-1][j] = true;
            }
            if((i+1) < m && !visit[i+1][j]){//down
                q.offer(new int[]{i+1, j, dis+1});
                visit[i+1][j] = true;
            }
            if((j-1) >= 0 && !visit[i][j-1]){//left
                q.offer(new int[]{i, j-1, dis+1});
                visit[i][j-1] = true;
            }
            if((j+1) < n && !visit[i][j+1]){//right
                q.offer(new int[]{i, j+1, dis+1});
                visit[i][j+1] = true;
            }
        }
        return dist;
    }
}
