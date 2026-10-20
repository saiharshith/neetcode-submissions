class Solution {
    private int find(int u, int[] parent){
        if(parent[u]!=u){
            parent[u] = find(parent[u],parent);
        }

        return parent[u];
    }

    private void union(int u, int v,int[] parent, int[] rank){
        int rootU = find(u, parent);
        int rootV = find(v,parent);

        if(rootU==rootV){
            return;
        }

        if(rank[rootU]>rank[rootV]){
            parent[rootV]=rootU;
        }else if(rank[rootU]<rank[rootV]){
            parent[rootU]=rootV;
        }else{
            parent[rootV]=rootU;
            rank[rootU]++;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] answer = new int[2];
        int n = edges.length;

        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i]=i;
            rank[i]=1;
        }

        for(int[] edge : edges){
            if(find(edge[0],parent)==find(edge[1],parent)){
                return edge;
            }else{
                union(edge[0],edge[1],parent,rank);
            }
        }

        return answer;
    }
}
