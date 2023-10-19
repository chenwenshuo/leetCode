//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
//
// Related Topics 数学 字符串 模拟 👍 747 👎 0


package leetcode.editor.cn;

/**
 * 字符串相加
 *
 * @author chenws
 * @date 2023-07-17 11:41:32
 */
public class P415_AddStrings {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P415_AddStrings().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String addStrings(String num1, String num2) {
            int length1 = num1.length() - 1;
            int length2 = num2.length() - 1;
            int tem = 0;
            StringBuilder p = new StringBuilder();
            while (length1 >= 0 && length2 >= 0) {
                int n = num1.charAt(length1) + num2.charAt(length2) + tem - '0' - '0';
                p.insert(0, n % 10);
                tem = n / 10;
                length1--;
                length2--;
            }
            if (length1 >= 0) {
                for (int i = length1; i >= 0; i--) {

                    int n = num1.charAt(i) + tem - '0';
                    p.insert(0, n % 10);
                    tem = n / 10;

                }

            }
            if (length2 >= 0) {
                for (int i = length2; i >= 0; i--) {

                    int n = num2.charAt(i) + tem - '0';
                    p.insert(0, n % 10);
                    tem = n / 10;
                }
            }

            return tem > 0 ? tem + p.toString() : p.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
