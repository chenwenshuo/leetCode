//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// 
//
// 
// 注意：本题与主站 567 题相同： https://leetcode-cn.com/problems/permutation-in-string/ 
//
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 101 👎 0


package leetcode.editor.cn;

/**
 * 字符串的排列
 * @author chenws
 * @date 2023-08-16 17:55:57
 */
public class MPnaiL{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new MPnaiL().new Solution();
		System.out.println(solution.checkInclusion("ky","ainwkckifykxlribaypk"));
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
			int[] tem = new int[26];
			int length = s1.length();

			for (int i = 0; i < length; i++) {
				tem[s2.charAt(i)-'a'] ++;
			}
			boolean ans =check(tem,s1);
			if (ans){
				return ans;
			}
			for (int i = 0,j = length; j < s2.length(); i++,j++) {
				tem[s2.charAt(i)-'a'] --;
				tem[s2.charAt(j)-'a'] ++;
			  ans =check(tem,s1);
				if (ans){
					return ans;
				}
			}
			return false;
    }

		private boolean check(int[] tem, String s1) {
			int[] c= tem.clone();
			for (int i = 0; i < s1.length(); i++) {
				int y = s1.charAt(i)-'a';
				if (c[y]>0){
					c[y]--;
					continue;
				}
				return false;
			}
			return true;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

