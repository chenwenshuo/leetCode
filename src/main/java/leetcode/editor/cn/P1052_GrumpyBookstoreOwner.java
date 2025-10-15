//有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，其中 customers[i]
// 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。 
//
// 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 
//
// 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。 
//
// 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。 
//
// 请你返回 这一天营业下来，最多有多少客户能够感到满意 。 
//
// 示例 1： 
//
// 
//输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
//输出：16
//解释：书店老板在最后 3 分钟保持冷静。
//感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
// 
//
// 示例 2： 
//
// 
//输入：customers = [1], grumpy = [0], minutes = 1
//输出：1 
//
// 
//
// 提示： 
//
// 
// n == customers.length == grumpy.length 
// 1 <= minutes <= n <= 2 * 10⁴ 
// 0 <= customers[i] <= 1000 
// grumpy[i] == 0 or 1 
// 
//
// Related Topics 数组 滑动窗口 👍 303 👎 0


package leetcode.editor.cn;

/**
 * 爱生气的书店老板
 *
 * @author chenws
 * @date 2024-04-23 16:42:22
 */
public class P1052_GrumpyBookstoreOwner {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1052_GrumpyBookstoreOwner().new Solution();
        System.out.println(solution.maxSatisfied(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1},3));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //customers =
        //[1,0,1,2,1,1,7,5]
        //grumpy =
        //[0,1,0,1,0,1,0,1]
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int length = customers.length;
            int sum = 0;
            int t = 0;
            for (int i = 0; i < length; i++) {
                if (grumpy[i] == 0) {
                    sum += customers[i];
                    continue;
                }
                if (i < minutes && grumpy[i] == 1) {
                    t += customers[i];
                }
            }
            int m =t;
            for (int i = 0, j = minutes; j < length; i++, j++) {
                int x = m;
                if (grumpy[i] == 1) {
                    x -= customers[i];
                }
                if (grumpy[j] == 1) {
                    x += customers[j];
                }
                m=x;
                t = Math.max(x, t);
            }
            return sum + t;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
