class Solution {
    public boolean isPalindrome(String s) {
        int forward = 0, backward = s.length()-1;
        char[] chars = s.toLowerCase().toCharArray();
        // limits 0-9 : 48-57   A-Z: 65-90 a-z: 97-122
        while (forward < backward) {
            while(forward < s.length() && !isValidChar(chars[forward])) {
                forward++;
            }
            while(backward > 0 && !isValidChar(chars[backward])) {
                backward--;
            }
            if (forward >= backward) 
                break;
            if(chars[forward] != chars[backward])
                return false;
            forward ++;
            backward--;    
        }
        return true;
    }

    private boolean isValidChar(char c) {
        int val = c;
        return (val >= 48 && val <= 57) || (val >= 97 && val <= 122);
    }
}
