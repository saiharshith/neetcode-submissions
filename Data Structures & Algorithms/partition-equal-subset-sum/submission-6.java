class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int count=0;

        for(int num:nums){
            count+=num;
        }

        if(count%2!=0){
            return false;
        }
        int target = count/2;
        boolean[][] dp = new boolean[n][target+1];

        dp[n-1][0]=true;
        if(target>=nums[n-1])
            dp[n-1][nums[n-1]]=true;

        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<nums[i];j++){
                dp[i][j]=dp[i+1][j];
            }
            for(int j=nums[i];j<=target;j++){
                dp[i][j]=dp[i+1][j-nums[i]]||dp[i+1][j];
            }
        }



        return dp[0][target];
    }
}
