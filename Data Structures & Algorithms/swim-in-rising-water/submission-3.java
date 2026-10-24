class Solution {
    public int swimInWater(int[][] grid) {

        int n=grid.length;
        int[][] cost = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cost[i][j]=Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        pq.offer(new int[]{0,0,grid[0][0]});
        cost[0][0]=grid[0][0];

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            int weight = curr[2];

            //skip outdated entries
            if(weight!=cost[i][j]){
                continue;
            }

            for(int[] direction : directions){
                int newI = i+direction[0];
                int newJ = j+direction[1];

                if(newI>=0 && newI<grid.length && newJ>=0 && newJ<grid.length){
                    int currWeight = Math.max(weight,grid[newI][newJ]);
                    if(currWeight<cost[newI][newJ]){
                        cost[newI][newJ]=currWeight;
                        pq.offer(new int[]{newI,newJ,currWeight});
                    }
                }
            }
        }

        return cost[n-1][n-1];
    }
}
