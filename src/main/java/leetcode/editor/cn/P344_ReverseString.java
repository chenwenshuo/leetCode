//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = ["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 
//输入：s = ["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 都是 ASCII 码表中的可打印字符 
// 
//
// Related Topics 双指针 字符串 👍 795 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 反转字符串
 *
 * @author chenws
 * @date 2023-08-07 11:05:44
 */
public class P344_ReverseString {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P344_ReverseString().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void reverseString(char[] s) {
            char tem;
            for (int i = 0, r = s.length - 1; i < r; i++, r--) {
                tem = s[i];
                s[i] = s[r];
                s[r] = tem;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
