class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        Queue<Integer>  q = new ArrayDeque();
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                visited[i]=true;
                q.offer(i);

                while(!q.isEmpty()){
                    int temp = q.poll();

                    for(int neighbour: graph.get(temp)){
                        if(!visited[neighbour]){
                            visited[neighbour]=true;
                            q.offer(neighbour);   
                        }      
                    }
                }
            }    
        }

        return count;
    }
}
