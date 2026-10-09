class Solution {
    private boolean helper(char[][] board,int i,int j,String word,int index, boolean[][] visited){
        if(index == word.length()){
            return true;
        }
        if(i<0 || j<0 || i==board.length || j==board[0].length){
            return false;
        }
        if(visited[i][j]){
            return false;
        }
        visited[i][j]=true;
        boolean temp;
        if(board[i][j]==word.charAt(index)){
            temp = helper(board,i-1,j,word,index+1,visited);
            if(temp){
                return true;
            }
            temp = helper(board,i+1,j,word,index+1,visited);
            if(temp){
                return true;
            }
            temp = helper(board,i,j-1,word,index+1,visited);
            if(temp){
                return true;
            }
            temp = helper(board,i,j+1,word,index+1,visited);
            visited[i][j]=false;
            return temp;
        }else{
            visited[i][j]=false;
            return false;
        }
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean temp = helper(board,i,j,word,0,visited);
                    if(temp){
                        return true;
                    }
                }
            }
        }

        return false;    
    }
}
