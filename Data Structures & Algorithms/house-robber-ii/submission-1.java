class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1){
            return nums[0];
        }else if(n==2){
            return Math.max(nums[0],nums[1]);
        }

        int[] dp = new int[n];
        int[] dp1 = new int[n];

        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        dp[2]=Math.max(dp[0]+nums[2],dp[1]);

        dp1[1]=nums[1];
        dp1[2]=Math.max(nums[1],nums[2]);

        for(int i=3;i<n;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
            dp1[i]=Math.max(dp1[i-2]+nums[i],dp1[i-1]);
        }

        return Math.max(dp1[n-1],dp[n-2]);
    }
}
