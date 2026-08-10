class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        Arrays.sort(str1);

        s1= new String(str1);
        int length=s1.length();

        for(int i=0;i+length<=s2.length();i++){
            char[] str2 = s2.substring(i,i+length).toCharArray();
            Arrays.sort(str2);

            String temp = new String(str2);
            if(temp.equals(s1))
                return true;   
        }

        return false;
    }
}
