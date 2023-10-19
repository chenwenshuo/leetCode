//给你一个下标从 0 开始的整数数组 nums 和一个整数 x 。 
//
// 请你找到数组中下标距离至少为 x 的两个元素的 差值绝对值 的 最小值 。 
//
// 换言之，请你找到两个下标 i 和 j ，满足 abs(i - j) >= x 且 abs(nums[i] - nums[j]) 的值最小。 
//
// 请你返回一个整数，表示下标距离至少为 x 的两个元素之间的差值绝对值的 最小值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,4], x = 2
//输出：0
//解释：我们选择 nums[0] = 4 和 nums[3] = 4 。
//它们下标距离满足至少为 2 ，差值绝对值为最小值 0 。
//0 是最优解。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,3,2,10,15], x = 1
//输出：1
//解释：我们选择 nums[1] = 3 和 nums[2] = 2 。
//它们下标距离满足至少为 1 ，差值绝对值为最小值 1 。
//1 是最优解。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,4], x = 3
//输出：3
//解释：我们选择 nums[0] = 1 和 nums[3] = 4 。
//它们下标距离满足至少为 3 ，差值绝对值为最小值 3 。
//3 是最优解。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 0 <= x < nums.length 
// 
//
// 👍 9 👎 0


package leetcode.editor.cn;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * 限制条件下元素之间的最小绝对差
 * @author chenws
 * @date 2023-08-14 11:53:36
 */
public class P2817_MinimumAbsoluteDifferenceBetweenElementsWithConstraint{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P2817_MinimumAbsoluteDifferenceBetweenElementsWithConstraint().new Solution();
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
			TreeSet<Integer> treeSet = new TreeSet<>();
			int ans = Integer.MAX_VALUE;
			treeSet.add(Integer.MAX_VALUE);
			treeSet.add(Integer.MIN_VALUE);
			for (int i = x; i < nums.size(); i++) {
				treeSet.add(nums.get(i-x));
				Integer a = nums.get(i);
				Integer ceiling = treeSet.ceiling(a);
				Integer floor = treeSet.floor(a);
				ans = Math.min(ans,Math.min(Math.abs(a-ceiling),Math.abs(a-floor)));
			}
			return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
