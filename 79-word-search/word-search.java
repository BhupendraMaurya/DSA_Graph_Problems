
class Solution {
    public boolean search(int i, int j, int idx, char board[][], String word, boolean vis[][]){
        // if idx is reached out of boundary, that means, we have got the required string, so returning true.
        if(idx >= word.length()){
            return true;
        }
        // if out of bounds, or already visited, or not matched, then just returning false. 
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0 || vis[i][j] || board[i][j] != word.charAt(idx)){
            return false;
        }
        // marking the current cell as visited and recursively calling the function for all of its 4 neighbours
        vis[i][j] = true;
        boolean result = search(i-1, j, idx+1, board, word, vis) || search(i, j+1, idx+1, board, word, vis) ||
                        search(i+1, j, idx+1, board, word, vis) || search(i, j-1, idx+1, board, word, vis);
        // backtracking
        vis[i][j] = false;
        // returning the result. 
        return result;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                if(word.charAt(0) == board[i][j] && search(i, j, 0, board, word, vis)){
                    return true;
                }
            }
        }
        return false;
    }
}