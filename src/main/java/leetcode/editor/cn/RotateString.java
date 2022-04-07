package leetcode.editor.cn;

//给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。 
//
// s 的 旋转操作 就是将 s 最左边的字符移动到最右边。 
//
// 
// 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", goal = "cdeab"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abcde", goal = "abced"
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, goal.length <= 100 
// s 和 goal 由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 👍 206 👎 0

import org.junit.Test;

public class RotateString{
         public static void main(String[] args) {
            Solution solution = new RotateString().new Solution();
            solution.test();
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean rotateString(String s, String goal) {

        if (s.length()!=goal.length()) return false;

        int length = s.length();
        for (int i = 0; i <s.length(); i++) {
            String substring = s.substring(0, 1);
            String substring1 = s.substring(1, length);
            s=substring1+substring;
            if (s.equals(goal)) return true;

        }
return false;
    }


    /**
     *  a b c a b c d
     *  a b c a b c d
     *
     *  -1 0 0 0 1 2 3
     *
     *
     *
     */
    public void test(){

        String s="abababcb";

        char[] chars = s.toCharArray();
        int length = chars.length;
        int[] next=new int[length];
        next[0]=-1;
        int l=0,t=-1;

        int max = 0;
        int min = 0;

        while (l<length-1){
            if (t==-1||chars[l]==chars[t]){
                ++l;
                ++t;
                next[l]=t;
            }else {
                t=next[t];
            }
        }





    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
