//给你一个长度为 n 的整数数组 nums ，请你求出每个长度为 k 的子数组的 美丽值 。 
//
// 一个子数组的 美丽值 定义为：如果子数组中第 x 小整数 是 负数 ，那么美丽值为第 x 小的数，否则美丽值为 0 。 
//
// 请你返回一个包含 n - k + 1 个整数的数组，依次 表示数组中从第一个下标开始，每个长度为 k 的子数组的 美丽值 。 
//
// 
// 子数组指的是数组中一段连续 非空 的元素序列。 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,-1,-3,-2,3], k = 3, x = 2
//输出：[-1,-2,-2]
//解释：总共有 3 个 k = 3 的子数组。
//第一个子数组是 [1, -1, -3] ，第二小的数是负数 -1 。
//第二个子数组是 [-1, -3, -2] ，第二小的数是负数 -2 。
//第三个子数组是 [-3, -2, 3] ，第二小的数是负数 -2 。 
//
// 示例 2： 
//
// 输入：nums = [-1,-2,-3,-4,-5], k = 2, x = 2
//输出：[-1,-2,-3,-4]
//解释：总共有 4 个 k = 2 的子数组。
//[-1, -2] 中第二小的数是负数 -1 。
//[-2, -3] 中第二小的数是负数 -2 。
//[-3, -4] 中第二小的数是负数 -3 。
//[-4, -5] 中第二小的数是负数 -4 。 
//
// 示例 3： 
//
// 输入：nums = [-3,1,2,-3,0,-3], k = 2, x = 1
//输出：[-3,0,-3,-3,-3]
//解释：总共有 5 个 k = 2 的子数组。
//[-3, 1] 中最小的数是负数 -3 。
//[1, 2] 中最小的数不是负数，所以美丽值为 0 。
//[2, -3] 中最小的数是负数 -3 。
//[-3, 0] 中最小的数是负数 -3 。
//[0, -3] 中最小的数是负数 -3 。 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= k <= n 
// 1 <= x <= k 
// -50 <= nums[i] <= 50 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 36 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 滑动子数组的美丽值
 *
 * @author chenws
 * @date 2023-09-08 16:24:33
 */
public class P2653_SlidingSubarrayBeauty {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2653_SlidingSubarrayBeauty().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] getSubarrayBeauty(int[] nums, int k, int x) {
            final int BIAS = 50;
            var cnt = new int[BIAS * 2 + 1];
            int n = nums.length;
            for (int i = 0; i < k - 1; ++i) {
                ++cnt[nums[i] + BIAS];
            }
            var ans = new int[n - k + 1];
            for (int i = k - 1; i < n; ++i) {
                ++cnt[nums[i] + BIAS];
                int left = x;
                for (int j = 0; j < BIAS; ++j) {
                    left -= cnt[j];
                    if (left <= 0) {
                        ans[i - k + 1] = j - BIAS;
                        break;
                    }
                }
                --cnt[nums[i - k + 1] + BIAS]; // 离开窗口
            }
            return ans;
        }

        public int[] getSubarrayBeauty1(int[] nums, int k, int x) {
            int[] res = new int[nums.length - k + 1];
            int[] tem = new int[k];
            System.arraycopy(nums, 0, tem, 0, k);
            Arrays.sort(tem);
            for (int i = 0; i < res.length; i++) {
                if (i != 0) {
                    int index = Arrays.binarySearch(tem, nums[i - 1]);
                    tem[index] = nums[i + k - 1];
                    Arrays.sort(tem);
                }
                res[i] = Math.min(tem[x - 1], 0);
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
