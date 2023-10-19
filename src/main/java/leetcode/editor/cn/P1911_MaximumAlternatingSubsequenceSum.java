//一个下标从 0 开始的数组的 交替和 定义为 偶数 下标处元素之 和 减去 奇数 下标处元素之 和 。 
//
// 
// 比方说，数组 [4,2,5,3] 的交替和为 (4 + 5) - (2 + 3) = 4 。 
// 
//
// 给你一个数组 nums ，请你返回 nums 中任意子序列的 最大交替和 （子序列的下标 重新 从 0 开始编号）。 
//
// 
// 
//
// 一个数组的 子序列 是从原数组中删除一些元素后（也可能一个也不删除）剩余元素不改变顺序组成的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4
//] 的一个子序列（加粗元素），但是 [2,4,2] 不是。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,2,5,3]
//输出：7
//解释：最优子序列为 [4,2,5] ，交替和为 (4 + 5) - 2 = 7 。
// 
//
// 示例 2： 
//
// 输入：nums = [5,6,7,8]
//输出：8
//解释：最优子序列为 [8] ，交替和为 8 。
// 
//
// 示例 3： 
//
// 输入：nums = [6,2,1,2,4,5]
//输出：10
//解释：最优子序列为 [6,1,5] ，交替和为 (6 + 5) - 1 = 10 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 动态规划 👍 112 👎 0


package leetcode.editor.cn;

/**
 * 最大子序列交替和
 * @author chenws
 * @date 2023-07-11 13:56:26
 */
public class P1911_MaximumAlternatingSubsequenceSum{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P1911_MaximumAlternatingSubsequenceSum().new Solution();
		System.out.println(solution.maxAlternatingSum(new int[]{4,2,3,5}));
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

		/**
		 * 动态规划
		 * 偶数下标处的最大交替和为 even，奇数下标处的最大交替和为 odd
		 * 1. 当 i 为偶数时，nums[i] 可以选择不选，那么 even[i] = even[i-1]，也可以选择选，那么 even[i] = odd[i-1] + nums[i]
		 * 2. 当 i 为奇数时，nums[i] 可以选择不选，那么 odd[i] = odd[i-1]，也可以选择选，那么 odd[i] = even[i-1] - nums[i]
		 *
		 * @param nums
		 * @return
		 */
		public long maxAlternatingSum(int[] nums) {

			long p=nums[0];
			long ans=p;
			for (int i = 1; i < nums.length; i++) {
				if (nums[i]>p){
					ans = ans + nums[i]-p;
					p = nums[i];
				}else{
					p = nums[i];
				}

			}

			return ans;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
