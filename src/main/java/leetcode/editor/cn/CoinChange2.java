package leetcode.editor.cn;

//给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。 
//
// 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。 
//
// 假设每一种面额的硬币有无限个。 
//
// 题目数据保证结果符合 32 位带符号整数。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：amount = 5, coins = [1, 2, 5]
//输出：4
//解释：有四种方式可以凑成总金额：
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2： 
//
// 
//输入：amount = 3, coins = [2]
//输出：0
//解释：只用面额 2 的硬币不能凑成总金额 3 。
// 
//
// 示例 3： 
//
// 
//输入：amount = 10, coins = [10] 
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 300 
// 1 <= coins[i] <= 5000 
// coins 中的所有值 互不相同 
// 0 <= amount <= 5000 
// 
// Related Topics 数组 动态规划 👍 790 👎 0

public class CoinChange2 {
    public static void main(String[] args) {
        Solution solution = new CoinChange2().new Solution();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
        System.out.println(solution.change1(5,new int[]{1, 2, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * dp  前置条件 f(k) k>=0
     *k
     * 组合要先遍历硬币
     * 排列要先遍历金额
     */
    class Solution {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] += dp[i - coin];
                }
            }
            return dp[amount];
        }

        public int change1(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0]=1;
            for (int i = 1; i < amount+1; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i>=coins[j]){
                    dp[i]+=dp[i-coins[j]];
                    }

                }
            }
            return  dp[amount];
        }


        public int chang(int amount) {
            int[]  dp=new int[amount+1];
            dp[0]=0;
            dp[1]=1;
            for (int i = 2; i < amount+1; i++) {
                dp[i]=dp[i-1]+dp[i-2];
            }
            return dp[amount];

        }
    }



}
//leetcode submit region end(Prohibit modification and deletion)

