class Solution {
    List<List<String>> answer;
    boolean[] rowFlag, colFlag, leftDiagonal, rightDiagonal;

    private void helper(int row,int n,int[] curr){
        if(n==0){
            List<String> myList = new ArrayList<>();
            StringBuilder temp;
            for(int i=0;i<curr.length;i++){
                temp = new StringBuilder();
                for(int j=0;j<curr.length;j++){
                    if(j==curr[i]){
                        temp.append('Q'); 
                    }else{
                        temp.append(".");
                    }    
                }
                myList.add(temp.toString());
            }

            answer.add(myList);
            return;
        }
        int ldIndex;
        int rdIndex;
        for(int i=0;i<curr.length;i++){
            ldIndex = row-i+(curr.length-1);
            rdIndex = row+i;
            if(!rowFlag[row] && !colFlag[i] && !leftDiagonal[ldIndex] && !rightDiagonal[rdIndex]){
                rowFlag[row]=true;
                colFlag[i]=true;
                leftDiagonal[ldIndex]=true;
                rightDiagonal[rdIndex]=true;
                curr[row]=i;
                helper(row+1,n-1,curr);
                rowFlag[row]=false;
                colFlag[i]=false;
                leftDiagonal[ldIndex]=false;
                rightDiagonal[rdIndex]=false;
                curr[row]=-1;
            }

        }

    }
    public List<List<String>> solveNQueens(int n) {
        answer = new ArrayList<>();

        rowFlag = new boolean[n];
        colFlag = new boolean[n];

        leftDiagonal = new boolean[2*n-1];
        rightDiagonal = new boolean[2*n-1];

        int[] curr = new int[n];
        for(int i=0;i<n;i++){
            curr[i]=-1;
        }

        helper(0,n,curr);
        return answer;            
    }
}
