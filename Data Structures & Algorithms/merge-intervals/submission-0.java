class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[] prev = intervals[0];

        List<int[]> ans = new ArrayList<>();

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>prev[1]){
                ans.add(prev);
                prev=intervals[i];
            }else{
                prev[1]=Math.max(prev[1],intervals[i][1]);
            }    
        }

        ans.add(prev);

        return ans.toArray(new int[ans.size()][]);
    }
}
