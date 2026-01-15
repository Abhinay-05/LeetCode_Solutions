/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
 
Constraints:
1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int sum = 0;
        int count = 0;
        int len = nums.size();
        unordered_map<int,int> map;//less time than map
        for(int i = 0 ; i < len ; i++){
            sum += nums.at(i);//current prefix sum
            if(sum == k){
                count++;
            }
            int remaining = sum - k;
            if(map.count(remaining)){//if the remaining exists in the map
                count += map[remaining];
            }
            map[sum]++;//increase count OR add new prefix sum
        }
        return count;
    }
};
