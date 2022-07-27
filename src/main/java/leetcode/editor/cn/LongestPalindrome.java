package leetcode.editor.cn;

//给定一个包含大写字母和小写字母的字符串
// s ，返回 通过这些字母构造成的 最长的回文串 。 
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
//
// 示例 2: 
//
// 
//输入:s = "a"
//输入:1
// 
//
// 示例 3: 
//
// 
//输入:s = "bb"
//输入: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 2000 
// s 只能由小写和/或大写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 字符串 👍 439 👎 0

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome{
         public static void main(String[] args) {
            Solution solution = new LongestPalindrome().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            counter.merge(s.charAt(i), 1, (a, b) -> a + b);
        int res = 0, odd = 0;
        for (Map.Entry<Character, Integer> kv : counter.entrySet()) {

            int count = kv.getValue();
            int rem = count % 2;
            res += count - rem;
            if (rem == 1) odd = 1;
        }
        return res + odd;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
