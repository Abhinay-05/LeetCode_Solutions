/*
46. Permutations

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
*/

class Solution {
    // permutation using backtracking
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        return permutations(nums, ans);
    }

    List<List<Integer>> permutations(int[] nums, List<Integer> print){
        List<List<Integer>> ans = new ArrayList<>();

        if(nums.length == 0){
            ans.add(new ArrayList<>(print));
            return ans;
        }

        int ch = nums[0];
        for(int i = 0 ; i <= print.size() ; i++){
            List<Integer> first = print.subList(0,i);
            List<Integer> second = print.subList(i,print.size());
            List<Integer> list = new ArrayList<>();
            list.addAll(first);
            list.add(ch);
            list.addAll(second);
            // copy of list is substring for array
            ans.addAll(permutations(Arrays.copyOfRange(nums, 1, nums.length) , list));
        }
        return ans;
    }
}
