class Solution {
    private boolean helper(String s,String p,int sPtr,int pPtr,int[][] dp){
        if(pPtr==p.length()){
            return sPtr==s.length();
        }
        if(sPtr==s.length()){
            if(pPtr+1==p.length()-1 && p.charAt(pPtr+1)=='*'){
                return true;
            }
            return false;
        }

        if(dp[sPtr][pPtr]!=-1){
            return dp[sPtr][pPtr]==1?true:false;
        }

        if(pPtr<p.length()-1 && p.charAt(pPtr+1)=='*'){
            if(helper(s,p,sPtr,pPtr+2,dp)){
                dp[sPtr][pPtr]=1;
                return true;
            }
            for(int i=sPtr;i<s.length();i++){
                if(s.charAt(i)==p.charAt(pPtr) || p.charAt(pPtr)=='.'){
                    boolean result = helper(s,p,i+1,pPtr+2,dp);
                    if(result){
                        dp[sPtr][pPtr]=1;
                        return true;
                    }
                }else{
                    break;
                }
            }
        }else if(p.charAt(pPtr)=='.' || p.charAt(pPtr)==s.charAt(sPtr)){
            boolean result = helper(s,p,sPtr+1,pPtr+1,dp);
            dp[sPtr][pPtr]=result?1:0;
            return result;
        }else{
            dp[sPtr][pPtr]=0;
            return false;
        }

        dp[sPtr][pPtr]=0;
        return false;
    }
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(s,p,0,0,dp); 
    }
}
