class KthLargest {
    List<Integer> arr = new ArrayList<>();
    int kth;

    public KthLargest(int k, int[] nums) {
        this.kth = k;
        for(int num : nums){
            arr.add(num);
        }
    }

    public int add(int val) {
        arr.add(val);
        Collections.sort(arr);
        return arr.get(arr.size() - kth);
    }
}
