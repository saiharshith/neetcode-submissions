class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if(n==1){
            return 0;
        }else if(n==2){
            if(prices[0]>=prices[1]){
                return 0;
            }else{
                return prices[1]-prices[0];
            }
        }

        int[] dp = new int[n];

            
        dp[0] = 0;

        if(prices[0]>=prices[1]){
            dp[1] = 0;
        }else{
            dp[1] = prices[1] - prices[0];
        }
        
        for(int i=2;i<n;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(prices[j]>=prices[i]){
                    continue;
                }
                int profit = prices[i]-prices[j];

                if(j>=2){
                    profit+=dp[j-2];
                }

                max=Math.max(max,profit);
            }

            dp[i]= Math.max(max,dp[i-1]);
        }

        return dp[n-1];

    }
}
