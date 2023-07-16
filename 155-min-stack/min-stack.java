class MinStack {
     HashMap<Integer, Integer> minVal = new HashMap<>() ;
     Stack<Integer> stack = new Stack<>();
    public MinStack() {
        
         
    }
    
    public void push(int val) {
        //  Stack<Integer> stack = new Stack<>();
         minVal.put(val, minVal.getOrDefault(val,0)+1);
         stack.push(val);
    }
    
    public void pop() {
        //  Stack<Integer> stack = new Stack<>();
        if(!stack.isEmpty()){
        int p = stack.pop();
        minVal.put(p, minVal.getOrDefault(p,0)-1);
        if(minVal.get(p)<=0)
        minVal.remove(p);
        }
        // if(!stack.isEmpty()){
        // minVal = Math.min(minVal, stack.peek());
        // }
    }
    
    public int top() {
    //   Stack<Integer> stack = new Stack<>();
     int p = 0;
      if(!stack.isEmpty()) {
           p = stack.peek();
          }
     return p;
    }

    
    public int getMin() {
        return Collections.min(minVal.keySet());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */