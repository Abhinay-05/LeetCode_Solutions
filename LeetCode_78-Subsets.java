/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 
Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0, new ArrayList<Integer>());
    }
    private List<List<Integer>> subsets(int[] nums, int i, List<Integer> sub){
        List<List<Integer>> list = new ArrayList<>();
        if(i == nums.length){
            list.add(new ArrayList<>(sub));
            return list;
        }

        // no addition
        list.addAll(subsets(nums, i+1, sub));
        // add current
        sub.add(nums[i]);
        list.addAll(subsets(nums, i+1, sub));
        sub.removeLast();

        return list;
    }
}
