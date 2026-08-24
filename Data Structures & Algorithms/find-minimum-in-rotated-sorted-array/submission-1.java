class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        if(nums[0]<nums[n-1]){
            return nums[0];
        }

        int left=0, right=n-1, mid;

        while(left<right){
            if(nums[left]<nums[right])
                return nums[left];
                
            mid = (left+right)/2;
            if(left==mid){
                if(nums[left]<=nums[right])
                    return nums[left];
                else
                    return nums[right];
            }
            if(nums[mid]>nums[left]){
                left=mid+1;
            }else {
                right=mid;
            }
        }

        return nums[left];
        
    }
}
