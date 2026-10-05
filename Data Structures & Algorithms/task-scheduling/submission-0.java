class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for(char task:tasks){
            freq[task-'A']++;
            maxFreq = Math.max(maxFreq, freq[task-'A']); 
        }

        int numOfMaxFreq = 0;
        for(int i=0;i<26;i++){
            if(freq[i]==maxFreq)
                numOfMaxFreq++;    
        }

        int answer = (maxFreq-1)*(n+1)+numOfMaxFreq;

        return Math.max(answer, tasks.length);

    }
}
