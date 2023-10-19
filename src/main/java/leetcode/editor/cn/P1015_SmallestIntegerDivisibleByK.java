//给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。 
//
// 返回 n 的长度。如果不存在这样的 n ，就返回-1。 
//
// 注意： n 不符合 64 位带符号整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 1
//输出：1
//解释：最小的答案是 n = 1，其长度为 1。 
//
// 示例 2： 
//
// 
//输入：k = 2
//输出：-1
//解释：不存在可被 2 整除的正整数 n 。 
//
// 示例 3： 
//
// 
//输入：k = 3
//输出：3
//解释：最小的答案是 n = 111，其长度为 3。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 10⁵ 
// 
//
// Related Topics 哈希表 数学 👍 124 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 可被 K 整除的最小整数
 * @author chenws
 * @date 2023-05-10 15:56:16
 */
public class P1015_SmallestIntegerDivisibleByK{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P1015_SmallestIntegerDivisibleByK().new Solution();
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestRepunitDivByK(int k) {

			Set<Integer> seen = new HashSet<>();
			int x = 1 % k;
			while (x > 0 && seen.add(x)) {
				x = (x * 10 + 1) % k;
			}
			return x > 0 ? -1 : seen.size() + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
