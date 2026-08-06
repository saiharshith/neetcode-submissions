class Solution {
    public int trap(int[] height) {
        if(height.length<3)
            return 0;
        int left=1,right=height.length-2;
        int leftMax=height[0],rightMax=height[height.length-1];
        int sum=0;
        while(left<=right){
            if(leftMax<=rightMax){
                if(height[left]<=leftMax)
                    sum+=leftMax-height[left];
                else
                    leftMax=height[left];
                left++;    
            }else{
                if(height[right]<=rightMax)
                    sum+=rightMax-height[right];
                else
                    rightMax=height[right];
                right--;
            }    
        }

        return sum;
        
    }
}
