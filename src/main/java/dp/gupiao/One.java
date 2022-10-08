package dp.gupiao;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *
 */
public class One {
    /**
     * 假设第一天买了股票  p=p[0]
     * ans=0(其实可以赋值为-p 题目要求最小返回0)
     *
     * 每到新的一天 两步操作
     * 卖股票  买股票
     *
     * 1.卖股票
     * 利润=当天价格-买入价格
     *
     * 2.买股票
     * 股票持有=当天价格
     *
     * 即:对于当天 取股票最小值
     *   当天价格-历史最低为利润
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
      int p=prices[0];//持仓股票
        int ans=0; //利率

        for (int i = 1; i < prices.length; i++) {
            p=Math.min(p,prices[i]);
            ans=Math.max(ans,prices[i]-p);
        }


        return ans;

    }

    public int maxProfit1(int[] prices) {
        int p=-prices[0];//持仓股票时候手里的现金
        int ans=0; //利率

        for (int i = 1; i < prices.length; i++) {
            p=Math.max(p,prices[i]);
            ans=Math.max(ans,prices[i]+p);
        }


        return ans;

    }
}
