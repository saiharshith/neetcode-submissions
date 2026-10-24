class Solution {
    class Edge{
        int u,v, weight;

        Edge(int u, int v, int weight){
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
    int[] parent, rank;

    int find(int u){
        if(parent[u]!=u){
            parent[u]=find(parent[u]);
        }

        return parent[u];
    }

    boolean union(int u, int v){
        int rootU = find(u);
        int rootV = find(v);

        if(rootU==rootV){
            return false;
        }

        if(rank[rootU]<rank[rootV]){
            parent[rootU]=rootV;    
        }else if(rank[rootV]<rank[rootU]){
            parent[rootV]=rootU;
        }else{
            parent[rootV]=rootU;
            rank[rootU]++;
        }

        return true;
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        parent = new int[n+1];
        rank = new int[n+1];

        for(int i=1;i<n+1;i++){
            parent[i]=i;
        }
        
        List<Edge> edges = new ArrayList<>();

        for(int i=0;i<points.length-1;i++){
            for(int j=i+1;j<points.length;j++){
                edges.add(new Edge(i,j,Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])));
            }
        }

        edges.sort((a,b)->Integer.compare(a.weight,b.weight));

        int totalWeight = 0;
        int edgeCount = 0;
        for(Edge edge : edges){
            if(union(edge.u,edge.v)){
                edgeCount++;
                totalWeight+= edge.weight;    
            }

            if(edgeCount==n-1){
                break;
            }
        }

        return totalWeight;
        
    }
}
