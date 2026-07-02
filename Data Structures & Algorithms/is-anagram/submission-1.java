class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> occurS = new HashMap<Character, Integer>();
        Map<Character, Integer> occurT = new HashMap<Character, Integer>();


        for (int i=0; i < s.length(); i++){
            if(occurS.containsKey(s.charAt(i))){
                occurS.put(s.charAt(i), occurS.get(s.charAt(i) + 1));
            } else {
                occurS.put(s.charAt(i), 1);
            }
        }

        for (int i=0; i < t.length(); i++){
            if(occurT.containsKey(t.charAt(i))){
                occurT.put(t.charAt(i), occurT.get(t.charAt(i) + 1));
            } else {
                occurT.put(t.charAt(i), 1);
            }
        }

        return occurS.equals(occurT);
    }
}
