//给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母
//。如果不存在这样的两个单词，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
//输出：16 
//解释：这两个单词为 "abcw", "xtfn"。 
//
// 示例 2： 
//
// 
//输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
//输出：4 
//解释：这两个单词为 "ab", "cd"。 
//
// 示例 3： 
//
// 
//输入：words = ["a","aa","aaa","aaaa"]
//输出：0 
//解释：不存在这样的两个单词。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= words.length <= 1000 
// 1 <= words[i].length <= 1000 
// words[i] 仅包含小写字母 
// 
//
// Related Topics 位运算 数组 字符串 👍 473 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 最大单词长度乘积
 *
 * @author chenws
 * @date 2023-11-06 15:45:38
 */
public class P318_MaximumProductOfWordLengths {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P318_MaximumProductOfWordLengths().new Solution();
        System.out.println(1<<1);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProduct(String[] words) {
            int[] bit = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                for (char ch : words[i].toCharArray()) {
                    bit[i] |= 1 << (ch - 'a');
                }
            }
            int res = 0;
            for (int i = 0; i < bit.length; i++) {
                for (int j = i + 1; j < bit.length; j++) {
                    if ((bit[i] & bit[j]) == 0) {
                        res = Math.max(res, words[i].length() * words[j].length());
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
