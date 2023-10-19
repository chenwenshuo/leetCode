//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 1910 👎 0


package leetcode.editor.cn;

/**
 * 找出字符串中第一个匹配项的下标
 *
 * @author chenws
 * @date 2023-07-17 15:32:01
 */
public class P28_FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P28_FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int strStr(String s, String p) {
            return s.indexOf(p);
        }

        public int kmp(String s, String p) {
            int[] next = getNext1(p);
            int i = 0, j = 0;
            while (i < s.length() && j < p.length()) {
                if (j == -1 || s.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
            }
            if (j == p.length()) {
                return i - j;
            }
            return -1;
        }

        private int[] getNext1(String p) {
            int[] next = new int[p.length()];
            next[0] = -1;
            next[1] = 0;
            int j = -1;
            int i = 0;
            while (i < p.length() - 1) {
                if (j == -1 || p.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                    next[i] = j;
                } else {
                  j = next[i];
                }
            }
            return next;

        }

        /**
         * 求next数组 1.初始化next[0] = -1, i = 0, j = -1 2.如果j == -1或者p[i] == p[j], 则i++, j++, next[i] = j 3.否则, j = next[j] a b c d a b c e -1 0 0 0 0 1 2 3
         */
        private int[] getNext(String p) {
            int[] next = new int[p.length()];
            next[0] = -1;
            int i = 0, j = -1;
            //对应的next数组的值
            while (i < p.length() - 1) {
                if (j == -1 || p.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                    next[i] = j;
                } else {
                    j = next[j];
                }
            }
            return next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
