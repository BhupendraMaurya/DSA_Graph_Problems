class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] intervals, int freeStart, int freeEnd) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        int st = intervals[0][0];
        int prevTime = intervals[0][1];
        int n = intervals.length;
        for(int i = 1; i < intervals.length; i++){
            int stime = intervals[i][0];
            int endTime = intervals[i][1];
            if(stime <= prevTime+1){
                prevTime = Math.max(prevTime, endTime);
            }
            else{
                list.add(new ArrayList<>(Arrays.asList(st, prevTime)));
                st = stime;
                prevTime = endTime;
            }
        }
        list.add(new ArrayList<>(Arrays.asList(st, prevTime)));

        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> curr : list){
            int stime = curr.get(0);
            int et = curr.get(1);
            if(freeEnd < stime || freeStart > et){
                result.add(curr);
            }
            else if(stime >= freeStart && et <= freeEnd){// complete overlapped
                continue;
            }
            else{// partially. 
                if (stime < freeStart && et <= freeEnd){
                    result.add(new ArrayList<>(Arrays.asList(stime, freeStart-1)));
                }
                else if((stime >= freeStart && et > freeEnd)){
                    result.add(new ArrayList<>(Arrays.asList(freeEnd+1, et)));
                } 
                else{// completely inside given interval: if (stime < freeStart && et > freeEnd)
                    
                    result.add(new ArrayList<>(Arrays.asList(stime, freeStart-1)));
                    result.add(new ArrayList<>(Arrays.asList(freeEnd+1, et)));
                }
            }
        }
        return result;
    }
}