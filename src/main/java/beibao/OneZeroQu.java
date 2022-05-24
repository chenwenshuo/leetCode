package beibao;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: chenwenshuo
 * @Date: 2022/05/24/3:39 下午\
 * 1.　01背包问题
 * <p>
 * 有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。第 i 件物品的体积是 vi，价值是 wi。
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。输出最大价值。
 **/
public class OneZeroQu {

    @Test
    public void test(){
        int[] v=new int[]{1,2,3};
        int[] w=new int[]{1,2,3};
        int V=4;
        dp1(v,w,V);

    }

    /**=1
     *dp[i][j]表示在 只能选择前i个物品，背包容量为j的情况下，背包中物品的最大价值。
     * 这里之所以要N+1和V+1，是因为第0行表示只能选择第0个物品的时候，即没有物品的时候第0列表示背包的体积为0的时候，即不能装任何东西的时候.
     *
     * 已知dp[i-1][j],要求dp[i][j],则需要状态转移方程
     * 对于dp[i][j]有两种情况：
     * 　　1.不选择当前的第i件物品/第i件物品比背包容量要大
     * 　　　　　　　　　　　　dp[i][j] = dp[i-1][j]
     * 　　2.选择当前的第i件物品（潜在要求第i件物品体积小于等于背包总容量），则能装入的物品最大价值为：当前物品的价值 加上 背包剩余容量在只能选前i-1件物品的情况下的最大价值。表示为：
     * 　　　　　　　　　　dp[i][j] = dp[i-1][j-v[i]] + w[i]
     * dp[i][j]在两种情况中选择比较大的情况作为当前的最优解；
     * 即：
     * 　　　if(j >= v[i]):
     * 　　　　　　dp[i][j] = max(dp[i-1][j], dp[i-1][j-v[i]] + w[i])
     * 　　　else:
     * 　　　　　　dp[i][j] = dp[i-1][j]
     * @param v
     * @param w
     * @param V
     */
    public void dp2(int[] v, int[] w, int V) {
        int length = v.length;
        int[][] dp = new int[length][V + 1];
        dp[0][0] = 0;
        for (int i = 0; i < v.length; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (j >=v[i]) {
                    if (i == 0) {
                        dp[0][j] = Math.max(dp[0][j - 1], w[i]);
                    }else {
                        if (j>=v[i]){
                            dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j-v[i]]+w[i]);
                        }
                    }
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }

        }

        System.out.println(dp[length-1][V]);

    }



    /**
     /* * 压缩为一维数组   dp[v] dp[i]表示装i时候的最大价值
     * max(dp[i-1],dp[i-v[i]]+w[i])
     * @param v
     * @param w
     * @param V
     */

    public void dp1(int[] v, int[] w, int V) {

        int dp1[] = new int[V + 1];
        dp1[0] = 0;

        for (int i = 0; i < v.length; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (j >= v[i]) {
                    dp1[j] = Math.max(dp1[j], dp1[j - v[i]] + w[i]);
                }
            }

        }
        System.out.println(dp1[V]);

    }


}
