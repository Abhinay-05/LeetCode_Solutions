class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        return sum(candidates,target,0,list);
    }

    List<List<Integer>> sum(int[] arr, int target, int i, List<Integer> list){
        List<List<Integer>> returnable = new ArrayList<>();

//        base case
        if(target == 0){
            returnable.add(new ArrayList<>(list));// new reference of the 1D list should be passed, because if the refrence remains same then the changes made in that list will be reflected here
            System.out.println(list);
            return returnable;
        }

        if(i == arr.length){
            return returnable;
        }

        if(arr[i] <= target){
            list.add(arr[i]);
            returnable.addAll(sum(arr, target - arr[i], i, list));
            list.removeLast();
        }

        returnable.addAll(sum(arr,target,i+1,list));

        return returnable;
    }
}
