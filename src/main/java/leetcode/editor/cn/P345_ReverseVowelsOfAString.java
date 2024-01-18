//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 340 👎 0


package leetcode.editor.cn;

import java.util.Set;

/**
 * 反转字符串中的元音字母
 *
 * @author chenws
 * @date 2023-12-01 17:33:33
 */
public class P345_ReverseVowelsOfAString {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P345_ReverseVowelsOfAString().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String reverseVowels(String s) {
            Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u','A','E','I','O','U');
            int length = s.length();
            String tem = "";
            for (int i = length - 1; i >= 0; i--) {
                if (set.contains(s.charAt(i))) {
                    tem += String.valueOf(s.charAt(i));
                }
            }

            String ans = "";
            int x = 0;
            for (int i = 0; i < length; i++) {
                if (set.contains(s.charAt(i))) {
                    ans += String.valueOf(tem.charAt(x++));
                    continue;
                }
                ans += String.valueOf(s.charAt(i));
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
