class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (numbers.containsKey(diff)) {
                return new int[] {numbers.get(diff), i};
            }
            numbers.put(nums[i], i);
        }
        return new int[] {};
    }
}
