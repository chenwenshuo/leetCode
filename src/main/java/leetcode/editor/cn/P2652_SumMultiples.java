//给你一个正整数 n ，请你计算在 [1，n] 范围内能被 3、5、7 整除的所有整数之和。 
//
// 返回一个整数，用于表示给定范围内所有满足约束条件的数字之和。 
//
// 
//
// 示例 1： 
//
// 输入：n = 7
//输出：21
//解释：在 [1, 7] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7 。数字之和为 21 。
// 
//
// 示例 2： 
//
// 输入：n = 10
//输出：40
//解释：在 [1, 10] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7、9、10 。数字之和为 40 。
// 
//
// 示例 3： 
//
// 输入：n = 9
//输出：30
//解释：在 [1, 9] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7、9 。数字之和为 30 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10³ 
// 
//
// Related Topics 数学 👍 33 👎 0


package leetcode.editor.cn;

/**
 * 倍数求和
 *
 * @author chenws
 * @date 2023-10-17 10:23:07
 */
public class P2652_SumMultiples {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2652_SumMultiples().new Solution();

    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int sumOfMultiples(int n) {

            return getSum(n, 3) + getSum(n, 5) + getSum(n, 7) - getSum(n, 15) - getSum(n, 21) - getSum(n, 35) - getSum(n, 105);
        }

        public int getSum(int n, int c) {
            int a1 = c;
            int nx = n / c;
            int anx = nx * c;
            return nx * (a1 + anx) / 2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
