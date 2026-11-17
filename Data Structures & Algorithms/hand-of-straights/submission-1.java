class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }

        int[] count = new int[1001];

        for(int card:hand){
            count[card]++;    
        }

        for(int i=0;i<1001;i++){
            int next=-1,j=0;
            if(count[i]!=0){
                int reference=count[i];
                next=-1;
                if(i+groupSize>1001){
                    return false;
                }
                for(j=i+1;j<i+groupSize;j++){
                    if(count[j]<reference){
                        return false;
                    }else{
                        count[j]-=reference;
                        if(next==-1 && count[j]>0){
                            next=j;
                        }
                    }    
                }
                if(next==-1){
                    i=j-1;
                }else{
                    i=next-1;
                }
            }
        }

        return true;


    }
}