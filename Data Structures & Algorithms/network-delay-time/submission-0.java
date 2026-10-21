class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int t = time[2];

            graph.get(u).add(new int[]{v,t});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        
        dist[k]=0;
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            int node = curr[0];
            int edge = curr[1];

            //skip outdated entries
            if(dist[node]!=edge){
                continue;
            }

            for(int[] neighbour : graph.get(node)){
                int newEdge = edge+neighbour[1];
                if(newEdge<dist[neighbour[0]]){
                    dist[neighbour[0]]=newEdge;
                    pq.offer(new int[]{neighbour[0],newEdge});
                }
            }
        }

        int max=0;

        for(int i=1;i<n+1;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max,dist[i]);
        }

        return max;
        
    }
}
