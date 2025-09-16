class Pair{
    String s;
    int totalWords;

    Pair(String s, int totalWords){
        this.s = s;
        this.totalWords = totalWords;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
       HashSet<String> set = new HashSet<>();

       for(String str : wordList){
        set.add(str);
       }

       Queue<Pair> q = new LinkedList<>();
       q.add(new Pair(beginWord, 1));

        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair curr = q.remove();
            String str = curr.s;
            int size = curr.totalWords;

            if(str.equals(endWord)){
                return size;
            }

            for(int i = 0;  i < str.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char arr[] = str.toCharArray();

                    arr[i] = ch;

                    String newStr = new String(arr);
                    if(set.contains(newStr)){
                        q.add(new Pair(newStr, size+1));
                        set.remove(newStr);      
                    }
                }
            }
            
        }

        return 0;
    }
}