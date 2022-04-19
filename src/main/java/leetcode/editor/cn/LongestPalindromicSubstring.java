package leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 5090 👎 0

public class LongestPalindromicSubstring{
         public static void main(String[] args) {
            Solution solution = new LongestPalindromicSubstring().new Solution();
             System.out.println(solution.longestPalindrome("bb"));
         }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * s思路
     *
     * 动态规划
     *
     * 当i+1-->j-1为回文子串时候，i--->j也是回文子串
     *
     * 当i--->j长度为1，2时候 只要满足【i】==[j]即是回文子串
     *
     * 遍历时候从回文子串长度为2开始遍历
     *
     * begin记录开始下标
     *
     * len记录长度
     */
    class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        boolean[][] dp=new boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i]=true;
        }
        int begin=0;
        int len=1;
        for (int L = 2; L <=length ; L++) {
            for (int i = 0; i <length ; i++) {
                int j=L+i-1;
                if (j>=length) break;
                if (chars[j]!=chars[i]){
                    dp[i][j]=false;
                }else {
                    if (j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && j - i + 1 > len) {
                    len = j - i + 1;
                    begin = i;
                }
            }

        }

        return s.substring(begin,begin+len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
