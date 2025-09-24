/*
74. Search a 2D Matrix

You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int j = 0;
        int m = matrix[0].length - 1;
        int n = matrix.length - 1;

        while(j <= n){
            int mid = j + (n - j)/2;

            if(matrix[mid][0] <= target && target <= matrix[mid][m]){
                return binarySearch(matrix, mid, target);
            }

            if(matrix[mid][m] < target){
                j = mid + 1;
            }
            else{
                n = mid - 1;
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int m, int target){
        int st = 0, end = matrix[0].length - 1;

        while(st <= end){
            int mid = st + (end - st)/2;

            if(matrix[m][mid] == target){
                return true;
            }

            if(matrix[m][mid] < target){
                st = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return false;
    }
    
}
