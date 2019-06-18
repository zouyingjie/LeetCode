package c123;

class Solution {


//    public int maxProfit(int[] prices) {
//
//        int len = prices.length;
//        if (len <= 1) {
//            return 0;
//        }
//
//        int result = 0;
//
//        for (int i = 1; i < len; i ++) {
//            result = Math.max(result, getProfit(prices, 0, i) + getProfit(prices, i+1, len-1));
//
//        }
//
//        return result;
//
//    }
//
//    public int getProfit(int[] prices, int start, int end) {
//        int result = 0;
//
//        int lowestPrice = prices[start];
//
//        for (int i = start+1; i <= end; i ++) {
//            if (prices[i] > lowestPrice) {
//                result = Math.max(result, prices[i] - lowestPrice);
//            }else {
//                lowestPrice = prices[i];
//            }
//        }
//        return result;
//
//    }

    public int maxProfit(int[] prices) {


        int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        int result = 0;

        int buy1 = 0;
        int sell1 = 0;
        int buy2 = 0;
        int sell2 = 0;


        for (int i = 1; i < len; i++) {

            sell2 = Math.max(sell2, buy2 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);

            sell1 = Math.max(buy1, buy1 + prices[i]);
            buy1 = Math.max(buy1, -prices[i]);


        }

        return sell2;

    }

}