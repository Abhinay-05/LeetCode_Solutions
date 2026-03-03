/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000
*/

class Solution {
    // compute answers in two parts
    // 1 -> (0->n-1)
    // 2 -> (1->n)
    // return max(1,2)

    // TC: O(n) ~ O(2n)
    // SC: O(n)
        public int rob(int[] nums){
        int n = nums.length;
        // only one element
        if(n == 1){
            return nums[0];
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans0 = rob(0,n-1, nums, dp);

        Arrays.fill(dp, -1);
        int ans1 = rob(1, n, nums, dp);
        return Math.max(ans0, ans1);
    }
    public int rob(int i, int n, int[] nums, int[] dp){
        if(i >= n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

//        don't Rob
        int dontRob = rob(i+1, n , nums, dp);

//        rob
        int rob = nums[i] + rob(i+2, n , nums, dp);

        dp[i] = Math.max(dontRob, rob);
        return dp[i];
    }
}
