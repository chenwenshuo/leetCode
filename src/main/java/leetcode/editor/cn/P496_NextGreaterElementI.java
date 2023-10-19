//nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。 
//
// 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。 
//
// 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 
//nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。 
//
// 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出：[-1,3,-1]
//解释：nums1 中每个值的下一个更大元素如下所述：
//- 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
//- 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
//- 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。 
//
// 示例 2： 
//
// 
//输入：nums1 = [2,4], nums2 = [1,2,3,4].
//输出：[3,-1]
//解释：nums1 中每个值的下一个更大元素如下所述：
//- 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
//- 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 10⁴ 
// nums1和nums2中所有整数 互不相同 
// nums1 中的所有整数同样出现在 nums2 中 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？ 
//
// Related Topics 栈 数组 哈希表 单调栈 👍 1085 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 下一个更大元素 I
 *
 * @author chenws
 * @date 2023-09-27 17:30:01
 */
public class P496_NextGreaterElementI {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P496_NextGreaterElementI().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //：nums1 = [4,1,2], nums2 = [1,3,4,2].
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

        public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            Deque<Integer> stack = new ArrayDeque<Integer>();
            //单调栈中存最大元素的倒序  6 5 4 3
            for (int i = nums2.length - 1; i >= 0; i--) {
                int n = nums2[i];
                while (!stack.isEmpty() && n >= stack.peek()) {
                    stack.pop();
                }
                map.put(n,stack.isEmpty()?-1:stack.peek());
                stack.push(n);
            }
            int[] ans = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                ans[i] = map.get(nums1[i]);
            }
            return ans;
        }
        public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            Deque<Integer> stack = new ArrayDeque<Integer>();
            //单调栈中存当前元素的倒序
            for (int i = 0; i < nums2.length; i++) {
                int n = nums2[i];
                while (!stack.isEmpty()&&n>stack.peek()){
                    map.put(stack.pop(),n);
                }
                stack.push(n);
            }
            int[] ans = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                ans[i] = map.getOrDefault(nums1[i],-1);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
