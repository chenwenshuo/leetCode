//如果一个数列由至少两个元素组成，且每两个连续元素之间的差值都相同，那么这个序列就是 等差数列 。更正式地，数列 s 是等差数列，只需要满足：对于每个有效的 
//i ， s[i+1] - s[i] == s[1] - s[0] 都成立。 
//
// 例如，下面这些都是 等差数列 ： 
//
// 1, 3, 5, 7, 9
//7, 7, 7, 7
//3, -1, -5, -9 
//
// 下面的数列 不是等差数列 ： 
//
// 1, 1, 2, 5, 7 
//
// 给你一个由 n 个整数组成的数组 nums，和两个由 m 个整数组成的数组 l 和 r，后两个数组表示 m 组范围查询，其中第 i 个查询对应范围 [l[
//i], r[i]] 。所有数组的下标都是 从 0 开始 的。 
//
// 返回 boolean 元素构成的答案列表 answer 。如果子数组 nums[l[i]], nums[l[i]+1], ... , nums[r[i]]
// 可以 重新排列 形成 等差数列 ，answer[i] 的值就是 true；否则answer[i] 的值就是 false 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
//输出：[true,false,true]
//解释：
//第 0 个查询，对应子数组 [4,6,5] 。可以重新排列为等差数列 [6,5,4] 。
//第 1 个查询，对应子数组 [4,6,5,9] 。无法重新排列形成等差数列。
//第 2 个查询，对应子数组 [5,9,3,7] 。可以重新排列为等差数列 [3,5,7,9] 。 
//
// 示例 2： 
//
// 输入：nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4
//,4,9,7,9,10]
//输出：[false,true,false,false,true,true]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// m == l.length 
// m == r.length 
// 2 <= n <= 500 
// 1 <= m <= 500 
// 0 <= l[i] < r[i] < n 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 排序 👍 67 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 等差子数组
 * @author chenws
 * @date 2023-03-23 17:57:23
 */
public class P1630_ArithmeticSubarrays{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1630_ArithmeticSubarrays().new Solution();

		 List<Boolean> list = solution.checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5});
		 System.out.println(list);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

			List<Boolean> list = new ArrayList<>(nums.length);
			for (int i = 0; i < l.length; i++) {
				int a= l[i];
				int b = r[i];
				int[] tem = new int[b-a+1];
				boolean f = true;
				System.arraycopy(nums,a,tem,0,tem.length);
				Arrays.sort(tem);
					for (int i1 = 2; i1 < tem.length; i1++) {
						if(tem[i1]-tem[i1-1]!=tem[i1-1]-tem[i1-2]){
							f = false;
							break;
						}
					}
				list.add(f);
			}

			return list;
    }

	/**
	 * 滑动子数组的美丽值 显示英文描述
	 * 通过的用户数902
	 * 尝试过的用户数1988
	 * 用户总通过次数955
	 * 用户总提交次数4075
	 * 题目难度Medium
	 * 给你一个长度为 n 的整数数组 nums ，请你求出每个长度为 k 的子数组的 美丽值 。
	 *
	 * 一个子数组的 美丽值 定义为：如果子数组中第 x 小整数 是 负数 ，那么美丽值为第 x 小的数，否则美丽值为 0 。
	 *
	 * 请你返回一个包含 n - k + 1 个整数的数组，依次 表示数组中从第一个下标开始，每个长度为 k 的子数组的 美丽值 。
	 *
	 * 子数组指的是数组中一段连续 非空 的元素序列。
	 *
	 *
	 *
	 * 示例 1：
	 *
	 * 输入：nums = [1,-1,-3,-2,3], k = 3, x = 2
	 * 输出：[-1,-2,-2]
	 * 解释：总共有 3 个 k = 3 的子数组。
	 * 第一个子数组是 [1, -1, -3] ，第二小的数是负数 -1 。
	 * 第二个子数组是 [-1, -3, -2] ，第二小的数是负数 -2 。
	 * 第三个子数组是 [-3, -2, 3] ，第二小的数是负数 -2 。
	 * 示例 2：
	 *
	 * 输入：nums = [-1,-2,-3,-4,-5], k = 2, x = 2
	 * 输出：[-1,-2,-3,-4]
	 * 解释：总共有 4 个 k = 2 的子数组。
	 * [-1, -2] 中第二小的数是负数 -1 。
	 * [-2, -3] 中第二小的数是负数 -2 。
	 * [-3, -4] 中第二小的数是负数 -3 。
	 * [-4, -5] 中第二小的数是负数 -4 。
	 * 示例 3：
	 *
	 * 输入：nums = [-3,1,2,-3,0,-3], k = 2, x = 1
	 * 输出：[-3,0,-3,-3,-3]
	 * 解释：总共有 5 个 k = 2 的子数组。
	 * [-3, 1] 中最小的数是负数 -3 。
	 * [1, 2] 中最小的数不是负数，所以美丽值为 0 。
	 * [2, -3] 中最小的数是负数 -3 。
	 * [-3, 0] 中最小的数是负数 -3 。
	 * [0, -3] 中最小的数是负数 -3 。
	 *
	 *
	 * 提示：
	 *动态规划
	 * n == nums.length
	 * 1 <= n <= 105
	 * 1 <= k <= n
	 * 1 <= x <= k
	 * -50 <= nums[i] <= 50
	 * @param nums
	 * @param k
	 * @param x
	 * @return
	 */


	public int[] getSubarrayBeauty(int[] nums, int k, int x) {
		int[] res = new int[nums.length-k+1];
		int[] tem = new int[k];
		System.arraycopy(nums,0,tem,0,k);
		Arrays.sort(tem);
		for (int i = 0; i < res.length; i++) {
			if(i!=0){
				int index = Arrays.binarySearch(tem,nums[i-1]);
				tem[index] = nums[i+k-1];
				Arrays.sort(tem);
			}
			if(tem[x-1]<0){
				res[i] = tem[x-1];
			}
		}
		return res;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
