class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];

        if(n==1){
            return 1;
        }

        dp[0] = 1;
        
        if(n==2){
            if(Integer.parseInt(s)>26){
                return s.charAt(1)=='0'?0:1;    
            }else{
                return s.charAt(1)=='0'?1:2;
            }    
        }

        if(Integer.parseInt(s.substring(0,2))>26){
            dp[1] = s.charAt(1)=='0'?0:1;    
        }else{
            dp[1] = s.charAt(1)=='0'?1:2;
        }

        for(int i=2;i<n;i++){
            if(Integer.parseInt(s.substring(i-1,i+1))<=26 && Integer.parseInt(s.substring(i-1,i+1))>=10){
                dp[i]+=dp[i-2];    
            }

            if(s.charAt(i)!='0'){
                dp[i]+=dp[i-1];    
            }     
        }
        
        return dp[n-1];
    }
}
