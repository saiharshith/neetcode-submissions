class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sfreq = new int[26];
        int[] tfreq = new int[26];

        for(int i=0;i<s.length();i++){
            sfreq[(int)s.charAt(i)-(int)'a']++;
        }

        for(int i=0;i<t.length();i++){
            tfreq[(int)t.charAt(i)-(int)'a']++;
        }

        for(int i=0;i<26;i++){
            if(sfreq[i]!=tfreq[i])
                return false;
        }

        return true;
    }
}
