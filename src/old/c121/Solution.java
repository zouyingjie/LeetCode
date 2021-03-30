package old.c121;

class Solution {


    public int maxProfit(int[] prices) {

        int result = 0;

        int lowestPrice = prices[0];

        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] > lowestPrice) {
                result = Math.max(result, prices[i] - lowestPrice);
            }else {
                lowestPrice = prices[i];
            }
        }
        return result;

    }
}