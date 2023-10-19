//给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,6,5,1,8]
//输出：18
//解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。 
//
// 示例 2： 
//
// 输入：nums = [4]
//输出：0
//解释：4 不能被 3 整除，所以无法选出数字，返回 0。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,4]
//输出：12
//解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 4 * 10^4 
// 1 <= nums[i] <= 10^4 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 252 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 可被三整除的最大和
 *
 * @author chenws
 * @date 2023-06-19 10:51:11
 */
public class P1262_GreatestSumDivisibleByThree {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1262_GreatestSumDivisibleByThree().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxSumDivThree(int[] nums) {
            int n = nums.length;
            var dp = new int[n][3];
					for (int i = 0; i < n; i++) {
						Arrays.fill(dp[i], -1);
					}
            return dfs(dp, nums, n - 1, 0);
        }

        private int dfs(int[][] dp, int[] nums, int i, int j) {
					if (i < 0) {
						return j == 0 ? 0 : Integer.MIN_VALUE;
					}
					if (dp[i][j] != -1) {
						return dp[i][j];
					}
            return dp[i][j] = Math.max(dfs(dp, nums, i - 1, j),
                dfs(dp, nums, i - 1, (j + nums[i]) % 3) + nums[i]);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
