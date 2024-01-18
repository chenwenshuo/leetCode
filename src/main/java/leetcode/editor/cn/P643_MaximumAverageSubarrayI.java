//给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。 
//
// 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。 
//
// 任何误差小于 10⁻⁵ 的答案都将被视为正确答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 示例 2： 
//
// 
//输入：nums = [5], k = 1
//输出：5.00000
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= k <= n <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 滑动窗口 👍 327 👎 0


package leetcode.editor.cn;

/**
 * 子数组最大平均数 I
 *
 * @author chenws
 * @date 2023-12-14 16:56:02
 */
public class P643_MaximumAverageSubarrayI {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P643_MaximumAverageSubarrayI().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            double t = 0;
            double ans = 0;
            for (int i = 0; i < k; i++) {
                t += nums[i];
            }
            ans = t / k;
            for (int i = k, x = 0; i < nums.length; i++, x++) {
                t = t - nums[x] + nums[i];
                ans = Math.max(ans, t / k);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
