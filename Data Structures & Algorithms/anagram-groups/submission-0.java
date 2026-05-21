class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> myMap = new HashMap<>();

        for(String s:strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);

            String str = new String(charArray);

            myMap.computeIfAbsent(str, k -> new ArrayList<>()).add(s);    
        }

        return new ArrayList<>(myMap.values());

    }
}
