class Solution {
    int count;
    private int countWithCentre(String s, int i,int j){
        int temp=0;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            temp++;
            i--;
            j++;
        }

        return temp;    
    }
    public int countSubstrings(String s) {
        int n = s.length();
        count=0;
        
        for(int i=0;i<n-1;i++){
            count+=countWithCentre(s,i,i);
            count+=countWithCentre(s,i,i+1);        
        }

        count++;

        return count;
    }
}
