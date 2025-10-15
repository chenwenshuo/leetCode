//给你一个整数数组 nums 。数组 nums 的 唯一性数组 是一个按元素从小到大排序的数组，包含了 nums 的所有非空子数组中不同元素的个数。 
//
// 换句话说，这是由所有 0 <= i <= j < nums.length 的 distinct(nums[i..j]) 组成的递增数组。 
//
// 其中，distinct(nums[i..j]) 表示从下标 i 到下标 j 的子数组中不同元素的数量。 
//
// 返回 nums 唯一性数组 的 中位数 。 
//
// 注意，数组的 中位数 定义为有序数组的中间元素。如果有两个中间元素，则取值较小的那个。
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3] 
// 
//
// 输出：1 
//
// 解释： 
//
// nums 的唯一性数组为 [distinct(nums[0..0]), distinct(nums[1..1]), distinct(nums[2..2]
//), distinct(nums[0..1]), distinct(nums[1..2]), distinct(nums[0..2])]，即 [1, 1, 1,
// 2, 2, 3] 。唯一性数组的中位数为 1 ，因此答案是 1 。 
//
// 示例 2： 
//
// 
// 输入：nums = [3,4,3,4,5] 
// 
//
// 输出：2 
//
// 解释： 
//
// nums 的唯一性数组为 [1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3] 。唯一性数组的中位数为 2 ，因此答
//案是 2 。 
//
// 示例 3： 
//
// 
// 输入：nums = [4,3,5,4] 
// 
//
// 输出：2 
//
// 解释： 
//
// nums 的唯一性数组为 [1, 1, 1, 1, 2, 2, 2, 3, 3, 3] 。唯一性数组的中位数为 2 ，因此答案是 2 。 
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
// Related Topics 数组 哈希表 二分查找 滑动窗口 👍 31 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 找出唯一性数组的中位数
 * @author chenws
 * @date 2024-08-27 16:28:32
 */
public class P3134_FindTheMedianOfTheUniquenessArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P3134_FindTheMedianOfTheUniquenessArray().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int medianOfUniquenessArray(int[] nums) {
		int n = nums.length;
		long k = ((long) n * (n + 1) / 2 + 1) / 2;
		int left = 0;
		int right = n;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (check(nums, mid, k)) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return right;
	}

	private boolean check(int[] nums, int upper, long k) {
		long cnt = 0;
		int l = 0;
		HashMap<Integer, Integer> freq = new HashMap<>();
		for (int r = 0; r < nums.length; r++) {
			freq.merge(nums[r], 1, Integer::sum); // 移入右端点
			while (freq.size() > upper) { // 窗口内元素过多
				int out = nums[l++];
				if (freq.merge(out, -1, Integer::sum) == 0) { // 移出左端点
					freq.remove(out);
				}
			}
			cnt += r - l + 1; // 右端点固定为 r 时，有 r-l+1 个合法左端点
			if (cnt >= k) {
				return true;
			}
		}
		return false;
	}
}


//leetcode submit region end(Prohibit modification and deletion)

}
