//给你两个数字字符串 num1 和 num2 ，以及两个整数 max_sum 和 min_sum 。如果一个整数 x 满足以下条件，我们称它是一个好整数： 
//
// 
// num1 <= x <= num2 
// min_sum <= digit_sum(x) <= max_sum. 
// 
//
// 请你返回好整数的数目。答案可能很大，请返回答案对 10⁹ + 7 取余后的结果。 
//
// 注意，digit_sum(x) 表示 x 各位数字之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "1", num2 = "12", min_num = 1, max_num = 8
//输出：11
//解释：总共有 11 个整数的数位和在 1 到 8 之间，分别是 1,2,3,4,5,6,7,8,10,11 和 12 。所以我们返回 11 。
// 
//
// 示例 2： 
//
// 
//输入：num1 = "1", num2 = "5", min_num = 1, max_num = 5
//输出：5
//解释：数位和在 1 到 5 之间的 5 个整数分别为 1,2,3,4 和 5 。所以我们返回 5 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1 <= num2 <= 10²² 
// 1 <= min_sum <= max_sum <= 400 
// 
//
// Related Topics 数学 字符串 动态规划 👍 47 👎 0


package leetcode.editor.cn;

/**
 * 统计整数数目
 * @author chenws
 * @date 2024-01-16 10:26:54
 */
public class P2719_CountOfIntegers{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P2719_CountOfIntegers().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int count(String num1, String num2, int min_sum, int max_sum) {
		int ans = 0;

		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
