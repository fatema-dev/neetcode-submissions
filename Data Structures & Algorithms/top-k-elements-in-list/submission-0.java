class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int[] res = new int [k];
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(count.keySet());

        Collections.sort(keys, (a, b) -> count.get(b) - count.get(a));
        for(int i=0; i < k; i++){
            res[i] = keys.get(i); 
        }
        return res;
    }
}
