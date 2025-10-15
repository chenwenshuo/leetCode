//和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。 
//
// 给你一个整数数组 nums ，请你在所有可能的 子序列 中找到最长的和谐子序列的长度。 
//
// 数组的 子序列 是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,3,2,2,5,2,3,7] 
// 
//
// 输出：5 
//
// 解释： 
//
// 最长和谐子序列是 [3,2,2,2,3]。 
//
// 示例 2： 
//
// 
// 输入：nums = [1,2,3,4] 
// 
//
// 输出：2 
//
// 解释： 
//
// 最长和谐子序列是 [1,2]，[2,3] 和 [3,4]，长度都为 2。 
//
// 示例 3： 
//
// 
// 输入：nums = [1,1,1,1] 
// 
//
// 输出：0 
//
// 解释： 
//
// 不存在和谐子序列。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 计数 排序 滑动窗口 👍 430 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长和谐子序列
 *
 * @author chenws
 * @date 2025-06-30 16:40:55
 */
public class P594_LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P594_LongestHarmoniousSubsequence().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLHS(int[] nums) {
            int ans = 0;
            Map<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                map.merge(num, 1, Integer::sum);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                Integer key = entry.getKey();
                int a = map.getOrDefault(key, 0);
                ans = Math.max(ans, a == 0 ? 0 : a + value);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
