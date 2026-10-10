class Solution {
    List<List<String>> answer;
    private boolean isPalindrome(String s){
        int length = s.length();
        for(int i=0;i<length/2;i++){
            if(s.charAt(i)!=s.charAt(length-1-i)){
                return false;
            }
        }
        return true;
    }

    private void helper(String s, int index, List<String> curr){
        if(index == s.length()){
            answer.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index+1;i<=s.length();i++){
            if(isPalindrome(s.substring(index,i))){
                curr.add(s.substring(index,i));
                helper(s,i,curr);
                curr.remove(curr.size()-1);
            }    
        }
    }
    public List<List<String>> partition(String s) {
        answer = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        helper(s,0,curr);

        return answer; 
    }
}
