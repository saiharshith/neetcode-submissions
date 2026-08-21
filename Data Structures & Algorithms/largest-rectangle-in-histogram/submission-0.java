class Solution {
    public int largestRectangleArea(int[] heights) {
        int max=0;
        Stack<Integer> myStack = new Stack<>();

        myStack.push(0);

        for(int i=1;i<heights.length;i++){
            while(!myStack.empty() && heights[myStack.peek()]>heights[i]){
                int current = myStack.pop();
                int left = myStack.empty()?-1:myStack.peek();
                int right = i;

                int area = (right-left-1)*heights[current];
                if(area>max)
                    max=area;
            }
            myStack.push(i);            
        }

        while(!myStack.empty()){
            int current = myStack.pop();
            int left = myStack.empty()?-1:myStack.peek();
            int right = heights.length;

            int area = (right-left-1)*heights[current];
            if(area>max)
                    max=area;
        }

        return max;

    }
}
