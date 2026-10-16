class Solution {
    class Node{
        int x,y;

        Node(int x,int y){
            this.x=x;
            this.y=y;    
        }    
    }
    public int orangesRotting(int[][] grid) {
        Queue<Node> q = new ArrayDeque<>();

        int ones=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new Node(i,j));
                }else if (grid[i][j]==1){
                    ones++;
                }
            }
        }

        if(ones==0){
            return 0;
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        int count=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node temp = q.poll();

                int x=temp.x,y=temp.y;

                for(int[] direction : directions){
                    int newX = x+direction[0],newY = y+direction[1];

                    if(newX>=0 && newX<grid.length && newY>=0 && newY<grid[0].length){
                        if(grid[newX][newY]==1){
                            grid[newX][newY] = 2;
                            q.offer(new Node(newX,newY));
                            ones--;   
                        }
                    }
                }            
            }
            count++;       
        }

        
        return ones>0?-1:count-1;    
    }
}
