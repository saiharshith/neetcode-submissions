class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int top=0, bottom=matrix.length-1;
        int row = -1;
        while(top<=bottom){
            int midRow = (top+bottom)/2;
            if(target<matrix[midRow][0]){
                bottom=midRow-1;
            }else if(target>matrix[midRow][matrix[0].length-1]){
                top = midRow+1;
            }else{
                row = midRow;
                break;
            }
        }

        if(row==-1)
            return false;

        int left=0, right = matrix[0].length-1;
        int col = -1;

        while(left<=right){
            int mid = (left+right)/2;

            if(target==matrix[row][mid]){
                return true;
            }else if(target<matrix[row][mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        return false;   
        
    }
}
