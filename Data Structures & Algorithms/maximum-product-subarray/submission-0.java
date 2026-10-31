class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int prefix=1, suffix=1;
        int ans = nums[0];

        for(int i=0;i<n;i++){
            prefix = nums[i]*(prefix==0?1:prefix);
            suffix = nums[n-1-i]*(suffix==0?1:suffix);

            ans = Math.max(ans,Math.max(prefix,suffix));
        }

        return ans;    
    }
}
