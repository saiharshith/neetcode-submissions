class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> answer = new ArrayList<>();
        Map<Character,Integer> lastIndex = new HashMap<>();

        for(int i=0;i<s.length();i++){
            lastIndex.put(s.charAt(i),i);
        }

        int parseTill;

        for(int i=0;i<s.length();i++){
            parseTill=lastIndex.get(s.charAt(i));
            int count=0;
            for(int j=i;j<=parseTill;j++){
                count++;
                parseTill=Math.max(parseTill,lastIndex.get(s.charAt(j)));
            }
            answer.add(count);
            i=parseTill;    
        }

        return answer;

    }
}
