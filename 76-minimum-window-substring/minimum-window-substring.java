class Solution {
    
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> mp = new HashMap<>();

        // Build frequency map of characters in t
        for (char ch : t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        int count = mp.size();
        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (j < s.length()) {
            char endChar = s.charAt(j);

            if (mp.containsKey(endChar)) {
                mp.put(endChar, mp.get(endChar) - 1);
                if (mp.get(endChar) == 0) {
                    count--;
                }
            }

            // Try to shrink window
            while (count == 0) {
                char startChar = s.charAt(i);

                if (mp.containsKey(startChar)) {
                    mp.put(startChar, mp.get(startChar) + 1);

                    if (mp.get(startChar) == 1) {
                        // Update minimum
                        if (j - i + 1 < minLen) {
                            minLen = j - i + 1;
                            start = i;
                        }
                        count++;
                    }
                }
                i++;
            }

            j++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}