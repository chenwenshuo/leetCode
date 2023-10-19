//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
//
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 708 👎 0


package leetcode.editor.cn;

/**
 * 斐波那契数
 *
 * @author chenws
 * @date 2023-10-16 15:45:53
 */
public class P509_FibonacciNumber {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P509_FibonacciNumber().new Solution();
        System.out.println(solution.fib2(4));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] tem;

        public int fib2(int n) {
            if (n<=1){
                return n;
            }
            int f1 = 0;
            int f2 = 1;
           int f = 0;
            for (int i = 2; i <=n; i++) {
                f = f1+f2;
                f1 = f2;
                f2 = f;
            }
            return f;

        }
        public int fib(int n) {
            if (n<=1){
                return n;
            }
            tem = new int[n+1];
            return fib1(n-1)+fib(n-2);

        }

        private int fib1(int n) {
            if (tem[n] > 0) {
                return tem[n];
            }
            if (n <= 1) {
                tem[n] = n;
                return n;
            }
            tem[n - 2] = fib(n - 2);
            tem[n - 1] = fib(n - 1);
            return tem[n - 2] + tem[n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
