//给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n² 分钟内修好
// n 辆车。 
//
// 同时给你一个整数 cars ，表示总共需要修理的汽车数目。 
//
// 请你返回修理所有汽车 最少 需要多少时间。 
//
// 注意：所有机械工可以同时修理汽车。 
//
// 
//
// 示例 1： 
//
// 
//输入：ranks = [4,2,3,1], cars = 10
//输出：16
//解释：
//- 第一位机械工修 2 辆车，需要 4 * 2 * 2 = 16 分钟。
//- 第二位机械工修 2 辆车，需要 2 * 2 * 2 = 8 分钟。
//- 第三位机械工修 2 辆车，需要 3 * 2 * 2 = 12 分钟。
//- 第四位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
//16 分钟是修理完所有车需要的最少时间。
// 
//
// 示例 2： 
//
// 
//输入：ranks = [5,1,8], cars = 6
//输出：16
//解释：
//- 第一位机械工修 1 辆车，需要 5 * 1 * 1 = 5 分钟。
//- 第二位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
//- 第三位机械工修 1 辆车，需要 8 * 1 * 1 = 8 分钟。
//16 分钟时修理完所有车需要的最少时间。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ranks.length <= 10⁵ 
// 1 <= ranks[i] <= 100 
// 1 <= cars <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 👍 138 👎 0


package leetcode.editor.cn;

/**
 * 修车的最少时间
 *
 * @author chenws
 * @date 2023-09-07 17:20:32
 */
public class P2594_MinimumTimeToRepairCars {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2594_MinimumTimeToRepairCars().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long repairCars(int[] ranks, int cars) {
            long r = (long) ranks[0] * cars * cars;
            long l = 0;
            long ans = 0;
            while (l < r) {
                long mid = r + l >> 1;
                if (check(mid, cars, ranks)) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return ans;

        }

        private boolean check(long mid, int cars, int[] ranks) {
            long tem = 0;
            for (int rank : ranks) {
                tem += Math.sqrt((double) mid / rank);
            }

            return tem >= cars;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
