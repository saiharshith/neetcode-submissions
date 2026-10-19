class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();

        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer,Integer> parent = new HashMap<>();

        int count=0;
        q.offer(0);
        visited.add(0);
        count++;
        while(!q.isEmpty()){
            int temp = q.poll();

            for(int neighbour : graph.get(temp)){
                if(!visited.contains(neighbour)){
                    q.offer(neighbour);
                    visited.add(neighbour);
                    count++;
                    parent.put(neighbour,temp);
                }else if(parent.containsKey(temp) && parent.get(temp)==neighbour){
                    continue;
                }else{
                    return false;
                }
            }
        }

        return count==n;

    }
}
