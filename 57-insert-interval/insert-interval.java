class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<int[]> ans = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            list.add(new int[]{intervals[i][0], intervals[i][1]});
        }

        list.add(new int[]{newInterval[0], newInterval[1]});

        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));

        int interval[] = list.get(0);
        int endTime = interval[1];
        int startTime = interval[0];

        for(int i = 1; i < list.size(); i++){
            int currInterval[]  = list.get(i);
            if(currInterval[0] <= endTime){
                endTime = Math.max(endTime, currInterval[1]);
            }
            else{
                ans.add(new int[]{startTime, endTime});
                startTime = currInterval[0];
                endTime = currInterval[1]; 
            }
        }

        ans.add(new int[]{startTime, endTime});
        int arr[][] = new int[ans.size()][2];

        for(int i = 0; i < arr.length; i++){
            arr[i] = ans.get(i);
        }
        return arr;

    }
}