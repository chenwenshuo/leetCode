//给你三个整数 a ，b 和 n ，请你返回 (a XOR x) * (b XOR x) 的 最大值 且 x 需要满足 0 <= x < 2ⁿ。 
//
// 由于答案可能会很大，返回它对 109 + 7 取余 后的结果。 
//
// 注意，XOR 是按位异或操作。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 12, b = 5, n = 4
//输出：98
//解释：当 x = 2 时，(a XOR x) = 14 且 (b XOR x) = 7 。所以，(a XOR x) * (b XOR x) = 98 。
//98 是所有满足 0 <= x < 2n 中 (a XOR x) * (b XOR x) 的最大值。
// 
//
// 示例 2： 
//
// 
//输入：a = 6, b = 7 , n = 5
//输出：930
//解释：当 x = 25 时，(a XOR x) = 31 且 (b XOR x) = 30 。所以，(a XOR x) * (b XOR x) = 930 
//。
//930 是所有满足 0 <= x < 2n 中 (a XOR x) * (b XOR x) 的最大值。 
//
// 示例 3： 
//
// 
//输入：a = 1, b = 6, n = 3
//输出：12
//解释： 当 x = 5 时，(a XOR x) = 4 且 (b XOR x) = 3 。所以，(a XOR x) * (b XOR x) = 12 。
//12 是所有满足 0 <= x < 2n 中 (a XOR x) * (b XOR x) 的最大值。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= a, b < 2⁵⁰ 
// 0 <= n <= 50 
// 
//
// Related Topics 贪心 位运算 数学 👍 10 👎 0


package leetcode.editor.cn;

/**
 * 最大异或乘积
 * @author chenws
 * @date 2023-11-22 15:37:14
 */
public class P2939_MaximumXorProduct{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P2939_MaximumXorProduct().new Solution();
		System.out.println(solution.maximumXorProduct(53449611838892L, 712958946092406L, 6));
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumXorProduct(long a, long b, int n) {
			long MOD = (long) (10e9+7);
			double x = 0;
			long t = (long) Math.pow(2,n);
			for (int i = 0; i < t; i++) {
				x = Math.max((a^i)%MOD*(b^i)%MOD%MOD,x);
			}
			return (int) ((int) x%MOD);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
