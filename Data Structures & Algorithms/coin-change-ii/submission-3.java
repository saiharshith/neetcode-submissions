class Solution {
    public int change(int amount, int[] coins) {
        if(amount==0){
            return 1;
        }

        int n = coins.length;
        int[][] dp = new int[n][amount+1];


        int x=0;
        while(x*coins[0]<=amount){
            dp[0][x*coins[0]]=1;
            x++;
        }

        for(int i=1;i<n;i++){
            dp[i][0]=1;
            for(int j=1;j<=amount;j++){
                int coin = coins[i];
                
                int k=0;
                while(k*coins[i]<=j){
                    dp[i][j]+=dp[i-1][j-k*coins[i]];
                    k++;
                }
            }    
        }

        return dp[n-1][amount];
    }
}
