//给出一个单词数组 words ，其中每个单词都由小写英文字母组成。 
//
// 如果我们可以 不改变其他字符的顺序 ，在 wordA 的任何地方添加 恰好一个 字母使其变成 wordB ，那么我们认为 wordA 是 wordB 的 
//前身 。 
//
// 
// 例如，"abc" 是 "abac" 的 前身 ，而 "cba" 不是 "bcad" 的 前身 
// 
//
// 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word1 是 word2 的前身，word2 是
// word3 的前身，依此类推。一个单词通常是 k == 1 的 单词链 。 
//
// 从给定单词列表 words 中选择单词组成词链，返回 词链的 最长可能长度 。 
//
// 示例 1： 
//
// 
//输入：words = ["a","b","ba","bca","bda","bdca"]
//输出：4
//解释：最长单词链之一为 ["a","ba","bda","bdca"]
// 
//
// 示例 2: 
//
// 
//输入：words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
//输出：5
//解释：所有的单词都可以放入单词链 ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
// 
//
// 示例 3: 
//
// 
//输入：words = ["abcd","dbqca"]
//输出：1
//解释：字链["abcd"]是最长的字链之一。
//["abcd"，"dbqca"]不是一个有效的单词链，因为字母的顺序被改变了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 16 
// words[i] 仅由小写英文字母组成。 
// 
//
// Related Topics 数组 哈希表 双指针 字符串 动态规划 👍 250 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 最长字符串链
 *
 * @author chenws
 * @date 2023-04-27 11:08:30
 */
public class P1048_LongestStringChain {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1048_LongestStringChain().new Solution();
        solution.longestStrChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"});
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestStrChain(String[] words) {
            Map<String, Integer> cnt = new HashMap<String, Integer>();
            Arrays.sort(words, (a, b) -> a.length() - b.length());
            int res = 0;
            for (String word : words) {
                cnt.put(word, 1);
                for (int i = 0; i < word.length(); i++) {
                    String prev = word.substring(0, i) + word.substring(i + 1);
                    if (cnt.containsKey(prev)) {
                        cnt.put(word, Math.max(cnt.get(word), cnt.get(prev) + 1));
                    }
                }
                res = Math.max(res, cnt.get(word));
            }
            return res;
        }
    }

        private boolean check(String str1, String str2) {
            int len1 = str1.length();
            int diff = 0;
            for (int idx1 = 0, idx2 = 0; idx1 < len1 && diff < 2; ) {
                if (str1.charAt(idx1) == str2.charAt(idx2)) {
                    ++idx1;
                } else {
                    ++diff;
                }
                ++idx2;
            }
            return diff < 2;
        }

        class Good {

            private String a;

            private String b;

            private Boolean flag;

            public Good(String a, String b) {
                this.a = a;
                this.b = b;
            }

            public Good(String a, String b, Boolean flag) {
                this.a = a;
                this.b = b;
                this.flag = flag;
            }

            public Boolean getFlag() {
                return flag;
            }

            public void setFlag(Boolean flag) {
                this.flag = flag;
            }

            public String getA() {
                return a;
            }

            public void setA(String a) {
                this.a = a;
            }

            public String getB() {
                return b;
            }

            public void setB(String b) {
                this.b = b;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


