class Solution {
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    private void dfs(char[][] grid, int i,int j){
        if(i<0 || j<0 || i>= grid.length || j>=grid[0].length){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        for(int[] dir:directions){
            dfs(grid,i+dir[0],j+dir[1]);
        }
    }
    public int numIslands(char[][] grid) {
        int count=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }

        return count;    
    }
}
