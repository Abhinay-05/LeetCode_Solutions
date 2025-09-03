/*
59. Spiral Matrix II

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
*/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int put = 1; // number to be placed at an index

        int row = 0;
        int col = 0;    
        matrix[row][col] = put;
        put++;

        while(put <= Math.pow(n,2)){
            // move right
            while(isSafe(matrix,row,col+1)){
                matrix[row][++col] = put;
                put++;
            }

            // move down
            while(isSafe(matrix,row+1,col)){
                matrix[++row][col] = put;
                put++;
            }

            // move left
            while(isSafe(matrix,row,col-1)){
                matrix[row][--col] = put;
                put++;
            }

            // move up
            while(isSafe(matrix,row-1,col)){
                matrix[--row][col] = put;
                put++;
            }
        }
        return matrix;
    }

    boolean isSafe(int[][] matrix, int row, int col){
        if(row >= 0 && row < matrix.length && col >= 0 && col < matrix.length){

        }
        else{
            return false;
        }

        if(matrix[row][col] != 0){
            return false;
        }
        return true;
    }
}
