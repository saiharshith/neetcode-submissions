class MinStack {

    Stack<Integer> mainStack, minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if(minStack.empty())
            minStack.push(val);
        else{
            if(minStack.peek()>=val)
                minStack.push(val);
        }
    }
    
    public void pop() {
        if(mainStack.peek().equals(minStack.peek()))
            minStack.pop();
        mainStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
