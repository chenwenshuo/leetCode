//给你 3 个正整数 zero ，one 和 limit 。 
//
// 一个 二进制数组 arr 如果满足以下条件，那么我们称它是 稳定的 ： 
//
// 
// 0 在 arr 中出现次数 恰好 为 zero 。 
// 1 在 arr 中出现次数 恰好 为 one 。 
// arr 中每个长度超过 limit 的 子数组 都 同时 包含 0 和 1 。 
// 
//
// 请你返回 稳定 二进制数组的 总 数目。 
//
// 由于答案可能很大，将它对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 
// 输入：zero = 1, one = 1, limit = 2 
// 
//
// 输出：2 
//
// 解释： 
//
// 两个稳定的二进制数组为 [1,0] 和 [0,1] ，两个数组都有一个 0 和一个 1 ，且没有子数组长度大于 2 。 
//
// 示例 2： 
//
// 
// 输入：zero = 1, one = 2, limit = 1 
// 
//
// 输出：1 
//
// 解释： 
//
// 唯一稳定的二进制数组是 [1,0,1] 。 
//
// 二进制数组 [1,1,0] 和 [0,1,1] 都有长度为 2 且元素全都相同的子数组，所以它们不稳定。 
//
// 示例 3： 
//
// 
// 输入：zero = 3, one = 3, limit = 2 
// 
//
// 输出：14 
//
// 解释： 
//
// 所有稳定的二进制数组包括 [0,0,1,0,1,1] ，[0,0,1,1,0,1] ，[0,1,0,0,1,1] ，[0,1,0,1,0,1] ，[0,1
//,0,1,1,0] ，[0,1,1,0,0,1] ，[0,1,1,0,1,0] ，[1,0,0,1,0,1] ，[1,0,0,1,1,0] ，[1,0,1,0,
//0,1] ，[1,0,1,0,1,0] ，[1,0,1,1,0,0] ，[1,1,0,0,1,0] 和 [1,1,0,1,0,0] 。 
//
// 
//
// 提示： 
//
// 
// 1 <= zero, one, limit <= 1000 
// 
//
// Related Topics 动态规划 前缀和 👍 27 👎 0


package leetcode.editor.cn;

/**
 * 找出所有稳定的二进制数组 II
 * @author chenws
 * @date 2024-08-07 15:20:00
 */
public class P3130_FindAllPossibleStableBinaryArraysIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P3130_FindAllPossibleStableBinaryArraysIi().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
		int mod = 1000000007;
		int[][][] dp = new int[zero + 1][one + 1][2];
		dp[0][0][0] = 1;
		for (int i = 0; i <= zero; i++) {
			for (int j = 0; j <= one; j++) {
				for (int k = 0; k < 2; k++) {
					if (dp[i][j][k] == 0) {
						continue;
					}
					if (i + 1 <= zero) {
						dp[i + 1][j][k] = (dp[i + 1][j][k] + dp[i][j][k]) % mod;
					}
					if (j + 1 <= one) {
						dp[i][j + 1][k ^ 1] = (dp[i][j + 1][k ^ 1] + dp[i][j][k]) % mod;
					}
					if (i + j + 1 <= limit) {
						dp[i][j][k] = (dp[i][j][k] + dp[i][j][k]) % mod;
					}
				}
			}
		}

		return 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
