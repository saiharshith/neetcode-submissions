class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> indexStack = new Stack<>();

        indexStack.push(0);

        for(int i=1;i<temperatures.length;i++){
            while(!indexStack.empty() && temperatures[i]>temperatures[indexStack.peek()]){
                result[indexStack.peek()]=i-indexStack.peek();
                indexStack.pop();
            }
            
            indexStack.push(i);
        }

    return result;

    }
}
