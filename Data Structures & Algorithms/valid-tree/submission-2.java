class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];

        Arrays.fill(parent,-1);

        int count=0;
        q.offer(0);
        visited[0]=true;;
        count++;
        while(!q.isEmpty()){
            int temp = q.poll();

            for(int neighbour : graph.get(temp)){
                if(!visited[neighbour]){
                    q.offer(neighbour);
                    visited[neighbour]=true;
                    count++;
                    parent[neighbour]=temp;
                }else if(parent[temp]==neighbour){
                    continue;
                }else{
                    return false;
                }
            }
        }

        return count==n;

    }
}
