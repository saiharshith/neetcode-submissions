class Solution {
    class Node{
        int i,j;

        Node(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];

        Queue<Node> q = new ArrayDeque<>();

        for(int i=0;i<heights.length;i++){
            q.offer(new Node(i,0));
            pacific[i][0]=true;;
        }
        for(int j=1;j<heights[0].length;j++){
            q.offer(new Node(0,j));
            pacific[0][j]=true;
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){
            Node temp = q.poll();
            int x = temp.i, y = temp.j;

            for(int[] direction : directions){
                int newX = x+direction[0], newY = y+direction[1];

                if(newX>=0 && newX<heights.length && newY>=0 && newY<heights[0].length){
                    if(!pacific[newX][newY] && heights[newX][newY]>=heights[x][y]){
                        q.offer(new Node(newX,newY));
                        pacific[newX][newY]=true;
                    }
                }
            }
        }

        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        List<List<Integer>> answer = new ArrayList<>();

        for(int i=0;i<heights.length;i++){
            q.offer(new Node(i,heights[0].length-1));
            atlantic[i][heights[0].length-1]=true;
            if(pacific[i][heights[0].length-1]){
                answer.add(new ArrayList<>(Arrays.asList(i,heights[0].length-1)));
            }
        }
        for(int j=0;j<heights[0].length-1;j++){
            q.offer(new Node(heights.length-1,j));
            atlantic[heights.length-1][j]=true;
            if(pacific[heights.length-1][j]){
                answer.add(new ArrayList<>(Arrays.asList(heights.length-1,j)));
            }
        }

        while(!q.isEmpty()){
            Node temp = q.poll();
            int x = temp.i, y = temp.j;

            for(int[] direction : directions){
                int newX = x+direction[0], newY = y+direction[1];

                if(newX>=0 && newX<heights.length && newY>=0 && newY<heights[0].length){
                    if(!atlantic[newX][newY] && heights[newX][newY]>=heights[x][y]){
                        q.offer(new Node(newX,newY));
                        atlantic[newX][newY]=true;
                        if(pacific[newX][newY]){
                answer.add(new ArrayList<>(Arrays.asList(newX,newY)));
            }
                    }
                }
            }
        }

        return answer;

    }
}
