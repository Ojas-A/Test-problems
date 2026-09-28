class MinStack {

    Deque<Integer> stack;
    PriorityQueue<Integer> priority;

    public MinStack() {
        stack = new ArrayDeque<>();
        priority = new PriorityQueue<>();
    }
    
    public void push(int val) {
        stack.push(val);
        priority.offer(val);
    }
    
    public void pop() {
        priority.remove(stack.pop());
        //topIndex = i-1;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return priority.peek();
        //Priority Queue ? 
    }
}
