class Solution {
    public int maxArea(int[] bars) {
        int maxArea = 0, currProd = 1;
        int l = 0, r = bars.length-1;
        while (l < r) {
            currProd = Math.min(bars[l], bars[r]) * (r-l);
            maxArea = currProd > maxArea ? currProd : maxArea;
            if (bars[l] == bars[r]) {
                l ++;
                r --;
            } else if (bars[l] > bars[r]) {
                r --;
            } else {
                l ++;
            }
        }
        return maxArea;
    }
}
