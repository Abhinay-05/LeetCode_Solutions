/*
48. Rotate Image

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
*/

class Solution {

    // 1. Transpose the matrix
    // 2. Reverse the 1D array
    public void rotate(int[][] matrix) {
        transpose(matrix);

        for(int[] arr : matrix){
            reverse(arr);
        }
    }


    // reversal of array
    void reverse(int[] arr){
        int st = 0 ; 
        int end = arr.length - 1;
        while(st < end){
            int temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }
    }

    // in-place transpose
    void transpose(int[][] matrix){
        int n = matrix.length;
        int[][] ans = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
