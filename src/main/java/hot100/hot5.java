package hot100;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * @Author: chenwenshuo
 * @Date: 2022/09/22/19:12
 */
public class hot5 {
    public static void main(String[] args) {
        hot5 hot5 = new hot5();
        String s = hot5.longestPalindrome("bb");
        System.out.println(s);
    }
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        boolean[][] dp=new boolean[length][length];
        for (int i = 0; i < chars.length; i++) {
            dp[i][i]=true;
        }
        int len=1;
        int begin=0;
        for (int L = 2; L <=length; L++) {
            for (int i = 0; i < chars.length; i++) {
                int j=i+L-1;
                if(j>=chars.length) break;
                if (chars[i]!=chars[j]){
                    dp[i][j]=false;
                }else {
                    if (j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }

                if (dp[i][j]&&j-i+1>len){
                    begin=i;
                    len=j-i+1;
                }

            }

        }

        return s.substring(begin,begin+len);

    }
}
