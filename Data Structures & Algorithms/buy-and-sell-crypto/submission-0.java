class Solution {
    public int maxProfit(int[] prices) {
    if(prices.length<2)
        return 0;
    int sell = prices[prices.length-1],profit,max=0;

    for(int i=prices.length-2;i>=0;i--){
        if(prices[i]<sell){
            profit=sell-prices[i];
            if(profit>max)
                max=profit;
        }else{
            sell=prices[i];
        }
    }    
    
    return max;
}
}