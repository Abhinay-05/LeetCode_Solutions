/*
54. Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.

Photo link
https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; // number of rows
        int n = matrix[0].length;  // number of rows
        int remaining = m*n; //number of tiles remaining

        // matrix to store visted tiles
        // visited = true
        // unvisited = false
        boolean[][] check =  new boolean[m][n];

        // to store the answer list
        List<Integer> list = new ArrayList<>();
        int row = 0; // row counter
        int col = 0; // column counter
        list.add(matrix[row][col]); // insert [0][0]
        check[row][col] = true; // mark [0][0] as visited
        remaining--;    // number of remaining tiles

        // move 
        while(/*(row != m/2 || col != n/2) &&*/ remaining != 0){
            // move right
            while(isSafe(check, row, col+1)){
                list.add(matrix[row][col+1]);
                check[row][col+1] = true;
                col++;
                remaining--;
            }

            // move down
            while(isSafe(check, row+1, col)){
                list.add(matrix[row+1][col]);
                check[row+1][col] = true;
                row++;
                remaining--;
            }

            // move left
            while(isSafe(check, row, col-1)){
                list.add(matrix[row][col-1]);
                check[row][col-1] = true;
                col--;
                remaining--;
            }

            // move up
            while(isSafe(check, row-1, col)){
                list.add(matrix[row-1][col]);
                check[row-1][col] = true;
                row--;
                remaining--;
            }
        }
        return list;
    }

// check if a given tile is safe 
    boolean isSafe(boolean[][] check, int row, int col){
        int m = check.length;
        int n = check[0].length;

      // if it even exists
        if(row >= 0 && row < m && col >= 0 && col < n){
                // check further to see if the tile is already visited or not
        }
        else{
            return false;
        }

      // if it is already visited
        if(check[row][col]){
            return false;
        }
        return true;
    }
}
