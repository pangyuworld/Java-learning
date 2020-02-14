package com.mianshi.offer.m63;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m63
 * @description:
 * @date 2020/2/14 10:40
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) return 0;
        // dp0 表示此前最低的股票价格
        // dp1 表示当前最大的可能利润
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            prices[i] = Math.min(prices[i - 1], prices[i]);
            res = Math.max(res, prices[i] - prices[i - 1]);
        }
        return res;
    }
}
