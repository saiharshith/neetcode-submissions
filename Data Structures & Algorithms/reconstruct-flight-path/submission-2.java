class Solution {
    private void dfs(String src,Map<String,PriorityQueue<String>> adj, List<String> result){
        PriorityQueue<String> pq = adj.get(src);
        while(pq!=null && !pq.isEmpty()){
            dfs(pq.poll(),adj,result);    
        }
        result.add(src);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> adj = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(List<String> ticket : tickets){
            adj.computeIfAbsent(ticket.get(0),k->new PriorityQueue()).offer(ticket.get(1));
        }

        dfs("JFK",adj,result);
        Collections.reverse(result);

        return result;
    }
}
