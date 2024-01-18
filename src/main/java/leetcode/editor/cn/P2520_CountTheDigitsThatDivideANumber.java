//给你一个整数 num ，返回 num 中能整除 num 的数位的数目。 
//
// 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。 
//
// 
//
// 示例 1： 
//
// 输入：num = 7
//输出：1
//解释：7 被自己整除，因此答案是 1 。
// 
//
// 示例 2： 
//
// 输入：num = 121
//输出：2
//解释：121 可以被 1 整除，但无法被 2 整除。由于 1 出现两次，所以返回 2 。
// 
//
// 示例 3： 
//
// 输入：num = 1248
//输出：4
//解释：1248 可以被它每一位上的数字整除，因此答案是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 10⁹ 
// num 的数位中不含 0 
// 
//
// Related Topics 数学 👍 27 👎 0


package leetcode.editor.cn;

/**
 * 统计能整除数字的位数
 *
 * @author chenws
 * @date 2023-10-26 11:47:41
 */
public class P2520_CountTheDigitsThatDivideANumber {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2520_CountTheDigitsThatDivideANumber().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int ans;

        public int countDigits(int num) {
            ans = 0;
            check(num, num);

            return ans;
        }

        private void check(int num, int tem) {
            if (tem == 0) {
                return;
            }
            if (num % (tem % 10) == 0) {
                ans++;
            }
            check(num, tem / 10);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
