class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int index=0;

        int totalSum=0,sum=0;

        for(int i=0;i<gas.length;i++){
            totalSum+=gas[i]-cost[i];
            sum+=gas[i]-cost[i];
            if(sum<0){
                sum=0;
                index=i+1;    
            }
        }

        if(totalSum<0){
            return -1;
        }

        return index; 
    }
}
