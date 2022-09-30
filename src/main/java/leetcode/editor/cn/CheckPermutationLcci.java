package leetcode.editor.cn;

//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
//
// Related Topics 哈希表 字符串 排序 👍 103 👎 0

import java.util.Arrays;

public class CheckPermutationLcci{
         public static void main(String[] args) {
            Solution solution = new CheckPermutationLcci().new Solution();
             System.out.println(solution.CheckPermutation("abc","cba"));
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);

        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars1);

         s1 = new String(chars);
         s2=new String(chars1);

        return s1.equals(s2);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
