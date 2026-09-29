class Solution {
    public int[] findBuildings(int[] heights) {
        int max = 0, i=heights.length-1;
        List<Integer> ans = new ArrayList<>();
        while(i >= 0) {
            if (max < heights[i]) {
                max = heights[i];
                ans.add(i);
            }
            i--;
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
        // Deque<Integer> stack = new ArrayDeque<>();
        // stack.push(heights.length-1);
        // for (int i=heights.length-2; i>=0;i--) {
        //     if(heights[stack.peek()] < heights[i]) {
        //         stack.push(i);
        //     }
        // }
        // int[] ans = new int[stack.size()];
        // for (int i=0;i<ans.length;i++) {
        //     ans[i] = stack.pop();
        // }
        // return ans;
    }
}