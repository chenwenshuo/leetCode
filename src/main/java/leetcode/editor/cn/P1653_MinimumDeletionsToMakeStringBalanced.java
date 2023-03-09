//给你一个字符串 s ，它仅包含字符 'a' 和 'b' 。 
//
// 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' 
//，此时认为 s 是 平衡 的。 
//
// 请你返回使 s 平衡 的 最少 删除次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aababbab"
//输出：2
//解释：你可以选择以下任意一种方案：
//下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
//下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
// 
//
// 示例 2： 
//
// 
//输入：s = "bbaaaaabb"
//输出：2
//解释：唯一的最优解是删除最前面两个字符。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 要么是 'a' 要么是 'b' 。 
// 
//
// Related Topics 栈 字符串 动态规划 👍 88 👎 0


package leetcode.editor.cn;

/**
 * 使字符串平衡的最少删除次数
 *
 * @author chenws
 * @date 2023-03-06 11:23:43
 */
public class P1653_MinimumDeletionsToMakeStringBalanced {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1653_MinimumDeletionsToMakeStringBalanced().new Solution();
        System.out.println(solution.minimumDeletions("aababbab"));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         *
         */
        public int minimumDeletions(String s) {
            int length = s.length();
            int[] dba = new int[length];
            int[] dbb = new int[length];
            char[] chars = s.toCharArray();
            dba[0] = chars[0] == 'a' ? 1 : 0;
            dbb[0] = 1;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == 'a') {
                    dba[i] = dba[i - 1] + 1;
                    dbb[i] = dbb[i - 1];
                } else {
                    dba[i] = dba[i - 1];
                    dbb[i] = Math.max(dba[i - 1], dbb[i - 1] + 1);
                }
            }

            return length - Math.max(dba[length - 1], dbb[length - 1]);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
