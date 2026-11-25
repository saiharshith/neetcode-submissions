class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] answers = new int[queries.length];
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        int[][] sortedQueries = new int[queries.length][2];

        for(int i=0;i<queries.length;i++){
            sortedQueries[i][0]=queries[i];
            sortedQueries[i][1]=i;
        }

        Arrays.sort(sortedQueries,(a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1]-a[0],b[1]-b[0]));
        int j=0;

        for(int i=0;i<sortedQueries.length;i++){
            while(j<intervals.length && intervals[j][0]<=sortedQueries[i][0]){
                pq.offer(intervals[j]);
                j++;    
            }

            while(!pq.isEmpty() && pq.peek()[1]<sortedQueries[i][0]){
                pq.poll();
            }

            int result = -1;
            if(!pq.isEmpty()){
                int[] temp = pq.peek();
                result = temp[1]-temp[0]+1;
            }

            answers[sortedQueries[i][1]]=result;
           
        }

        return answers;
    }
}
