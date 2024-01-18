//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2254 👎 0


package leetcode.editor.cn;

/**
 * 移动零
 *
 * @author chenws
 * @date 2023-12-07 17:45:16
 */
public class P283_MoveZeroes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P283_MoveZeroes().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int n = nums.length, left = 0, r = 0;
            while (r < n) {
                if (nums[r] != 0) {
                    int temp = nums[left];
                    nums[left] = nums[r];
                    nums[r] = temp;
                    left++;
                }
                r++;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
