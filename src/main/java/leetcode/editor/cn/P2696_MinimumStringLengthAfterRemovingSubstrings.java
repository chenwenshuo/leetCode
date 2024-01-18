//给你一个仅由 大写 英文字符组成的字符串 s 。 
//
// 你可以对此字符串执行一些操作，在每一步操作中，你可以从 s 中删除 任一个 "AB" 或 "CD" 子字符串。 
//
// 通过执行操作，删除所有 "AB" 和 "CD" 子串，返回可获得的最终字符串的 最小 可能长度。 
//
// 注意，删除子串后，重新连接出的字符串可能会产生新的 "AB" 或 "CD" 子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABFCACDB"
//输出：2
//解释：你可以执行下述操作：
//- 从 "ABFCACDB" 中删除子串 "AB"，得到 s = "FCACDB" 。
//- 从 "FCACDB" 中删除子串 "CD"，得到 s = "FCAB" 。
//- 从 "FCAB" 中删除子串 "AB"，得到 s = "FC" 。
//最终字符串的长度为 2 。
//可以证明 2 是可获得的最小长度。 
//
// 示例 2： 
//
// 
//输入：s = "ACBBD"
//输出：5
//解释：无法执行操作，字符串长度不变。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 仅由大写英文字母组成 
// 
//
// Related Topics 栈 字符串 模拟 👍 42 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除子串后的字符串最小长度
 *
 * @author chenws
 * @date 2024-01-10 14:16:32
 */
public class P2696_MinimumStringLengthAfterRemovingSubstrings {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2696_MinimumStringLengthAfterRemovingSubstrings().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String ab = "AB";
        String cd = "CD";

        public int minLength(String s) {
            Deque<Character> deque = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (!deque.isEmpty()) {
                    Character peek = deque.peek();
                    if ((c == 'B' && peek == 'A') || (c == 'D' && peek == 'C')) {
                        deque.poll();
                    } else {
                        deque.push(c);
                    }
                } else {
                    deque.push(c);
                }
            }


            return deque.size();
        }

        public int minLength1(String s) {

            s = re(s);
            return s.length();
        }

        private String re(String s) {
            if (!s.contains(ab) && !s.contains(cd)) {
                return s;
            }
            String s1 = s;
            if (s.contains(ab)) {
                s1 = s.replaceAll(ab, "");
            }
            if (s.contains(cd)) {
                s1 = s.replaceAll(cd, "");
            }
            return re(s1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
