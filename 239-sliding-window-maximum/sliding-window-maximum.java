class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        int n = nums.length; 

        ArrayList<Integer> list = new ArrayList<>();
        

        while(j < n){
            while(q.size() > 0 && q.peekLast() < nums[j]){
                q.pollLast();
            }

            q.offerLast(nums[j]);

            if(j-i+1 == k){
                list.add(q.peekFirst());

                if(q.peekFirst() == nums[i]){
                    q.pollFirst();
                }
                i++;
            }
            j++;
        }

        int ans[] = new int[list.size()];
        for(int m = 0; m < list.size(); m++){
            ans[m] = list.get(m);
        }

        return ans;
    }
}