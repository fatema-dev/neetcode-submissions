class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> occur = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            occur.put(s.charAt(i), occur.getOrDefault(s.charAt(i), 0) + 1);
            occur.put(t.charAt(i), occur.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (Integer value : occur.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
