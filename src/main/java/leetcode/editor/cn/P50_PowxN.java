//实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xⁿ ）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// n 是一个整数 
// 要么 x 不为零，要么 n > 0 。 
// -104 <= xⁿ <= 104 
// 
//
// Related Topics 递归 数学 👍 1254 👎 0


package leetcode.editor.cn;

/**
 * Pow(x, n)
 *
 * @author chenws
 * @date 2023-10-16 13:45:26
 */
public class P50_PowxN {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P50_PowxN().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }
            return n > 0 ? x * myPow(x, n - 1) : 1 / x * myPow(x, (-n) - 1);

        }

        public double myPow1(double x, int n) {
            if (n == 0) {
                return 1;
            }

            return n > 0 ? myPow2(x, n) : 1 / myPow2(x, -n);

        }

        private double myPow2(double x, int n) {
            if (n == 0) {
                return 1;
            }
            double p = myPow(x, n / 2);
            return n % 2 == 0 ? p * p : x * p * p;
        }

        public double quickMul(double x, long N) {

            double ans = 1.0;

            double tem = x;
            while (N > 0) {
                if (N % 2 == 1) {
                    ans *= tem;
                }
                tem *= tem;
                N = N / 2;
            }
            return ans;
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)

}
