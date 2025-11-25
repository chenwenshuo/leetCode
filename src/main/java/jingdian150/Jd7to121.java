package jingdian150;

public class Jd7to121 {

    //[7,1,5,3,6,4]
    //输出：5
    //贪心
    public int maxProfit(int[] prices) {
        int ans = 0;

        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]>buy){
                ans = Math.max(ans,buy-prices[i]);
                continue;
            }
            buy = prices[i];
        }

        return ans;

    }

    //dp
    public int maxProfit2(int[] prices) {
        int p=-prices[0];//持仓股票时候手里的现金
        int ans=0; //利率

        for (int i = 1; i < prices.length; i++) {

            p=Math.max(p,-prices[i]);
            ans=Math.max(ans,prices[i]+p);

        }


        return ans;
    }
}
