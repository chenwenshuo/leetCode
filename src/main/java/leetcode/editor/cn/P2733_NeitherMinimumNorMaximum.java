//给你一个整数数组 nums ，数组由 不同正整数 组成，请你找出并返回数组中 任一 既不是 最小值 也不是 最大值 的数字，如果不存在这样的数字，返回 -1
// 。 
//
// 返回所选整数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,2,1,4]
//输出：2
//解释：在这个示例中，最小值是 1 ，最大值是 4 。因此，2 或 3 都是有效答案。
// 
//
// 示例 2： 
//
// 输入：nums = [1,2]
//输出：-1
//解释：由于不存在既不是最大值也不是最小值的数字，我们无法选出满足题目给定条件的数字。因此，不存在答案，返回 -1 。
// 
//
// 示例 3： 
//
// 输入：nums = [2,1,3]
//输出：2
//解释：2 既不是最小值，也不是最大值，这个示例只有这一个有效答案。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// nums 中的所有数字互不相同 
// 
//
// Related Topics 数组 排序 👍 3 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 既不是最小值也不是最大值
 * @author chenws
 * @date 2023-06-17 16:56:30
 */
public class P2733_NeitherMinimumNorMaximum{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P2733_NeitherMinimumNorMaximum().new Solution();
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNonMinOrMax(int[] nums) {
			int length = nums.length;
			if(length<=2){return -1;}

			int asn =-1;

			Arrays.sort(nums);

			int min =nums[0];
			int max = nums[length-1];

			for (int num : nums) {
				if (num!=max&&num!=min){
					return num;
				}
			}

			return -1;

		}
}
//leetcode submit region end(Prohibit modification and deletion)

}
