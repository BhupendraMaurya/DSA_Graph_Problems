class Solution {
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
    //taking a  map and storing each vowel by its freq and first occurence of it(means first index where it occurs first)
    // taking the PQ and making the custom sorting logic first by greater freq and if freq is equal,
    // then sorting according to lower index. 
    // then storing all the vowels in a list,
    // then taking a stringbuilder and start traversing on the given string and then keep adding the
    // chars in the sb, and if it is vowel. then take it from list, else, take it from string and
    // add in the sb. 
    public String sortVowels(String s) {
        Map<Character, int[]> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                map.putIfAbsent(ch, new int[]{0, i});
                map.get(ch)[0]++;
            }
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
            int freq1[] = map.get(a);
            int freq2[] = map.get(b);
            if(freq1[0] != freq2[0]){
                return freq2[0] - freq1[0];
            }
            else{
                return freq1[1] - freq2[1];
            }
        });

        pq.addAll(map.keySet());
        List<Character> list = new ArrayList<>();
        while(!pq.isEmpty()){
            char ch = pq.poll();
            int count = map.get(ch)[0];
            for(int i = 0; i < count; i++){
                list.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(char ch : s.toCharArray()){
            if(isVowel(ch)){
                sb.append(list.get(i++));
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}