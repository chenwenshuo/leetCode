//给你一个字符串 s，最多 可以从中删除一个字符。 
//
// 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aba"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "abca"
//输出：true
//解释：你可以删除字符 'c' 。
// 
//
// 示例 3： 
//
// 
//输入：s = "abc"
//输出：false 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
//
// Related Topics 贪心 双指针 字符串 👍 601 👎 0


package leetcode.editor.cn;

/**
 * 验证回文串 II
 * @author chenws
 * @date 2023-08-18 16:23:22
 */
public class P680_ValidPalindromeIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P680_ValidPalindromeIi().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
			s = s.toLowerCase();
			int l = 0;
			int r = s.length() - 1;
			while (l < r) {
				char c = s.charAt(l);
				char c1 = s.charAt(r);
				if (c != c1) {
					//l&&r
					if (check(l+1,r,s)||check(l,r-1,s)){
						return true;
					}
					return false;

				}
				l++;
				r--;
			}

			return true;

    }

	private boolean check(int l, int r, String s) {
			if (l>=r){
				return true;
			}
		while (l < r) {
			char c = s.charAt(l);
			char c1 = s.charAt(r);
			if (c != c1) {
				return false;

			}
			l++;
			r--;
		}
			return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
