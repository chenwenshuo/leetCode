//给你一个整数数组 nums 。每一次操作中，你可以将 nums 中 任意 一个元素替换成 任意 整数。 
//
// 如果 nums 满足以下条件，那么它是 连续的 ： 
//
// 
// nums 中所有元素都是 互不相同 的。 
// nums 中 最大 元素与 最小 元素的差等于 nums.length - 1 。 
// 
//
// 比方说，nums = [4, 2, 5, 3] 是 连续的 ，但是 nums = [1, 2, 3, 5, 6] 不是连续的 。 
//
// 请你返回使 nums 连续 的 最少 操作次数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,2,5,3]
//输出：0
//解释：nums 已经是连续的了。
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,5,6]
//输出：1
//解释：一个可能的解是将最后一个元素变为 4 。
//结果数组为 [1,2,3,5,4] ，是连续数组。
// 
//
// 示例 3： 
//
// 输入：nums = [1,10,100,1000]
//输出：3
//解释：一个可能的解是：
//- 将第二个元素变为 2 。
//- 将第三个元素变为 3 。
//- 将第四个元素变为 4 。
//结果数组为 [1,2,3,4] ，是连续数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 二分查找 滑动窗口 👍 69 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/**
 * 使数组连续的最少操作数
 *
 * @author chenws
 * @date 2024-04-08 11:22:04
 */
public class P2009_MinimumNumberOfOperationsToMakeArrayContinuous {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2009_MinimumNumberOfOperationsToMakeArrayContinuous().new Solution();
        System.out.println(solution.minOperations1(new int[]{1,2,3,5,6}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums) {
            int length = nums.length;
            TreeSet<Integer> set = new TreeSet<>();
            for (int n : nums) {
                set.add(n);
            }
            int l = set.size();
            Integer[] temArr = set.toArray(new Integer[l]);
            int idx = 0;
            int ans = 0;
            for (int i = 0; i < temArr.length; i++) {
                while (temArr[idx] < temArr[i] - length + 1) {
                    idx++;
                }
                ans = Math.max(ans, i - idx + 1);

            }
            return length - ans;
        }

        public int minOperations1(int[] nums) {
            int length = nums.length;
            Arrays.sort(nums);
            TreeSet<Integer> set = new TreeSet<>();
            int l = 0;
            int ans = length;
            for (int i = 0; i < nums.length; i++) {
                while (l <= i && nums[i] - nums[l] <= length - 1) {
                    set.add(nums[l]);
                    l++;

                }
                ans = Math.min(ans, length - set.size());
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
