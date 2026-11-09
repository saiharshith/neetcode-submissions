class Solution {
    private int helper(String s, String t,int sPtr, int tPtr, int[][] dp){
        int ans=0;
        if(tPtr==t.length()){
            return 1;
        }
        if(sPtr==s.length()){
            return 0;
        }

        if(dp[sPtr][tPtr]!=-1){
            return dp[sPtr][tPtr];
        }
        if(s.charAt(sPtr)==t.charAt(tPtr)){
            ans=helper(s,t,sPtr+1,tPtr+1,dp)+helper(s,t,sPtr+1,tPtr,dp);
        }else{
            ans=helper(s,t,sPtr+1,tPtr,dp);
        }

        return dp[sPtr][tPtr]=ans;    
    }
    public int numDistinct(String s, String t) {
        if(s.length()<t.length()){
            return 0;
        }

        int[][] dp = new int[s.length()][t.length()];

        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(s,t,0,0,dp);
    }
}
