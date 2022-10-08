package dp.gupiao;

import org.junit.Test;

/**
 * 122. 买卖股票的最佳时机 II
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 *
 *
 */
public class Two {

    /**
     * 贪心算法
     * 7,1,5,3,6,4
     * 只要价格比前面高就卖
     * 比前面低就买
     * 1-->5  3--->6
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {

        int p=prices[0];
        int ans=0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]>p){
                ans=ans+prices[i]-p;
                p=prices[i];
            }else {
                p=prices[i];
            }

        }

        return ans;
    }

    @Test
    public void test(){
        int i = maxProfit2(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }
    /**
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int p=-prices[0];
        int ans=0;
        for (int i = 1; i < prices.length; i++) {


            ans= Math.max(ans,prices[i]+p);
            p=Math.max(p,ans-prices[i]);

        }

        return ans;
    }
    public int maxProfit2(int[] prices) {

        int[] p=new int[prices.length];
        int[] ans=new int[prices.length];
        p[0]=prices[0];
        ans[0]=0;

        for (int i = 1; i < prices.length; i++) {
            //卖:当前价格-前面最低价格>之前利润
            ans[i]=Math.max(ans[i-1],prices[i]-p[i-1]);
            //买:当前价格-利润小于最小值时候
            p[i]=Math.min(p[i-1],prices[i]-ans[i]);

        }

        return ans[prices.length-1];
    }
}
