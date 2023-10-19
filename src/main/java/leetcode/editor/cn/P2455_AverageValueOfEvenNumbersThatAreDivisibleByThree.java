//给你一个由正整数组成的整数数组 nums ，返回其中可被 3 整除的所有偶数的平均值。 
//
// 注意：n 个元素的平均值等于 n 个元素 求和 再除以 n ，结果 向下取整 到最接近的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,6,10,12,15]
//输出：9
//解释：6 和 12 是可以被 3 整除的偶数。(6 + 12) / 2 = 9 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,7,10]
//输出：0
//解释：不存在满足题目要求的整数，所以返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 数学 👍 38 👎 0


package leetcode.editor.cn;

/**
 * 可被三整除的偶数的平均值
 * @author chenws
 * @date 2023-05-29 15:26:05
 */
public class P2455_AverageValueOfEvenNumbersThatAreDivisibleByThree{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P2455_AverageValueOfEvenNumbersThatAreDivisibleByThree().new Solution();
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int averageValue(int[] nums) {
			int ans=0;
			int tem =0;
			for (int num : nums) {
				if (num%6==0){
					ans+=num;
					tem++;
				}
			}

			return tem==0?tem:ans/tem;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
