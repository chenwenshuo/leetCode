//对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。 
//
// 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。 
//
// 
//
// 示例 1： 
//
// 
//输入：str1 = "ABCABC", str2 = "ABC"
//输出："ABC"
// 
//
// 示例 2： 
//
// 
//输入：str1 = "ABABAB", str2 = "ABAB"
//输出："AB"
// 
//
// 示例 3： 
//
// 
//输入：str1 = "LEET", str2 = "CODE"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 1 <= str1.length, str2.length <= 1000 
// str1 和 str2 由大写英文字母组成 
// 
//
// Related Topics 数学 字符串 👍 371 👎 0


package leetcode.editor.cn;

/**
 * 字符串的最大公因子
 *
 * @author chenws
 * @date 2023-12-01 16:46:47
 */
public class P1071_GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1071_GreatestCommonDivisorOfStrings().new Solution();
        System.out.println(solution.gcdOfStrings("ABCABC","ABC"));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String gcdOfStrings(String str1, String str2) {
            if (!str1.concat(str2).equals(str2.concat(str1))) {
                return "";
            }
            return str1.substring(0, gcd(str1.length(), str2.length()));
        }

        public int gcd(int a, int b) {
            int remainder = a % b;
            while (remainder != 0) {
                a = b;
                b = remainder;
                remainder = a % b;
            }
            return b;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
