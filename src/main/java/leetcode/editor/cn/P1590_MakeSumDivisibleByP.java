//给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。 
//
// 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。 
//
// 子数组 定义为原数组中连续的一组元素。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,1,4,2], p = 6
//输出：1
//解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
// 
//
// 示例 2： 
//
// 输入：nums = [6,3,5,2], p = 9
//输出：2
//解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3], p = 3
//输出：0
//解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
// 
//
// 示例 4： 
//
// 输入：nums = [1,2,3], p = 7
//输出：-1
//解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
// 
//
// 示例 5： 
//
// 输入：nums = [1000000000,1000000000,1000000000], p = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= p <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 118 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 使数组和能被 P 整除
 *
 * @author chenws
 * @date 2023-03-10 11:09:27
 */
public class P1590_MakeSumDivisibleByP {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1590_MakeSumDivisibleByP().new Solution();

        //System.out.println(solution.minSubarray(new int[]{6,3,5,2},9));
        //[8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2]
        System.out.println(280 - 142);
        //148
        // System.out.println(solution.minSubarray(new int[]{8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4, 2}, 148));

        //System.out.println(solution.minSubarray(new int[]{1000000000,1000000000,1000000000},3));
        // System.out.println(solution.minSubarray(new int[]{1,2,3},7));
        System.out.println(solution.minSubarray(new int[]{17, 6, 22, 31, 25, 4, 18, 32, 18, 26, 2, 31, 26, 8, 12, 2}, 142));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minSubarray1(int[] nums, int p) {

            long[] tem = new long[nums.length];
            long a = 0;
            for (int i = 0; i < nums.length; i++) {
                a += nums[i];
                tem[i] = a;
            }
            long x = tem[nums.length - 1];
            if (x % p == 0) {
                return 0;
            }
            int ans = 0;
            long k = x % p;
            for (int i = 0; i < tem.length; i++) {

            }
            return ans == Integer.MAX_VALUE ? -1 : ans;

        }

        /**
         * hash 表
         * @param nums
         * @param p
         * @return
         */
        public int minSubarray(int[] nums, int p) {
            int n = nums.length;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
            }
            long mod = sum % p;
            if (mod == 0) {
                return 0;
            }
            int ans = n;
            long cur = 0;
            // key: 前缀和 mod p 的结果，value: 最早出现该前缀和的下标
            Map<Long, Integer> map = new HashMap<Long, Integer>();
            map.put(0L, -1);
            for (int i = 0; i < n; i++) {
                cur = (cur + nums[i]) % p;
                map.put(cur, i);
            }
            cur = 0;
            for (int i = n - 1; i >= 0; i--) {
                cur = (cur + nums[i]) % p;
                long need = (p - mod + cur) % p;
                if (map.containsKey(need)) {
                    ans = Math.min(ans, i - map.get(need) - 1);
                }
            }
            return ans < n ? ans : -1;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
