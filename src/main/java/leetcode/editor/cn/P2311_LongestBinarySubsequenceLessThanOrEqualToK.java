//给你一个二进制字符串 s 和一个正整数 k 。 
//
// 请你返回 s 的 最长 子序列的长度，且该子序列对应的 二进制 数字小于等于 k 。 
//
// 注意： 
//
// 
// 子序列可以有 前导 0 。 
// 空字符串视为 0 。 
// 子序列 是指从一个字符串中删除零个或者多个字符后，不改变顺序得到的剩余字符序列。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1001010", k = 5
//输出：5
//解释：s 中小于等于 5 的最长子序列是 "00010" ，对应的十进制数字是 2 。
//注意 "00100" 和 "00101" 也是可行的最长子序列，十进制分别对应 4 和 5 。
//最长子序列的长度为 5 ，所以返回 5 。
// 
//
// 示例 2： 
//
// 
//输入：s = "00101001", k = 1
//输出：6
//解释："000001" 是 s 中小于等于 1 的最长子序列，对应的十进制数字是 1 。
//最长子序列的长度为 6 ，所以返回 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s[i] 要么是 '0' ，要么是 '1' 。 
// 1 <= k <= 10⁹ 
// 
//
// Related Topics 贪心 记忆化搜索 字符串 动态规划 👍 57 👎 0


package leetcode.editor.cn;

/**
 * 小于等于 K 的最长二进制子序列
 *
 * @author chenws
 * @date 2025-06-26 17:22:14
 */
public class P2311_LongestBinarySubsequenceLessThanOrEqualToK {
    public static void main(String[] args) {
        //测试代码
       // Solution solution = new P2311_LongestBinarySubsequenceLessThanOrEqualToK().new Solution();
        int num = 3;
        System.out.println(num==num-1);
      //  System.out.println(Math.log(93951055) / Math.log(2) + 1);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubsequence(String s, int k) {

            int ans = s.length();
            int b = (int) ((int) Math.log(k) / Math.log(2) + 1);
            int t= Integer.MAX_VALUE;

            String tem = s;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    if (s.length() - i - 1 > b) {
                        ans--;
                        tem = tem.replaceFirst("1", "");
                        continue;
                    }
                    if (t<=k){
                        return ans;
                    }
                    t = Integer.parseInt(tem, 2);
                    if (t > k) {
                        ans--;
                        tem = tem.replaceFirst("1", "");
                    }
                }
            }

            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
