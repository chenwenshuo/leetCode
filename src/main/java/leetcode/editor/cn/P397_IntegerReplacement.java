//给定一个正整数 n ，你可以做如下操作： 
//
// 
// 如果 n 是偶数，则用 n / 2替换 n 。 
// 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。 
// 
//
// 返回 n 变为 1 所需的 最小替换次数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 8
//输出：3
//解释：8 -> 4 -> 2 -> 1
// 
//
// 示例 2： 
//
// 
//输入：n = 7
//输出：4
//解释：7 -> 8 -> 4 -> 2 -> 1
//或 7 -> 6 -> 3 -> 2 -> 1
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 贪心 位运算 记忆化搜索 动态规划 👍 289 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 整数替换
 *
 * @author chenws
 * @date 2023-10-17 15:00:11
 */
public class P397_IntegerReplacement {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P397_IntegerReplacement().new Solution();
        System.out.println(solution.integerReplacement4(7));

    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int integerReplacement2(int n) {
            if (n <= 1) {
                return 0;
            }
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 0;
            dp[2] = 1;
            for (int i = 3; i < n + 1; i++) {
                if (i % 2 == 0) {
                    dp[i] = dp[i / 2] + 1;
                    continue;
                }
                dp[i] = Math.min(dp[(i + 1) / 2], dp[(i - 1) / 2]) + 2;
            }
            return dp[n];
        }

        public int integerReplacement4(int n) {
            if (n <= 1) {
                return 0;
            }
            int[] dp = new int[n + 2];
            dp[0] = 0;
            dp[1] = 0;
            dp[2] = 1;
            for (int i = 4; i < n + 1; i += 2) {
                if ((i / 2) % 2 == 0) {
                    dp[i] = dp[i / 2] + 1;
                } else {
                    dp[i] = Math.min(dp[(n - 1) / 2], dp[(n + 1) / 2]) + 2;
                }
            }
            return n % 2 == 0 ? dp[n] : Math.min(dp[n - 1], dp[n + 1] + 1);
        }

        Map<Long, Integer> map;

        //stack
        public int integerReplacement(int n) {
            map = new HashMap<>();
            return integerReplacement5(n * 1L);
        }

        private int integerReplacement5(long n) {
            if (n == 1) {
                return 0;
            }
            if (n % 2 == 0) {
                return 1 + integerReplacement5(n / 2);
            }
            return 2 + Math.min(integerReplacement5(n / 2), integerReplacement5(n / 2 + 1));
        }

        private int integerReplacement1(long n) {
            if (map.containsKey(n)) {
                return map.get(n);
            }
            if (n == 1) {
                return 0;
            }
            if (n % 2 != 0) {
                int a = integerReplacement1((n + 1)/2);
                int b = integerReplacement1((n - 1)/2);
                map.put((n + 1)/2, a);
                map.put((n - 1)/2, b);
                return Math.min(a, b) + 2;
            }
            int c = integerReplacement1(n / 2);
            map.put(n / 2, c);
            return c + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
