/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
-> 0 <= a, b, c, d < n
-> a, b, c, and d are distinct.
-> nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

Constraints:
1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
*/

class Solution {
    //TC: O(N*N*N)
    // SC: O(1)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int c = 0, d = 0;
        for(int a = 0 ; a < len ; a++){
            if(a > 0 && nums[a-1] == nums[a]){//skip repeating elements
                continue;
            }
            for(int b = a+1 ; b < len ; b++){
                if(b > a+1 && nums[b] == nums[b-1]){//skip repeating elements
                    continue;
                }
                c = b+1;
                d = len-1;
                while(c < d){
                    long sum = ((long)nums[a]+(long)nums[b]+(long)nums[c]+(long)nums[d]);//edge case(int overflow)
                    if(sum == target){
                        List subList = new ArrayList<>();
                        subList.add(nums[a]);
                        subList.add(nums[b]);
                        subList.add(nums[c]);
                        subList.add(nums[d]);
                        list.add(subList);
                        c++;
                        d--;
                        //skip repeating indices
                        while(c < d && nums[c-1] == nums[c]){
                            c++;
                        }
                        while(c < d && nums[d+1] == nums[d]){
                            d--;
                        }
                    }
                    else if(sum < target){
                        c++;
                    }
                    else{
                        d--;
                    }
                }
            }
        }
        return list;
    }
}
