//给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组
//，并返回满足条件的子数组的个数。 
//
// 生成的测试用例保证结果符合 32-bit 整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,4,3], left = 2, right = 3
//输出：3
//解释：满足条件的三个子数组：[2], [2, 1], [3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,9,2,5,6], left = 2, right = 8
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= left <= right <= 10⁹ 
// 
//
// Related Topics 数组 双指针 👍 362 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 区间子数组个数
 *
 * @author chenws
 * @date 2023-10-23 13:37:53
 */
public class P795_NumberOfSubarraysWithBoundedMaximum {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P795_NumberOfSubarraysWithBoundedMaximum().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //[2,9,2,5,6] left = 2, right = 8
        //[2,1,4,3] 2 4
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int ans = 0;
            Queue<Integer> queue = new LinkedList<>();
            for (int num : nums) {
                if (num <= right && num >= left) {
                    queue.offer(num);
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
