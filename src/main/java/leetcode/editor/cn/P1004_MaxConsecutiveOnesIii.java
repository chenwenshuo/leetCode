//给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释：[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 0 <= k <= nums.length 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 668 👎 0


package leetcode.editor.cn;

/**
 * 最大连续1的个数 III
 *
 * @author chenws
 * @date 2023-12-18 11:21:26
 */
public class P1004_MaxConsecutiveOnesIii {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1004_MaxConsecutiveOnesIii().new Solution();
        System.out.println(solution.longestOnes(new int[]{0,0,1,1,1,0,0},0));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int ans = 0;
            int length = nums.length;
            int[] pre = new int[length];
            int x = 0;
            for (int i = 0; i < length; i++) {
                x += nums[i];
                pre[i] = x;
            }

            int l = 0, r = 0;

            while (l <= r && r < length) {
                if (pre[r] - pre[l] + nums[l] + k >= r - l + 1) {
                    ans = Math.max(ans, r - l + 1);
                    r++;
                } else {
                    l++;
                    r++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
