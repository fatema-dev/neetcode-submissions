class Solution {
    public int[] replaceElements(int[] arr) {
        int last = arr.length - 1;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == last) {
                arr[i] = -1;
                break;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > max){
                    max = arr[j];
                }
            }
            arr[i] = max;
            max = 0;
        }
        return arr;
    }
}