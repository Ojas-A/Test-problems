class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Keep a start and current 
        // Keep inputting into a Map 
        // once a collision is found (compute the length) -> move start - till the collision, keep removing chars and then make start the 
        // next of collisopn index and current as curent++;
        Set<Character> elements = new HashSet<>();
        int l = 0, r=1, ans = 0, currLen =0 ;
        char[] word = s.toCharArray();
        if (s.length() == 0)
            return 0;
        elements.add(word[0]);
        while (r < s.length()) {
            if (elements.contains(word[r])) {
                currLen = r - l;
                ans = ans > currLen ? ans : currLen;
                while (word[l] != word[r]) {
                    elements.remove(word[l]);
                    l++;
                }
                l++;
                r++;
            } else {
                elements.add(word[r]);
                r++;
            }
        }
        return ans > (r-l) ? ans : (r-l);
    }
}
