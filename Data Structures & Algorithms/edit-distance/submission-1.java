class Solution {
    private int helper(String word1, String word2, int c1, int c2, int[][] dp){
        if(c2==word2.length()){
            return word1.length()-c1;
        }
        if(c1==word1.length()){
            return word2.length()-c2;
        }

        if(dp[c1][c2]!=-1){
            return dp[c1][c2];
        }

        if(word1.charAt(c1)==word2.charAt(c2)){
            return dp[c1][c2]=helper(word1,word2,c1+1,c2+1,dp);
        }

        int ans1 = 1+helper(word1,word2,c1,c2+1,dp);
        int ans2 = 1+helper(word1,word2,c1+1,c2,dp);
        int ans3 = 1+helper(word1,word2,c1+1,c2+1,dp);

        return dp[c1][c2] = Math.min(Math.min(ans1,ans2),ans3);    
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(word1,word2,0,0,dp);    
    }
}
