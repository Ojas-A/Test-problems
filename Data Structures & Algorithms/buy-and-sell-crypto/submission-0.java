class Solution {
    public int maxProfit(int[] prices) {
        int [] maxP = new int[prices.length];
        int max = -1;
        for (int i= prices.length-1;i >=0;i--) {
            if (prices[i] > max) {
                max = prices[i];
            }
            maxP[i] = max;
        }
        int profit = 0;
        for (int i=0; i< prices.length;i++) {
            int tempProf = maxP[i] - prices[i];
            profit = profit > tempProf ? profit : tempProf;
        }
        return profit;
        // int profit = 0;
        // int l = 0, r=0;
        // while (l < prices.length -1) {
        //     while(r+1 < prices.length && prices[r] < prices[r+1]) {
        //         r++;
        //     }
        //     profit += (prices[r] - prices[l]);
        //     l = r+1;
        //     r = r+1; 
        // }
        // return profit;
    }
}
