class Solution {

    List<String> answer;
    int total; 
    private void helper(int open, int close, StringBuilder sb){
        if(open==total && close==total){
            answer.add(sb.toString());
            return;    
        }
        if(open>total || close>total){
            return;
        }
        if(close>open){
            return;
        }else if(open>close){
            sb.append("(");
            helper(open+1,close,sb);
            sb.deleteCharAt(sb.length()-1);

            sb.append(")");
            helper(open,close+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }else{
            sb.append("(");
            helper(open+1,close,sb);
            sb.deleteCharAt(sb.length()-1);            
        }

        return;

    }
    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        total = n;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        helper(1,0,sb);
        return answer;    
    }
}
