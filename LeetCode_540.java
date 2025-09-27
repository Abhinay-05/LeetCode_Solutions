/*
540. Single Element in a Sorted Array

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        // edge cases
        if(len == 1){
            return nums[0];
        }
        if(nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[len-1] != nums[len-2]){
            return nums[len-1];
        }

        int indx = modifiedBS(nums, 0, len-1);
        return nums[indx];
    }

    private int modifiedBS(int[] nums, int st, int end){
        if(st > end)return (-1);

        int mid = st +(end - st)/2;

        if(nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1]){
            return mid;
        }

        // if the single element is before then the first occurence of double element will be odd
        // if the single element is after then the first occurence of double element will be even

        if (nums[mid-1] == nums[mid]){
            mid--;
            if((mid&1) == 0){
                int x = modifiedBS(nums, mid+2,end);
                if(x != (-1)){
                    return x;
                }
            }
            return modifiedBS(nums, st, mid-1);
        }
        if((mid&1) == 0){
            int x = modifiedBS(nums, mid+1, end);
            if(x != (-1)){
                return x;
            }
        }
        return modifiedBS(nums, st,mid-1);
    }
}
