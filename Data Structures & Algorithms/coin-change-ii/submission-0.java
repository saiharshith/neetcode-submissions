class Solution {
    private int helper(int amount,int[] coins,int x, int[][] dp){
        if(amount==0){
            return 1;
        }
        if(x==-1){
            return 0;
        }

        if(dp[x][amount]!=-1){
            return dp[x][amount];
        }

        int ans = 0;

        int coin = coins[x];

        int i=0;

        while(coin*i<=amount){
            ans+=helper(amount-coin*i,coins,x-1,dp);
            i++;
        }

        dp[x][amount]=ans;
        return ans;    
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }

        return helper(amount,coins,n-1,dp);
            
    }
}
