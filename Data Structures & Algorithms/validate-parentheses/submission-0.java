class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pairMap = new HashMap<>();
        pairMap.put(']', '[');
        pairMap.put('}', '{');
        pairMap.put(')', '(');
        Set<Character> checkSet = new HashSet<>();
        checkSet.add('[');
        checkSet.add('(');
        checkSet.add('{');
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i< s.length(); i++) {
            if (checkSet.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek() != pairMap.get(s.charAt(i))) {
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
