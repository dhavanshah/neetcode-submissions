class MinStack {

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {

        mainStack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(mainStack.isEmpty()) {
            return;
        }
        //classic Java gotcha, -128 to 127 is the range of Integers for which Java reuses
        //references outside that each value is a distinct object so == will not work
        //we need to use equals instead
        if(mainStack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
