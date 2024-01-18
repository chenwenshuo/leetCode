//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
// 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 
//示例 1：
//
// 
//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// 示例 2： 
//
// 
//输入：nums = [1,5]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1288 👎 0


package leetcode.editor.cn;

/**
 * 戳气球
 * @author chenws
 * @date 2023-10-26 16:56:23
 */
public class P312_BurstBalloons{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P312_BurstBalloons().new Solution();
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCoins(int[] nums) {
			int n = nums.length;
			int[] arr = new int[n+2];
			arr[0] = 1;
			arr[arr.length-1] = 1;
			System.arraycopy(nums, 0, arr, 1, arr.length - 1 - 1);
			int[][] f = new int[n+2][n+2];
			for (int len = 3; len <= n + 2; len++) {
				for (int l = 0; l + len - 1 <= n + 1; l++) {
					int r = l + len - 1;
					for (int k = l + 1; k <= r - 1; k++) {
						f[l][r] = Math.max(f[l][r], f[l][k] + f[k][r] + arr[l] * arr[k] * arr[r]);
					}
				}
			}
			return f[0][n + 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
