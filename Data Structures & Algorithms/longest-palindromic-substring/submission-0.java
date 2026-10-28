class Solution {
    private boolean isPalindrome(String s, int start, int end){
        int mid = start+(end-start+1)/2;

        for(int i=0;start+i<mid;i++){
            if(s.charAt(start+i)!=s.charAt(end-i)){
                return false;
            }
        }

        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();

        String curr = s.substring(0,1),next = "";

        for(int i=1;i<n;i++){
            boolean flag = false;
            for(int start=0;start<=i;start++){
                if(isPalindrome(s,start,i)){
                    flag=true;
                    next=s.substring(start,i+1);
                    break;
                }    
            }
            if(next.length()>curr.length()){
                curr=next;
            }
        }

        return curr;    
    }
}
