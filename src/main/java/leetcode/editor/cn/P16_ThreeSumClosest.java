//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1416 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.sound.midi.Sequence;

/**
 * 最接近的三数之和
 * @author chenws
 * @date 2023-07-07 17:44:13
 */
public class P16_ThreeSumClosest{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P16_ThreeSumClosest().new Solution();
		System.out.println(solution.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5},-2));
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
			Arrays.sort(nums);
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < nums.length; i++) {
				if (i != 0 && nums[i] == nums[i - 1]) {
					continue;
				}
				int target1 = nums[i];
				int two = i + 1;

				for (int j = two; j < nums.length; j++) {
					if (j != two && nums[j] == nums[j - 1]) {
						continue;
					}
					int three = nums.length - 1;
					while (three > j) {
						int s = target1+nums[three]+nums[j];
						if (Math.abs(ans-target)>Math.abs(s-target)){
							ans = s;
						}

						three--;
					}
				}

			}
			return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
