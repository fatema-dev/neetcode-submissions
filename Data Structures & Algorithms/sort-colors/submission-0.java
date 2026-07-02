class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;

        int[] buckets = new int [3];

        for(int num : nums){
           buckets[num]++;
        }
    
       int j=0;
       for(int i=0; i<buckets.length; i++){
            while(buckets[i] > 0){
                nums[j] = i;
                buckets[i]--;
                j++;
            }
       }

    }
}