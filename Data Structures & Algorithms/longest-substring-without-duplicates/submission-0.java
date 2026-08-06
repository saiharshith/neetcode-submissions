class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int left=0,right=0,length;

        HashSet<Character> charSet = new HashSet<>();

        while(left<=right && right<s.length()){
            while(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            length=right-left+1;
            if(max<length)
                max=length;
            right++;    
        }

        return max;
        
    }
}
