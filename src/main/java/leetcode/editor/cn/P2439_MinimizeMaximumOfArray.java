//给你一个下标从 0 开始的数组 nums ，它含有 n 个非负整数。 
//
// 每一步操作中，你需要： 
//
// 
// 选择一个满足 1 <= i < n 的整数 i ，且 nums[i] > 0 。 
// 将 nums[i] 减 1 。 
// 将 nums[i - 1] 加 1 。 
// 
//
// 你可以对数组执行 任意 次上述操作，请你返回可以得到的 nums 数组中 最大值 最小 为多少。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,7,1,6]
//输出：5
//解释：
//一串最优操作是：
//1. 选择 i = 1 ，nums 变为 [4,6,1,6] 。
//2. 选择 i = 3 ，nums 变为 [4,6,2,5] 。
//3. 选择 i = 1 ，nums 变为 [5,5,2,5] 。
//nums 中最大值为 5 。无法得到比 5 更小的最大值。
//所以我们返回 5 。
// 
//
// 示例 2： 
//
// 输入：nums = [10,1]
//输出：10
//解释：
//最优解是不改动 nums ，10 是最大值，所以返回 10 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 2 <= n <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 二分查找 动态规划 前缀和 👍 53 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最小化数组中的最大值
 *
 * @author chenws
 * @date 2023-09-07 17:45:50
 */
public class P2439_MinimizeMaximumOfArray {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2439_MinimizeMaximumOfArray().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minimizeArrayValue(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int r = Arrays.stream(nums).max().getAsInt();
            int l = 0;
            int sum = Arrays.stream(nums).sum();
            int ans = Integer.MAX_VALUE;
            while (l <= r) {
                int mid = l + r >> 1;
                if (check(mid, sum, nums)) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }


            }

            return ans;
        }

        private boolean check(int mid, int sum, int[] nums) {
            int tem = 0;
            for (int num : nums) {
                tem += mid - num;
                if (tem < 0) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
