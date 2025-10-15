//给你两个 从小到大排好序 且下标从 0 开始的整数数组 nums1 和 nums2 以及一个整数 k ，请你返回第 k （从 1 开始编号）小的 nums1
//[i] * nums2[j] 的乘积，其中 0 <= i < nums1.length 且 0 <= j < nums2.length 。
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [2,5], nums2 = [3,4], k = 2
//输出：8
//解释：第 2 小的乘积计算如下：
//- nums1[0] * nums2[0] = 2 * 3 = 6
//- nums1[0] * nums2[1] = 2 * 4 = 8
//第 2 小的乘积为 8 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6
//输出：0
//解释：第 6 小的乘积计算如下：
//- nums1[0] * nums2[1] = (-4) * 4 = -16
//- nums1[0] * nums2[0] = (-4) * 2 = -8
//- nums1[1] * nums2[1] = (-2) * 4 = -8
//- nums1[1] * nums2[0] = (-2) * 2 = -4
//- nums1[2] * nums2[0] = 0 * 2 = 0
//- nums1[2] * nums2[1] = 0 * 4 = 0
//第 6 小的乘积为 0 。
// 
//
// 示例 3： 
//
// 输入：nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3
//输出：-6
//解释：第 3 小的乘积计算如下：
//- nums1[0] * nums2[4] = (-2) * 5 = -10
//- nums1[0] * nums2[3] = (-2) * 4 = -8
//- nums1[4] * nums2[0] = 2 * (-3) = -6
//第 3 小的乘积为 -6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 5 * 10⁴ 
// -10⁵ <= nums1[i], nums2[j] <= 10⁵ 
// 1 <= k <= nums1.length * nums2.length 
// nums1 和 nums2 都是从小到大排好序的。 
// 
//
// Related Topics 数组 二分查找 👍 67 👎 0


package leetcode.editor.cn;

/**
 * 两个有序数组的第 K 小乘积
 * @author chenws
 * @date 2025-06-25 11:21:23
 */
public class P2040_KthSmallestProductOfTwoSortedArrays{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P2040_KthSmallestProductOfTwoSortedArrays().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	int f(int[] nums2, long x1, long v) {
		int n2 = nums2.length;
		int left = 0, right = n2 - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			long prod = (long) nums2[mid] * x1;
			if ((x1 >= 0 && prod <= v) || (x1 < 0 && prod > v)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		if (x1 >= 0) {
			return left;
		} else {
			return n2 - left;
		}
	}

	public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
		int n1 = nums1.length;
		long left = -10000000000L, right = 10000000000L;
		while (left <= right) {
			long mid = (left + right) / 2;
			long count = 0;
            for (int j : nums1) {
                count += f(nums2, j, mid);
            }
			if (count < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
}

}
//leetcode submit region end(Prohibit modification and deletion)


