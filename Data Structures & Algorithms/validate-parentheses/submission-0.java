class Solution {
    public boolean isValid(String s) {

        if(s.charAt(0)!='(' && s.charAt(0)!='{' && s.charAt(0)!='[')
            return false;

        Stack<Character> myStack = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')
                myStack.push(s.charAt(i));
            else if (s.charAt(i)==')'){
                if(myStack.isEmpty() || myStack.peek()!='(')
                    return false;
                else
                    myStack.pop();
            }else if (s.charAt(i)=='}'){
                if(myStack.isEmpty() || myStack.peek()!='{')
                    return false;
                else
                    myStack.pop();
            }else{
                if(myStack.isEmpty() || myStack.peek()!='[')
                    return false;
                else
                    myStack.pop();
            }          
        }

        return myStack.isEmpty();
        
    }
}
