package jingdian150;

public class Jd8to122 {

    // 2 1 3 5 4 5
    //[7,1,5,3,6,4]
    //输出
    //3
    //预期结果
    //7
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
    //贪心 比前一天高就卖
    public static int maxProfit(int[] prices) {
        int ans = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i]>prices[i-1]){
                ans+= prices[i]-prices[i-1];
            }
        }

        return ans;
    }

    //dp
    //  //[7,1,2,5,3,6,4]
    //    //输出
    //    //3
    //    //预期结果
    //    //7
    public static int maxProfit1(int[] prices) {
        int p=-prices[0];
        int ans=0;
        for (int i = 1; i < prices.length; i++) {
            ans= Math.max(ans,prices[i]+p);
            p=Math.max(p,ans-prices[i]);

        }

        return ans;
    }
}
