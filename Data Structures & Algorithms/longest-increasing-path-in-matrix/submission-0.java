class Solution {
    private int helper(int[][] matrix,int i,int j,int[][] dp){
        if(i<0 || i==matrix.length || j<0 || j==matrix[0].length){
            return 0;    
        }

        if(dp[i][j]!=0){
            return dp[i][j];
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int max = 0;
        for(int[] direction:directions){
            int newI = i+direction[0];
            int newJ = j+direction[1];

            if(newI>=0 && newI<matrix.length && newJ>=0 && newJ<matrix[0].length && matrix[newI][newJ]>matrix[i][j]){
                int result = helper(matrix,newI,newJ,dp);
                max = Math.max(max,result);    
            }
        }

        return dp[i][j]=max+1;    
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int result = helper(matrix,i,j,dp);
                max = Math.max(result,max);    
            }
        }

        return max;               
    }
}
