class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        ArrayList<int[]> ans = new ArrayList<>();
        

        int n = intervals.length;
        int i = 0;
        // “Go left (no overlap), merge middle (overlap), then go right (no overlap).
        
// for left part where it is not overlapping
        while(i < n && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }

        // Middle part, where it is overlapping, sowe have to find the min and max among the
        // overlapping intervals.

        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        while(i < n){
            ans.add(intervals[i]);
            i++;
        }

        int arr[][] = new int[ans.size()][2];

        for(int j = 0; j < arr.length; j++){
            arr[j] = ans.get(j);
        }
        return arr;

    }
}