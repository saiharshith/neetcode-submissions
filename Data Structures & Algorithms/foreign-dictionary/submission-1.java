class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character,Set<Character>> graph = new HashMap<>();
        Map<Character,Integer> indegree = new HashMap<>();

        Set<Character> allCharacters = new HashSet<>();

        for(int i=0;i<words.length-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];

            int length = Math.min(s1.length(),s2.length());

            for(int j=0;j<length;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    Set<Character> neighbours = graph.computeIfAbsent(s1.charAt(j),k -> new HashSet<>());
                    if (neighbours.add(s2.charAt(j))) {
                        indegree.put(s2.charAt(j),indegree.getOrDefault(s2.charAt(j), 0) + 1);
}
                    break;
                }
                if(j==length-1 && s1.length()>s2.length()){
                    return "";
                }
            }
        }

        for(String word : words){
            for(int i=0;i<word.length();i++){
                allCharacters.add(word.charAt(i));    
            }
        }

        Queue<Character> q = new ArrayDeque<>();

        StringBuilder result = new StringBuilder();
        Set<Character> visited = new HashSet<>();

        int count = 0;

        for(Character c : allCharacters){
            if(!indegree.containsKey(c)){
                q.offer(c);
                visited.add(c);
                count++;
            }
        }

        while(!q.isEmpty()){
            Character c = q.poll();
            result.append(c);

            for(Character neighbour : graph.getOrDefault(c, new HashSet<>())){
                indegree.put(neighbour,indegree.get(neighbour)-1);
                if(indegree.get(neighbour)==0){
                    q.offer(neighbour);
                    visited.add(neighbour);
                    count++;
                }
            }
        }

        return count==allCharacters.size()?result.toString():"";
    }
}
