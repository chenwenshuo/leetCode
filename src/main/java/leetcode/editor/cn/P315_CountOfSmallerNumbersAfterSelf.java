//给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 
//nums[i] 的元素的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,6,1]
//输出：[2,1,1,0] 
//解释：
//5 的右侧有 2 个更小的元素 (2 和 1)
//2 的右侧仅有 1 个更小的元素 (1)
//6 的右侧有 1 个更小的元素 (1)
//1 的右侧有 0 个更小的元素
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-1]
//输出：[0,0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 1027 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

/**
 * 计算右侧小于当前元素的个数
 * @author chenws
 * @date 2023-11-13 17:08:50
 */
public class P315_CountOfSmallerNumbersAfterSelf{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P315_CountOfSmallerNumbersAfterSelf().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> countSmaller(int[] nums) {
			int x = Arrays.stream(nums).max().getAsInt();
			return null;
		}
}
//leetcode submit region end(Prohibit modification and deletion)

}
