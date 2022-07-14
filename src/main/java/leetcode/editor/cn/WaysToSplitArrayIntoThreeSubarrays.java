package leetcode.editor.cn;

//我们称一个分割整数数组的方案是 好的 ，当它满足： 
//
// 
// 数组被分成三个 非空 连续子数组，从左至右分别命名为 left ， mid ， right 。 
// left 中元素和小于等于 mid 中元素和，mid 中元素和小于等于 right 中元素和。 
// 
//
// 给你一个 非负 整数数组 nums ，请你返回 好的 分割 nums 方案数目。由于答案可能会很大，请你将结果对 109 + 7 取余后返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1]
//输出：1
//解释：唯一一种好的分割方案是将 nums 分成 [1] [1] [1] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,2,2,5,0]
//输出：3
//解释：nums 总共有 3 种好的分割方案：
//[1] [2] [2,2,5,0]
//[1] [2,2] [2,5,0]
//[1,2] [2,2] [5,0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,2,1]
//输出：0
//解释：没有好的分割方案。 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 双指针 二分查找 前缀和 👍 77 👎 0

public class WaysToSplitArrayIntoThreeSubarrays{
         public static void main(String[] args) {
            Solution solution = new WaysToSplitArrayIntoThreeSubarrays().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        // 计算前缀和
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        final int MOD = 1000000000 + 7;
        long ans = 0;
        // 第一刀的最大值：sum(nums) / 3
        int t = sums[n - 1] / 3;
        for (int i = 0; i < n && sums[i] <= t; i++) {
            // 二分查找第二刀的最小值：sum(mid) == sum(left)
            // 在 [i+1, n] 中二分查找 sums[i] * 2，sums[i] 为到 i 为止元素和，因为是前缀数组，因而应该查找 sum(left) + sum(mid)
            int left = lowerBound(i + 1, n - 1, sums, sums[i] * 2);
            // 二分查找第二刀的最大值：sum(mid) == sum(mid + right) / 2
            // 在 [i+1, n] 中二分查找 sums[i] + (sums[n - 1] - sums[i]) / 2)，因为是前缀数组，因而应该查找 sum(left) + sum(mid + right) / 2
            int right = upperBound(i + 1, n - 1, sums, sums[i] + (sums[n - 1] - sums[i]) / 2);
            if (right >= left) {
                ans += right - left + 1;
            }
        }
        return (int) (ans % MOD);
    }

    public int lowerBound(int left, int right, int[] nums, int target) {
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int upperBound(int left, int right, int[] nums, int target) {
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
