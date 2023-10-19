//给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 如果存在一个整数 x 使得 n == 2ˣ ，则认为 n 是 2 的幂次方。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：true
//解释：2⁰ = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 16
//输出：true
//解释：2⁴ = 16
// 
//
// 示例 3： 
//
// 
//输入：n = 3
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：n = 4
//输出：true
// 
//
// 示例 5： 
//
// 
//输入：n = 5
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能够不使用循环/递归解决此问题吗？ 
//
// Related Topics 位运算 递归 数学 👍 636 👎 0


package leetcode.editor.cn;

/**
 * 2 的幂
 *
 * @author chenws
 * @date 2023-10-16 13:56:50
 */
public class P231_PowerOfTwo {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P231_PowerOfTwo().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isPowerOfTwo(int n) {
            return power(n);
        }

        private boolean power(int n) {
            if (n == 1) {
                return true;
            }
            if (n % 2 != 0) {
                return false;
            }
            return power(n / 2);
        }

        private boolean power1(int n) {
            if (n == 1) {
                return true;
            }
            if (n % 2 != 0) {
                return false;
            }
            while (n > 1) {
                if (n % 2 > 0) {
                    return false;
                }
                n = n / 2;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
