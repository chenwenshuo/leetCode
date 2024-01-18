//给你一个字符串 word ，你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次，返回使 word 有效 需要插入的最少字母数。 
//
// 如果字符串可以由 "abc" 串联多次得到，则认为该字符串 有效 。 
//
// 
//
// 示例 1： 
//
// 输入：word = "b"
//输出：2
//解释：在 "b" 之前插入 "a" ，在 "b" 之后插入 "c" 可以得到有效字符串 "abc" 。
// 
//
// 示例 2： 
//
// 输入：word = "aaa"
//输出：6
//解释：在每个 "a" 之后依次插入 "b" 和 "c" 可以得到有效字符串 "abcabcabc" 。
// 
//
// 示例 3： 
//
// 输入：word = "abc"
//输出：0
//解释：word 已经是有效字符串，不需要进行修改。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 50 
// word 仅由字母 "a"、"b" 和 "c" 组成。 
// 
//
// Related Topics 栈 贪心 字符串 动态规划 👍 37 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 构造有效字符串的最少插入数
 *
 * @author chenws
 * @date 2024-01-11 10:09:09
 */
public class P2645_MinimumAdditionsToMakeValidString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2645_MinimumAdditionsToMakeValidString().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int addMinimum(String word) {
            Deque<Integer> stack = new LinkedList<>();
            int ans = 0;
            for (int i = 0; i < word.length() - 1; i++) {
                stack.push(word.charAt(i) - 'a');
            }
            if (word.length() == 1) {
                return 2;
            }
            int tem = word.charAt(word.length() - 1) - 'a';
            if (tem == 0) ans += 2;
            if (tem == 1) ans++;
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                if (tem - pop == 0) {
                    ans += 2;
                }
                if (tem - pop == 2) {
                    ans++;
                }
                if (tem - pop == -1 && tem == 0) {
                    ans++;
                }
                if (tem - pop == -1 && tem == 1) {
                    ans++;
                }
                tem = pop;
            }
            if (tem == 1) ans++;
            if (tem == 2) ans += 2;

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
