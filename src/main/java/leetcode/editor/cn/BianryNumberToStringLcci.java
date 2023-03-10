//二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印
//“ERROR”。 
//
// 示例1: 
//
// 
// 输入：0.625
// 输出："0.101"
// 
//
// 示例2: 
//
// 
// 输入：0.1
// 输出："ERROR"
// 提示：0.1无法被二进制准确表示
// 
//
// 
//
// 提示： 
//
// 
// 32位包括输出中的 "0." 这两位。 
// 题目保证输入用例的小数位数最多只有 6 位 
// 
//
// Related Topics 位运算 数学 字符串 👍 101 👎 0


package leetcode.editor.cn;

/**
 * 二进制数转字符串
 * @author chenws
 * @date 2023-03-02 15:10:28
 */
public class BianryNumberToStringLcci{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new BianryNumberToStringLcci().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 // bwwb


		public String  printBin(double num) {
			if (num >= 1 || num <= 0) {
				return "ERROR";
			}
			StringBuilder sb = new StringBuilder();
			sb.append("0.");
			while (num > 0) {
				if (sb.length() > 32) {
					return "ERROR";
				}
				double r = num * 2;
				if (r >= 1) {
					sb.append("1");
					num = r - 1;
				} else {
					sb.append("0");
					num = r;
				}
			}
			return sb.toString();
		}
}
//leetcode submit region end(Prohibit modification and deletion)

}
