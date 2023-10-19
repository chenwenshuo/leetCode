//给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素
// 。 
//
// 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 
//。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4,3]
//输出: [2,3,4,-1,4]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 栈 数组 单调栈 👍 832 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 下一个更大元素 II
 *
 * @author chenws
 * @date 2023-07-20 16:57:01
 */
public class P503_NextGreaterElementIi {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P503_NextGreaterElementIi().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] ret = new int[n];
            Arrays.fill(ret, -1);
            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < n * 2 - 1; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                    ret[stack.pop()] = nums[i % n];
                }
                stack.push(i % n);
            }
            return ret;
        }

        ////输入: nums = [1,2,3,4,3]
        ////输出: [2,3,4,-1,4]
        public int[] nextGreaterElements1(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            Deque<Integer> stack = new LinkedList<Integer>();
            Arrays.fill(ans, -1);
            for (int i = 0; i < 2 * n - 1; i++) {
                while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                    ans[stack.pop()] = nums[i % n];
                }
                if (i < n) {
                    stack.push(i);
                }
            }
            return ans;
        }
        public int[] nextGreaterElements2(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            Deque<Integer> stack = new LinkedList<Integer>();
            Arrays.fill(ans, -1);
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    ans[stack.pop()] = nums[i];
                }
                    stack.push(i);
            }
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    ans[stack.pop()] = nums[i];
                }
            }
            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {

        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            Deque<Integer> stack = new ArrayDeque<Integer>();
            for (int i = nums2.length - 1; i >= 0; --i) {
                int num = nums2[i];
                while (!stack.isEmpty() && num >= stack.peek()) {
                    stack.pop();
                }
                map.put(num, stack.isEmpty() ? -1 : stack.peek());
                stack.push(num);
            }
            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; ++i) {
                res[i] = map.get(nums1[i]);
            }
            return res;
        }
    }

}
