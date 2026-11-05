class Solution {
    public int change(int amount, int[] coins) {
        if(amount==0){
            return 1;
        }

        int n = coins.length;
        int[] dp = new int[amount+1];


        int x=0;
        while(x*coins[0]<=amount){
            dp[x*coins[0]]=1;
            x++;
        }

        for(int i=1;i<n;i++){
            //dp[0]=1;
            for(int j=amount;j>=1;j--){
                int coin = coins[i];
                
                int k=1;
                while(k*coins[i]<=j){
                    dp[j]+=dp[j-k*coins[i]];
                    k++;
                }
            }    
        }

        return dp[amount];
    }
}
