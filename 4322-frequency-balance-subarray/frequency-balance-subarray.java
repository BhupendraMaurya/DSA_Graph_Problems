class Solution {
    public int getLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        if(map.size() == 1){
            return nums.length;
        }
        else if(map.size() == nums.length){
            return 1;
        }
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            HashMap<Integer, Integer> freqMap = new HashMap<>();
            TreeMap<Integer, Integer> freqCount = new TreeMap<>();

            for (int j = i; j < n; j++) {

                int num = nums[j];

                int oldFreq = freqMap.getOrDefault(num, 0);
                int newFreq = oldFreq + 1;

                freqMap.put(num, newFreq);

                // Remove old frequency count
                if (oldFreq > 0) {
                    freqCount.put(oldFreq, freqCount.get(oldFreq) - 1);

                    if (freqCount.get(oldFreq) == 0) {
                        freqCount.remove(oldFreq);
                    }
                }

                // Add new frequency count
                freqCount.put(newFreq,freqCount.getOrDefault(newFreq, 0) + 1);

                if (freqCount.size() == 2) {
                    int mini = freqCount.firstKey();
                    int maxi = freqCount.lastKey();

                    if (mini * 2 == maxi) {
                        maxLen = Math.max(maxLen, j - i + 1);
                    }
                }
            }
        }

        return maxLen;
    }
}