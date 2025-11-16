class MyQueue {

    Stack<Integer> st;
    public MyQueue() {
        st = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!st.isEmpty()){
            list.add(st.peek());
            st.pop();
        }

        for(int i = 0;i < list.size(); i++){
            st.add(list.get(i));
        }

        int ans = st.pop();

        ArrayList<Integer> list2 = new ArrayList<>();
        
        while(!st.isEmpty()){
            list2.add(st.peek());
            st.pop();
        }

        for(int i = 0;i < list2.size(); i++){
            st.add(list2.get(i));
        }

        return ans;
    }
    
    public int peek() {
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!st.isEmpty()){
            list.add(st.peek());
            st.pop();
        }

        for(int i = 0;i < list.size(); i++){
            st.add(list.get(i));
        }

        int ans = st.peek();

        ArrayList<Integer> list2 = new ArrayList<>();
        
        while(!st.isEmpty()){
            list2.add(st.peek());
            st.pop();
        }

        for(int i = 0;i < list2.size(); i++){
            st.add(list2.get(i));
        }

        return ans;
    }
    
    public boolean empty() {
        return st.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */