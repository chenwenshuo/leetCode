//给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。 
//
// 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,3,2,5]
//输出：[3,5]
//解释：[5, 3] 也是有效的答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1,0]
//输出：[-1,0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,1]
//输出：[1,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 除两个只出现一次的整数外，nums 中的其他数字都出现两次 
// 
//
// Related Topics 位运算 数组 👍 778 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字 III
 *
 * @author chenws
 * @date 2023-10-16 10:22:02
 */
public class P260_SingleNumberIii {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P260_SingleNumberIii().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] singleNumber(int[] nums) {

            Set<Integer> set = new HashSet<>();

            for (int num : nums) {
                if (set.contains(num)) {
                    set.remove(num);
                    continue;
                }
                set.add(num);
            }
            int[] ans = new int[2];
            int a = 0;
            for (Integer i : set) {
                ans[a++] = i;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
