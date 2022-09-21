//对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k 。 
//
// 给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab", s2 = "ba"
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：s1 = "abc", s2 = "bca"
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length <= 20 
// s2.length == s1.length 
// s1 和 s2 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母 
// s2 是 s1 的一个字母异位词 
// 
// Related Topics 广度优先搜索 字符串 
// 👍 249 👎 0

package leetcode.editor.cn;
public class KSimilarStrings {
    public static void main(String[] args) {
        Solution solution = new KSimilarStrings().new Solution();
        System.out.println(solution.kSimilarity("abac","baca"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int result = Integer.MAX_VALUE;
        public int kSimilarity(String s1, String s2) {
            return execute(s1.toCharArray(), s2.toCharArray(), 0, 0);
        }

        public int execute(char[] sc1, char[] sc2, int start, int current) {
            if (current >= result) return result; // 如果交换次数已经超过"目前最小交换次数result"，终止递归
            if (start == sc1.length - 1) return result = Math.min(current, result);

            for (int i = start; i < sc1.length; i++) {
                if (sc1[i] != sc2[i]) {
                    for (int j = i + 1; j < sc2.length; j++) {
                        if (sc2[j] == sc1[i] && sc2[j] != sc1[j]) {
                            swap(sc2, i, j); // 交换
                            execute(sc1, sc2, i + 1, current + 1);
                            swap(sc2, i, j); // 回溯
                            //if (sc2[i] == sc1[j]) break; // 如果sc1和sc2的i位于j位互为相等，那么就是最优交换
                        }
                    }
                    return result;
                }
            }
            return result = Math.min(current, result);
        }

        public void swap(char[] sc, int i, int j){
            char temp = sc[i];
            sc[i] = sc[j];
            sc[j] = temp;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}