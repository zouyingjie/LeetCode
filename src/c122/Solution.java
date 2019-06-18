package c122;

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        int result = 0;
        int currentProfit = 0;

        int lowestPrice = prices[0];

        for (int i = 1; i < len; i ++) {
            int num = prices[i];
            if (num > lowestPrice) {
                int profit = num - lowestPrice;
                if (profit > currentProfit) {
                    currentProfit = profit;
                    if (i == (len-1)){
                        result += currentProfit;
                    }
                }else {
                    result += currentProfit;
                    currentProfit = 0;
                    lowestPrice = num;

                }
            }else {
                result += currentProfit;
                currentProfit = 0;
                lowestPrice = num;
            }
        }
        return result;
    }
}