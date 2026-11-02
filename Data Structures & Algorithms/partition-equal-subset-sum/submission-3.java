class Solution {
    private boolean helper(int[] nums, int start,int target, int[][] dp){
        if(start==nums.length){
            return false;
        }

        if(target<0){
            return false;
        }

        if(dp[start][target]!=-1){
            return dp[start][target]==1?true:false;
        }

        if(nums[start]==target){
            dp[start][target]=1;
            return true;
        }

        boolean ans = helper(nums,start+1,target,dp) || helper(nums,start+1,target-nums[start],dp);

        if(ans){
            dp[start][target]=1;
        }else{
            dp[start][target]=0;
        }

        return ans;    
    }
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

        int[][] dp = new int[nums.length][target+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(nums,0,target, dp);   
    }
}
