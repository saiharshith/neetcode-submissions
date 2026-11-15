class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp,Integer.MAX_VALUE); //initializing with max+1 from constraint

        int maxIndex=0,steps=0;
        dp[0]=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<=i+nums[i] && j<nums.length;j++){
                dp[j]=Math.min(dp[j],dp[i]+1);    
            }
        }

        return dp[nums.length-1];                    
    }
}
