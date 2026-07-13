class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        List<Integer> combinations = new ArrayList<>();
        backtrack(0, combinations, target);
        return res;
    }

    public void backtrack(int idx, List<Integer> combinations ,int target){
        //found a sum combination
        if(target == 0){
            res.add(new ArrayList<>(combinations));
            return;
        }

        if(target < 0 || idx == nums.length){ //sum bigger than target / reached end of options
            return;
        }

        //inclusion/exclusion approach
        combinations.add(nums[idx]);
        backtrack(idx, combinations, (target - nums[idx])); //choose same element
        combinations.remove(combinations.size() - 1);
        backtrack(idx+1, combinations, target); //move to next element
    }
}
