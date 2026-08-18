class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> myStack = new Stack<>();
        int operand1,operand2;

        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                operand2 = myStack.pop();
                operand1 = myStack.pop();
                myStack.push(operand1+operand2);
            }else if(tokens[i].equals("-")){
                operand2 = myStack.pop();
                operand1 = myStack.pop();
                myStack.push(operand1-operand2);
            }else if(tokens[i].equals("*")){
                operand2 = myStack.pop();
                operand1 = myStack.pop();
                myStack.push(operand1*operand2);
            }else if(tokens[i].equals("/")){
                operand2 = myStack.pop();
                operand1 = myStack.pop();
                myStack.push(operand1/operand2);
            }else{
                myStack.push(Integer.parseInt(tokens[i]));    
            }
        }

        return myStack.pop();
        
    }
}
