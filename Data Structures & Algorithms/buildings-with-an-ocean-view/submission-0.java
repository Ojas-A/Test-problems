class Solution {
    public int[] findBuildings(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(heights.length-1);
        for (int i=heights.length-2; i>=0;i--) {
            if(heights[stack.peek()] < heights[i]) {
                stack.push(i);
            }
        }
        int[] ans = new int[stack.size()];
        for (int i=0;i<ans.length;i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}