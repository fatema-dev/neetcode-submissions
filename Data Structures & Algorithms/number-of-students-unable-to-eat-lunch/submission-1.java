class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int len = students.length;
        int res = len;
        int[] cnt = new int[2];

        for (int std : students){
           if (std == 0) {cnt[0]++;} 
           else {cnt[1]++;}
        }

        for(int sandwich: sandwiches){
            if (cnt[sandwich] > 0){
                res--;
                cnt[sandwich]--;
            } else {
                break;
            }
        }
    return res;

    }
}