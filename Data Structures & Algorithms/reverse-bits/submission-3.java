class Solution {
    public int reverseBits(int n) {
        int ans=0;
        int shift=31;
        while(n!=0){
            ans|=(n&1)<<shift;
            shift--;
            n>>>=1;            
        }

        return ans;
    }
}
