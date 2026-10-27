class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n==1){
            return nums[0];
        }else if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        
        int prev1,prev2,temp;
        prev2 = nums[0];
        prev1 = Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            temp=prev1;
            prev1= Math.max(prev2+nums[i],prev1);   
            prev2=temp; 
        }

        return prev1;

    }
}
