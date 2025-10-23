class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        for(int i = 0; i < s.length; i++){
            for(int j = 0; j < g.length; j++){
                if(s[i] < g[j]){
                    break;
                }
                else if(s[i] >= g[j] && g[j] != -1){
                    ans++;
                    g[j] = -1;
                    break;
                }
            }
        }
        return ans;
    }
}