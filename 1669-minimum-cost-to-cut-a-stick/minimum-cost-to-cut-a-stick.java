class Solution {
    public int fun(int i, int j, ArrayList<Integer> list, int dp[][]){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;
        for(int idx = i; idx <= j; idx++){
            int cost = list.get(j+1)-list.get(i-1) + fun(i, idx-1, list, dp) + fun(idx+1, j, list, dp);
            mini = Math.min(mini, cost);
        }
        return dp[i][j] = mini;
    }
    
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for(int val : cuts){
            list.add(val);
        }
        list.add(n);
        int dp[][] = new int[cuts.length+1][cuts.length+1];
        for(int rows[] : dp){
            Arrays.fill(rows, -1);
        }

        return fun(1, cuts.length, list, dp);
    }
}