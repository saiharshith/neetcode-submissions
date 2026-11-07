class Solution {
    private boolean helper(String s1, String s2, String s3, int i1, int i2,int[][] dp){
        if(i1==s1.length()){
            return s2.substring(i2).equals(s3.substring(i1+i2));
        }
        if(i2==s2.length()){
            return s1.substring(i1).equals(s3.substring(i1+i2));
        }

        if(dp[i1][i2]!=-1){
            return dp[i1][i2]==0?false:true;
        }

        char char1 = s1.charAt(i1);
        char char2 = s2.charAt(i2);
        char char3 = s3.charAt(i1+i2);

        boolean ans;

        if(char3==char1 && char3!=char2){
            ans=helper(s1,s2,s3,i1+1,i2,dp);
        }else if(char3==char2 && char3!=char1){
            ans=helper(s1,s2,s3,i1,i2+1,dp);
        }else if(char3!=char1 && char3!=char2){
            ans=false;
        }else{
            ans = (helper(s1,s2,s3,i1+1,i2,dp) || helper(s1,s2,s3,i1,i2+1,dp));
        }

        dp[i1][i2]=ans==true?1:0;
        return ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.equals("")){
            return s2.equals(s3);
        }
        if(s2.equals("")){
            return s1.equals(s3);
        }

        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        int m = s1.length();
        int n = s2.length();


        int[][] dp = new int[m][n];

        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        return helper(s1,s2,s3,0,0,dp);

    }
}
