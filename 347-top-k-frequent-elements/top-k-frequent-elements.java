class Solution {
    static class Pair {
        int num;
        int freq;

        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        // Making a PQ(max heap) to store the numbers with its frequency 
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> b.freq - a.freq);

        for(Map.Entry<Integer, Integer> it : map.entrySet()){
            pq.add(new Pair(it.getKey(), it.getValue()));
        }

        int ans[] = new int[k];
        int i = 0;

        while(k-- > 0 && pq.size() > 0){
            ans[i++] = pq.poll().num;
        }

        return ans;
    }
}