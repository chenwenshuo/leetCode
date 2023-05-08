//给你一个正整数数组 nums 。 
//
// 同时给你一个长度为 m 的整数数组 queries 。第 i 个查询中，你需要将 nums 中所有元素变成 queries[i] 。你可以执行以下操作 任
//意 次： 
//
// 
// 将数组里一个元素 增大 或者 减小 1 。 
// 
//
// 请你返回一个长度为 m 的数组 answer ，其中 answer[i]是将 nums 中所有元素变成 queries[i] 的 最少 操作次数。 
//
// 注意，每次查询后，数组变回最开始的值。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,1,6,8], queries = [1,5]
//输出：[14,10]
//解释：第一个查询，我们可以执行以下操作：
//- 将 nums[0] 减小 2 次，nums = [1,1,6,8] 。
//- 将 nums[2] 减小 5 次，nums = [1,1,1,8] 。
//- 将 nums[3] 减小 7 次，nums = [1,1,1,1] 。
//第一个查询的总操作次数为 2 + 5 + 7 = 14 。
//第二个查询，我们可以执行以下操作：
//- 将 nums[0] 增大 2 次，nums = [5,1,6,8] 。
//- 将 nums[1] 增大 4 次，nums = [5,5,6,8] 。
//- 将 nums[2] 减小 1 次，nums = [5,5,5,8] 。
//- 将 nums[3] 减小 3 次，nums = [5,5,5,5] 。
//第二个查询的总操作次数为 2 + 4 + 1 + 3 = 10 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,9,6,3], queries = [10]
//输出：[20]
//解释：我们可以将数组中所有元素都增大到 10 ，总操作次数为 8 + 1 + 4 + 7 = 20 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// m == queries.length 
// 1 <= n, m <= 10⁵ 
// 1 <= nums[i], queries[i] <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 前缀和 排序 👍 20 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使数组元素全部相等的最少操作次数
 * @author chenws
 * @date 2023-04-13 15:03:50
 */
public class P2602_MinimumOperationsToMakeAllArrayElementsEqual{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P2602_MinimumOperationsToMakeAllArrayElementsEqual().new Solution();
	/*	/[47,50,97,58,87,72,41,63,41,51,17,21,7,100,69,66,79,92,84,9,57,26,26,28,83,38]
[50,84,76,41,64,82,20,22,64,7,38,92,39,28,22,3,41,46,47,50,88,51,9,49,38,67,26,65,89,27,71,25,77,72,65,41,84,68,51,26,84,24,79,41,96,83,92,9,93,84,35,70,74,79,37,38,26,26,41,26]
*/
		System.out.println(solution.minOperations(new int[]{47,50,97,58,87,72,41,63,41,51,17,21,7,100,69,66,79,92,84,9,57,26,26,28,83,38},new int[]{50}));
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

		public List<Long> minOperations(int[] nums, int[] queries) {
			Arrays.sort(nums);
			int n = nums.length;
			long[] sum = new long[n + 1]; // 前缀和
			for (int i = 0; i < n; ++i) {
				sum[i + 1] = sum[i] + nums[i];
			}

			ArrayList<Long> ans = new ArrayList<Long>(queries.length);
			for (int q : queries) {
				int j = lowerBound(nums, q)+1;
				long left = Math.abs((long) q * j - sum[j]); // 蓝色面积
				long right = Math.abs(sum[n] - sum[j] - (long) q * (n - j)); // 绿色面积
				ans.add(left + right);
			}
			return ans;
		}

		//找下标
		private int lowerBound(int[] nums, int q) {
			int l = 0, r = nums.length-1;
			int ans= 0;
			if (nums[r]<=q)
				return r;
			if (nums[l]>=q)
				return l;
			while (l<=r){
				int mid = (l+r)>>1;
				if (nums[mid]==q||(nums[mid]<q&&nums[mid+1]>=q)){
					ans = mid;
					return ans;
				}else if (nums[mid+1]<q){
					l=mid+1;
				}else {
					r=mid -1;
				}
			}
			return ans;
		}

	}


//leetcode submit region end(Prohibit modification and deletion)

}
