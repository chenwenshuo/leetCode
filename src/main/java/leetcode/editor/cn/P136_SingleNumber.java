//给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。 
//
// 
// 
// 
// 
// 
//
// 示例 1 ： 
//
// 
//输入：nums = [2,2,1]
//输出：1
// 
//
// 示例 2 ： 
//
// 
//输入：nums = [4,1,2,1,2]
//输出：4
// 
//
// 示例 3 ： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 除了某个元素只出现一次以外，其余每个元素均出现两次。 
// 
//
// Related Topics 位运算 数组 👍 2750 👎 0


package leetcode.editor.cn;

/**
 * 只出现一次的数字
 * @author chenws
 * @date 2023-02-20 15:48:59
 */
public class P136_SingleNumber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P136_SingleNumber().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
			int ans = nums[0];
			for (int i = 1; i < nums.length; i++) {
				ans^=nums[i];
			}
			return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
