class Solution {
    class Node{
        int i,j;

        Node(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public void solve(char[][] board) {
        Queue<Node> q = new ArrayDeque<>();

        boolean[][] dontModify = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O'){
                q.offer(new Node(i,0));
                dontModify[i][0] = true;
            }
            if(board[i][board[0].length-1]=='O'){
                q.offer(new Node(i,board[0].length-1));
                dontModify[i][board[0].length-1] = true;
            }   
        }

        for(int i=1;i<board[0].length-1;i++){
            if(board[0][i]=='O'){
                q.offer(new Node(0,i));
                dontModify[0][i] = true;
            }
            if(board[board.length-1][i]=='O'){
                q.offer(new Node(board.length-1,i));
                dontModify[board.length-1][i] = true;
            }   
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){
            Node temp = q.poll();
            int x = temp.i, y = temp.j;

            for(int[] direction:directions){
                int newX = x+direction[0], newY = y+direction[1];

                if(newX>=0 && newX<board.length && newY>=0 && newY<board[0].length){
                    if(board[newX][newY]=='O' && dontModify[newX][newY]==false){
                        q.offer(new Node(newX,newY));
                        dontModify[newX][newY]=true;
                    }
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O' && dontModify[i][j]==false){
                    board[i][j]='X';
                }
            }
        }    
    }
}
