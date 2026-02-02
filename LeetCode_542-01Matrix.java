/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two cells sharing a common edge is 1.

Example 1:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Example 2:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 
Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
*/

//Instead of going from 1(s) to 0(s)
//Try to start from 0
class Solution {
    // TC: O(m*n)
    // SC: O(2(m*n))
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean[][] visit = new boolean[m][n];//visited 
        int[][] dist = new int[m][n];//distance collection

        Queue<int[]> q = new LinkedList<>();//int[] = {i, j, dist}
        
        //add original 0(s) to the queue
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 0){
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
