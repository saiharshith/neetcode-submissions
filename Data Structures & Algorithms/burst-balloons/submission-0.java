class Solution {

    private int helper(int[] nums, int l, int r,int[][] dp){

        if(l==r){
            return dp[l][r]=nums[l-1]*nums[l]*nums[l+1];
        }

        if(dp[l][r]!=-1){
            return dp[l][r];    
        }

        int max=0,val;

        for(int i=l;i<=r;i++){
            val = helper(nums,l,i-1,dp)+helper(nums,i+1,r,dp)+nums[i]*nums[l-1]*nums[r+1];
            max=Math.max(val,max);       
        }

        return dp[l][r]=max;

    }

    public int maxCoins(int[] nums) {
        int[] nums1 = new int[nums.length+2];

        nums1[0]=1;
        nums1[nums.length+1]=1;

        for(int i=1;i<=nums.length;i++){
            nums1[i]=nums[i-1];
        }

        int n = nums.length+2;

        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(nums1,1,nums.length,dp);
    }
}
