class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int [] occurance = new int[26];
        for (int i =0; i<s.length(); i++) {
            occurance[s.charAt(i) - 'a']++;
            occurance[t.charAt(i) - 'a']--;
        }
        for (int i=0;i<26;i++) {
            if (occurance[i] != 0)
                return false;
        }
        return true;
    }
}
