//给你一个二进制数组 nums ，你需要从中删掉一个元素。 
//
// 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。 
//
// 如果不存在这样的子数组，请返回 0 。 
//
// 
//
// 提示 1： 
//
// 
//输入：nums = [1,1,0,1]
//输出：3
//解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1,1,0,1,1,0,1]
//输出：5
//解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1]
//输出：2
//解释：你必须要删除一个元素。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 要么是 0 要么是 1 。 
// 
//
// Related Topics 数组 动态规划 滑动窗口 👍 115 👎 0


package leetcode.editor.cn;

/**
 * 删掉一个元素以后全为 1 的最长子数组
 *
 * @author chenws
 * @date 2023-12-18 14:06:18
 */
public class P1493_LongestSubarrayOf1sAfterDeletingOneElement {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1493_LongestSubarrayOf1sAfterDeletingOneElement().new Solution();
        // System.out.println(solution.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));//1,1,0,0,1,1,1,0,1
        //System.out.println(solution.longestSubarray(new int[]{1,1,0,1}));
        System.out.println(solution.longestSubarray(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums) {
            int ans = 0;
            int p0 = 0, p1 = 0;
            for (int num : nums) {
                if (num == 0) {
                    p1 = p0;
                    p0 = 0;
                } else {
                    ++p0;
                    ++p1;
                }
                ans = Math.max(ans, p1);
            }
            if (ans == nums.length) {
                --ans;
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
