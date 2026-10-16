class Solution {
    class Node{
        int i,j;

        Node(int i, int j){
            this.i=i;
            this.j=j;    
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        Queue<Node> q = new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.offer(new Node(i,j));    
                }
            }
        }
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()){
            Node temp = q.poll();
            int x = temp.i;
            int y = temp.j;

            for(int[] direction: directions){
                int newX = x+direction[0];
                int newY = y+direction[1];
                if(newX>=0 && newY>=0 && newX<grid.length && newY<grid[0].length){
                    if(grid[newX][newY]==Integer.MAX_VALUE){
                        grid[newX][newY]=grid[x][y]+1;
                        q.offer(new Node(newX,newY));
                    }       
                }
            }
        }
    }
}
