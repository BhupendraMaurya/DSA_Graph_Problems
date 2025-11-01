class Solution {
    public int[][] merge(int[][] intervals) {
        // Since intervals are in the random order, so first sort it according to end time.
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();

        int startTime = intervals[0][0];
        int endTime = intervals[0][1];

        for(int i = 1; i < n; i++){
            // if current start time is less than or equal to last end time, then just update the end time.
            if(intervals[i][0] <= endTime){
                endTime = Math.max(endTime, intervals[i][1]);
            }
            // IF current start time is greatr than last end time, then add the last pair in the list
            // and also update the start and end time.
            else{
                list.add(new int[]{startTime, endTime});
                startTime = intervals[i][0];
                endTime = intervals[i][1];
            }
        }

        // Adding the last pair in the list as well.
        list.add(new int[]{startTime, endTime});

        int ans[][] = new int[list.size()][2];
        for(int i = 0; i < ans.length; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}