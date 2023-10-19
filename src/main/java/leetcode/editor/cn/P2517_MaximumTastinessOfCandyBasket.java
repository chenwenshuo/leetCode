//给你一个正整boolean数数组 priintce int[]，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。
//
// 商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。 
//
// 返回礼盒的 最大 甜蜜度。 
//
// 
//
// 示例 1： 
//
// 
//输入：price = [13,5,1,8,21,2], k = 3
//输出：8
//解释：选出价格分别为 [13,5,21] 的三类糖果。
//礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
//可以证明能够取得的最大甜蜜度就是 8 。
// 
//
// 示例 2： 
//
// 
//输入：price = [1,3,1], k = 2
//输出：2
//解释：选出价格分别为 [1,3] 的两类糖果。 
//礼盒的甜蜜度为 min(|1 - 3|) = min(2) = 2 。
//可以证明能够取得的最大甜蜜度就是 2 。
// 
//
// 示例 3： 
//
// 
//输入：price = [7,7,7,7], k = 2
//输出：0
//解释：从现有的糖果中任选两类糖果，甜蜜度都会是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= price.length <= 10⁵ 
// 1 <= price[i] <= 10⁹ 
// 2 <= k <= price.length 
// 
//
// Related Topics 数组 二分查找 排序 👍 90 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 礼盒的最大甜蜜度
 *
 * @author chenws
 * @date 2023-06-01 14:31:11
 */
public class P2517_MaximumTastinessOfCandyBasket {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2517_MaximumTastinessOfCandyBasket().new Solution();
        System.out.println(solution.maximumTastiness(new int[]{13, 5, 1, 8, 21, 2}, 3));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximumTastiness(int[] price, int k) {

            Arrays.sort(price);
            int r = price[price.length - 1] - price[0];
            int l = 0;
            int ans = 0;
            while (l <= r) {
                int mid = l +r>>1;
                if (check(mid, price,k)) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            return ans;

        }

        private boolean check(int mid, int[] price, int k) {

            int tem = price[0];
            for (int i : price) {
                if (i-tem>=mid){
                    tem=i;
                    k--;
                }
                if (k==1){
                    return true;
                }
            }
            return false;
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)

}
