class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int prefix =1;
        ans[0]=1;
        for(int i=1;i<nums.length;i++){
            prefix = prefix*nums[i-1];
            ans[i]=prefix;    
        }
        int suffix=1;
        for(int i=nums.length-2;i>=0;i--){
            suffix = suffix*nums[i+1];
            ans[i]= ans[i]*suffix;
        }

        return ans;

    }
}  
