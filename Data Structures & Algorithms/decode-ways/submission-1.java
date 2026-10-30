class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        int n = s.length();
        //int[] dp = new int[n];

        int curr=0, prev1, prev2;

        if(n==1){
            return 1;
        }

        prev2 = 1;
        
        if(n==2){
            if(Integer.parseInt(s)>26){
                return s.charAt(1)=='0'?0:1;    
            }else{
                return s.charAt(1)=='0'?1:2;
            }    
        }

        if(Integer.parseInt(s.substring(0,2))>26){
            prev1 = s.charAt(1)=='0'?0:1;    
        }else{
            prev1 = s.charAt(1)=='0'?1:2;
        }

        for(int i=2;i<n;i++){
            curr=0;
            if(Integer.parseInt(s.substring(i-1,i+1))<=26 && Integer.parseInt(s.substring(i-1,i+1))>=10){
                curr+=prev2;    
            }

            if(s.charAt(i)!='0'){
                curr+=prev1;    
            }

            prev2=prev1;
            prev1=curr;     
        }
        
        return curr;
    }
}
