class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] finalTriplet = new int[3]; 

        for(int[] triplet: triplets){
            if(triplet[0]<=target[0] && triplet[1]<=target[1] && triplet[2]<=target[2]){
                finalTriplet[0]=Math.max(finalTriplet[0],triplet[0]);
                finalTriplet[1]=Math.max(finalTriplet[1],triplet[1]);
                finalTriplet[2]=Math.max(finalTriplet[2],triplet[2]);
            }            
        }

        return Arrays.equals(finalTriplet,target);    
    }
}
