class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map <String, List<String>> res = new HashMap<>();

        for (String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String key = Arrays.toString(charArray);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(str);
        }
        return new ArrayList<>(res.values());
    }
}
