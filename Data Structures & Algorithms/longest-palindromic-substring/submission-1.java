class Solution {
    private String answer;
    private void getLongestPalindromeEven(String s,int cent){
        int i=cent,j=cent+1;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;    
        }

        String temp = s.substring(i+1,j);
        if(temp.length()>answer.length()){
            answer=temp;
        }    
    }
    private void getLongestPalindromeOdd(String s, int cent){
        int i=cent-1,j=cent+1;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;    
        }

        String temp = s.substring(i+1,j);
        if(temp.length()>answer.length()){
            answer=temp;
        }     
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n==1){
            return s;
        }
        answer="";
        for(int i=0;i<n-1;i++){
            getLongestPalindromeEven(s,i);
            getLongestPalindromeOdd(s,i);      
        }

        return answer;    
    }
}
