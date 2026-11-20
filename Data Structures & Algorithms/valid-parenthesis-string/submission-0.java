class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left.push(i);
            }else if(s.charAt(i)=='*'){
                star.push(i);
            }else{
                if(!left.empty()){
                    left.pop();
                }else if(!star.empty()){
                    star.pop();
                }else{
                    return false;
                }
            }
        }

        if(left.size()>star.size()){
            return false;
        }

        while(!left.empty()){    
            if(left.pop()>star.pop()){
                return false;
            }
        }

        return true;    
    }
}
