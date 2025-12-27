class Pair{
    String str;
    int length;

    public Pair(String str, int length){
        this.str = str;
        this.length = length;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();

        for(String s : wordList){
            set.add(s);
        }

        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);

        int ans = 0;
        while(!q.isEmpty()){
            Pair curr = q.remove();
            String s = curr.str;
            int len = curr.length;

            if(s.equals(endWord)){
                return len;
            }

            for(int i = 0; i < s.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char arr[] = s.toCharArray();

                    arr[i] = ch;
                    String newString = new String(arr);
                    if(set.contains(newString)){
                        q.add(new Pair(newString, len+1));
                        set.remove(newString);
                    }
                }
            }
        }

        return 0;
    }
}