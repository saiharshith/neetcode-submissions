class Solution {
    private boolean canEatAllBananas(int[] piles, int h, int k){
        long hours = 0;

        for(int i=0;i<piles.length;i++){
            hours+= piles[i]/k;
            if(piles[i]%k!=0)
                hours++;
            if(hours>h)
                return false;    
        }

        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right = 1000000001;
        int mid;

        while(left<right){
            mid = left + (right-left)/2;
            boolean result = canEatAllBananas(piles,h,mid);

            if(result){
                right=mid;
            }else{
                left = mid+1;
            }

        }

        return left;
    }
}
