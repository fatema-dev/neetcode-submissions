class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        //pointers
        int low = 0;
        int mid = 0;
        int high = len-1;

        while (high >= mid){
            if (nums[mid] == 0){
                int temp = nums[low];
                nums[low++] = 0;
                nums[mid++] = temp;
            }else if(nums[mid] == 1){
                mid++;
            }else {
                int temp = nums[high];
                nums[high--] = 2;
                nums[mid] = temp;
            }
        }
    }
}