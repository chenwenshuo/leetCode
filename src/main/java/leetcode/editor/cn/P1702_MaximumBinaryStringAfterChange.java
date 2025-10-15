//给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改： 
//
// 
// 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。 
// 
//
// 
// 比方说， "00010" -> "10010" 
// 
// 
// 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
// 
// 比方说， "00010" -> "00001" 
// 
// 
//
//
// 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制
//字符串 x 大于二进制字符串 y 。 
//
// 
//
// 示例 1： 
//
// 
//输入：binary = "000110"
//输出："111011"
//解释：一个可行的转换为：
//"000110" -> "000101" 
//"000101" -> "100101" 
//"100101" -> "110101" 
//"110101" -> "110011" 
//"110011" -> "111011"
// 
//
// 示例 2： 
//
// 
//输入：binary = "01"
//输出："01"
//解释："01" 没办法进行任何转换。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= binary.length <= 10⁵ 
// binary 仅包含 '0' 和 '1' 。 
// 
//
// Related Topics 贪心 字符串 👍 70 👎 0


package leetcode.editor.cn;

/**
 * 修改后的最大二进制字符串
 * @author chenws
 * @date 2024-04-10 17:25:31
 */
public class P1702_MaximumBinaryStringAfterChange{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1702_MaximumBinaryStringAfterChange().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public String maximumBinaryString(String binary) {
		int i = binary.indexOf('0');
		if (i < 0) { // binary 全是 '1'
			return binary;
		}
		char[] s = binary.toCharArray();
		int cnt1 = 0;
		for (i++; i < s.length; i++) {
			cnt1 += s[i] - '0'; // 统计 [i, n-1] 中 '1' 的个数
		}
		return "1".repeat(s.length - 1 - cnt1) + '0' + "1".repeat(cnt1);
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}
