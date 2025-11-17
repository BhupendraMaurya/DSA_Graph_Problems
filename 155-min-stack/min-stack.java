class Pair{
    int val;
    int mini;

    Pair(int val, int mini){
        this.val = val;
        this.mini = mini;
    }
}
class MinStack {
    Stack<Pair> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val, val));
        }
        else{
            int minV = Math.min(val, st.peek().mini);
            st.push(new Pair(val,  minV));
        }
    }
    
    public void pop() {
        Pair curr = st.pop();
    }
    
    public int top() {
        
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().mini;

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