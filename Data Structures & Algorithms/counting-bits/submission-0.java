class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0]=0;
        if(n==0){
            return ans;
        }
        ans[1]=1;
        if(n==1){
            return ans;
        }
        int next=2;

        while(next<=n){
            for(int i=0;i<next && next+i<=n;i++){
                ans[next+i]=ans[i]+1;
            }

            next*=2;
        }

        return ans;
    }
}
