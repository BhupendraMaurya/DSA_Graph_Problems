class Solution {
    public int leastInterval(char[] tasks, int n) {
       int hash[] = new int[26];
       for(int i = 0; i < tasks.length; i++){
            hash[tasks[i] - 'A']++;
       } 

       int time = 0;
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       for(int val : hash){
            if(val > 0){
                pq.add(val);
            }
       }

       while(!pq.isEmpty()){

            List<Integer> temp = new ArrayList<>();
            int executed = 0;
            for(int i = 1; i <= n+1; i++){
                if(!pq.isEmpty()){
                    int freq = pq.poll();
                    freq--;
                    executed++;
                    if(freq > 0){
                        temp.add(freq);
                    }
                }
            }

            for(int val : temp){
                if(val > 0){
                    pq.add(val);
                }
            }

            if(pq.isEmpty()){
                time += executed;
            }
            else{
                time += n+1;
            }

       }
       
       return time;                                                                                                                                                                                                                                                                                                                                                                                                                                                  
    }
}