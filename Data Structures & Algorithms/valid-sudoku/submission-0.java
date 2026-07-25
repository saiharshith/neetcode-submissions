class Solution {
    private int getBox(int i,int j){
        if(i<3){
            if(j<3){
                return 0;
            }else if(j<6){
                return 1;
            }else{
                return 2;
            }
        }else if(i<6){
            if(j<3){
                return 3;
            }else if(j<6){
                return 4;
            }else{
                return 5;
            }
        }else{
            if(j<3){
                return 6;
            }else if(j<6){
                return 7;
            }else{
                return 8;
            }
        }
    }
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowHash = new HashSet[9];
        HashSet<Character>[] colHash = new HashSet[9];
        HashSet<Character>[] boxHash = new HashSet[9];

        for(int i=0;i<9;i++){
            rowHash[i]= new HashSet<>();
            colHash[i]= new HashSet<>();
            boxHash[i]= new HashSet<>();
        }

        int len = board.length;

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                char c = board[i][j];

                if(rowHash[i].contains(c))
                    return false;
                if(colHash[j].contains(c))
                    return false;

                int box = getBox(i,j);    
                if(boxHash[box].contains(c))
                    return false;

                if(c!='.'){
                    rowHash[i].add(c);
                    colHash[j].add(c);
                    boxHash[box].add(c);
                }
     
            }
        }

        return true;
    }
}
