//给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。 
//
// 「超赞子字符串」需满足满足下述两个条件： 
//
// 
// 该字符串是 s 的一个非空子字符串 
// 进行任意次数的字符交换后，该字符串可以变成一个回文字符串 
// 
//
// 
//
// 示例 1： 
//
// 输入：s = "3242415"
//输出：5
//解释："24241" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "24142"
// 
//
// 示例 2： 
//
// 输入：s = "12345678"
//输出：1
// 
//
// 示例 3： 
//
// 输入：s = "213123"
//输出：6
//解释："213123" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "231132"
// 
//
// 示例 4： 
//
// 输入：s = "00"
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s 仅由数字组成 
// 
//
// Related Topics 位运算 哈希表 字符串 👍 128 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出最长的超赞子字符串
 * @author chenws
 * @date 2024-05-20 17:46:36
 */
public class P1542_FindLongestAwesomeSubstring{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1542_FindLongestAwesomeSubstring().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestAwesome(String s) {
		int ans =0;
		int length = s.length();
		Set<Character> set = new HashSet<>();
		Character[] characters = new Character[10];

		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
