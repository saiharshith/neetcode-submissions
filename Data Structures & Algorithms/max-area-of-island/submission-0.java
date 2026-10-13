class Solution {
    int count,max=0;
    private void dfs(int[][]grid, int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return;
        }
        if(grid[i][j]==0){
            return;
        }
        count++;
        grid[i][j]=0;

        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);    
    }
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count=0;
                    dfs(grid,i,j);
                    max=Math.max(max,count);
                }
            }
        }

        return max;       
    }
}
