class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length+nums2.length;
        int targetLeft = (total+1)/2;

        if(nums2.length<nums1.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        //partition will be the start of right half

        int left=0, right = nums1.length; //all num1 elements could also be in left.
        
        
         while(left<=right){
            int mid1 = left+(right-left)/2;
            int mid2 = targetLeft-mid1;

            //handling boundaries is key
            int Aleft = mid1>0?nums1[mid1-1]:Integer.MIN_VALUE;
            int Aright = mid1<nums1.length?nums1[mid1]:Integer.MAX_VALUE;
            
            int Bleft = mid2>0?nums2[mid2-1]:Integer.MIN_VALUE;
            int Bright = mid2<nums2.length?nums2[mid2]:Integer.MAX_VALUE;

           if(Aleft<=Bright && Bleft<=Aright){
            if(total%2==0){ 
                return (Math.max(Aleft,Bleft)+Math.min(Aright,Bright))/2.0;
            }else{
                return Math.max(Aleft,Bleft);
            }   
           }else if(Aleft>Bright){
                right=mid1-1; 
           }else{
                left=mid1+1;
           }
         }

         return -1;           
    }
}
