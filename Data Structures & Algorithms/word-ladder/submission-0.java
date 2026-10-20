class Solution {
    private boolean close(String s1, String s2){
        int count=0;

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
                if(count>1)
                    return false;
            }
        }

        return true;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int count=0;

        while(!q.isEmpty()){
            int size = q.size();
            count++;
            for(int i=0;i<size;i++){
                String curr = q.poll();
                for(String word : wordList){
                    if(close(curr,word) && !visited.contains(word)){
                        if(word.equals(endWord)){
                            return count+1;
                        }
                        q.offer(word);
                        visited.add(word);
                    }
                }
            }
        }

        return 0;
    }
}
