//给你一个整数数组 nums ，返回全部为 0 的 子数组 数目。 
//
// 子数组 是一个数组中一段连续非空元素组成的序列。 
//
// 
//
// 示例 1：
//子数组 [0] 出现了 5 次。
//子数组 [0,0] 出现了 3 次。
//子数组 [0,0,0] 出现了 1 次。
//不存在长度大于 3 的全 0 子数组，所以我们返回 9 。
// 
//
// 示例 3： 
//
// 输入：nums = [2,10,2019]
//
// 输入：nums = [1,3,0,0,2,0,0,4]
//输出：6
//解释：
//子数组 [0] 出现了 4 次。
//子数组 [0,0] 出现了 2 次。
//不存在长度大于 2 的全 0 子数组，所以我们返回 6 。
//
// 示例 2：
//
// 输入：nums = [0,0,0,2,0,0]
//输出：9
//解释：
//输出：0
//解释：没有全 0 子数组，所以我们返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 数学 👍 40 👎 0


package leetcode.editor.cn;

/**
 * 全 0 子数组的数目
 * @author chenws
 * @date 2025-08-19 16:59:12
 */
public class P2348_NumberOfZeroFilledSubarrays{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P2348_NumberOfZeroFilledSubarrays().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
		long a = 0;
		for (int num : nums) {
			if (num==0){
				a++;
				ans+=a;
				continue;
			}
			a=0;
		}
		if (a>0){
			ans+=a;
		}

		return  ans;
    }
	//[0,0,0,2,0,0]
}
//leetcode submit region end(Prohibit modification and deletion)

}
