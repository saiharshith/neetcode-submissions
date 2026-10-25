class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }  

        for(int[] flight : flights){
            graph.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }

        int[][] dist = new int[n][k+2];

        for(int i=0;i<n;i++){
            for(int j=0;j<k+2;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));

        pq.offer(new int[]{src,0,0});
        dist[src][0]=0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[0]==dst){
                return curr[1];
            }
            if(dist[curr[0]][curr[2]]!=curr[1] || curr[2]>k){
                continue;
            }

            for(int[] neighbour : graph.get(curr[0])){
                if(curr[1]+neighbour[1]<dist[neighbour[0]][curr[2]+1]){
                    pq.offer(new int[]{neighbour[0],curr[1]+neighbour[1],curr[2]+1});
                    dist[neighbour[0]][curr[2]+1] = curr[1]+neighbour[1];    
                }    
            }
        }

        return -1;

    }
}
