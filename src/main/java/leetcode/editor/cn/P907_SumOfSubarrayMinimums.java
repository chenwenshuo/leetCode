//给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。 
//
// 由于答案可能很大，因此 返回答案模 10^9 + 7 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
//最小值为 3，1，2，4，1，1，2，，11，1，和为 17。
//
// 示例 2： 
//
// 
//输入：arr = [11,81,94,43,3]
//输出：444
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 3 * 10⁴ 
// 
//
// 
//
// Related Topics 栈 数组 动态规划 单调栈 👍 731 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 子数组的最小值之和
 *
 * @author chenws
 * @date 2023-11-27 15:09:41
 */
public class P907_SumOfSubarrayMinimums {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P907_SumOfSubarrayMinimums().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int sumSubarrayMins(int[] arr) {
            int n = arr.length;
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(left, -1);
            Arrays.fill(right, n);
            Deque<Integer> stk = new ArrayDeque<>();
            //arr = [3,1,2,4]
            //找到左边第一个小于arr[i]的下标
            for (int i = 0; i < n; i++) {
                while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                    stk.pop();
                }
                if (!stk.isEmpty()) {
                    left[i] = stk.peek();
                }
                stk.push(i);
            }
            stk.clear();
            //找到右边第一个小于等于arr[i]的下标
            for (int i = n - 1; i >= 0; i--) {
                while (!stk.isEmpty()&&arr[stk.peek()]>arr[i]){
                    stk.pop();
                }
                if (!stk.isEmpty()){
                    right[i] = stk.peek();
                }
                stk.push(i);
            }
            final int mod = (int) 1e9 + 7;
            long ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
                ans %= mod;
            }
            return (int) ans;
        }
        //leetcode submit region end(Prohibit modification and deletion)

    }
}
