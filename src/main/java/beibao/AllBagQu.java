package beibao;

import leetcode.editor.cn.DeleteColumnsToMakeSorted;
import org.junit.Test;

/**
 * @Author: chenwenshuo
 * @Date: 2022/05/28/6:33 下午
 */
public class AllBagQu {

    @Test
    public void test(){
        int[] v=new int[]{1};
        int[] w=new int[]{1};
        int V=12;
        dp1(v,w,V);
        dp2(v,w,V);

    }
    /**
     * 二维数组
     *
     */
    public void dp1(int[] v, int[] w, int V){
        int length = v.length;
        int[][] dp=new int[length][V+1];
        dp[0][0]=0;
        for (int i = 0; i < v.length; i++) {
            for (int j = 1; j <=V; j++) {
                if (v[i]<=j)
                if (i==0){
                    dp[i][j]=dp[i][j-1]+w[i];
                }else {
                    //可以重复使用
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-v[i]]+w[i]);
                }else
                    dp[i][j]=dp[i][j-1];
            }

        }

        System.out.println(dp[length-1][V]);
    }

    /**
     * 一维数组
     * 可以重复使用 正序遍历  后一个会重复计算前一个
     *比如 dp[0]=0;
     * dp[1]=1
     * dp[2]=dp[1】+1=2 会重复利用上一个
     * @param v
     * @param w
     * @param V
     */
    public void dp2(int[] v, int[] w, int V){
        int[]dp=new int[V+1];
        dp[0]=0;
        for (int i = 0; i < v.length; i++) {
            for (int j = 1; j <= V; j++) {
                if (j>=v[i]){
                  dp[j]=Math.max(dp[j-v[i]]+w[i],dp[j]);
                }

        }


    }

        System.out.println(dp[V]);
}}
