class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] prereq : prerequisites){
            graph.get(prereq[1]).add(prereq[0]);
            indegree[prereq[0]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        int count=0;

        while(!q.isEmpty()){
            int course = q.poll();
            count++;

            for(int neighbour : graph.get(course)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.offer(neighbour);
                }
            }
        }

        return count==numCourses;
    }
}
