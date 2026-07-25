class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int len = s.length();
        for(int i=0;i<=(len+1)/2-1;i++){
            if(s.charAt(i)!=s.charAt(len-1-i))
                return false;
        }

        return true;
    }
}
