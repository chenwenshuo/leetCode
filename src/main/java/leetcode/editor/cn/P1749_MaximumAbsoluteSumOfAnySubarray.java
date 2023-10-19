//给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(
//numsl + numsl+1 + ... + numsr-1 + numsr) 。 
//
// 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。 
//
// abs(x) 定义如下： 
//
// 
// 如果 x 是负整数，那么 abs(x) = -x 。 
// 如果 x 是非负整数，那么 abs(x) = x 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-3,2,3,-4]
//输出：5
//解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,-5,1,-4,3,-2]
//输出：8
//解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 👍 55 👎 0


package leetcode.editor.cn;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.IntBinaryOperator;

/**
 * 任意子数组和的绝对值的最大值
 *
 * @author chenws
 * @date 2023-08-08 10:11:28
 */
public class P1749_MaximumAbsoluteSumOfAnySubarray {

    public static void main(String[] args) {
        String[] s = new String[]{"!","2","#"};
        String[] clone = s.clone();
        s[1]="9";
        for (String s1 : clone) {
            System.out.println(s1);
        }
        //测试代码
        Solution solution = new P1749_MaximumAbsoluteSumOfAnySubarray().new Solution();
        //System.out.println(solution.maxAbsoluteSum(new int[]{1, -3, 2, 3, -4}));
       // System.out.println(solution.maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}));
        String  b = new BigDecimal(0).setScale(2).toString();
        System.out.println(b);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//    int s = 0, mx = 0, mn = 0;
//        for (int x : nums) {
//            s += x;
//            // mx = Math.max(mx, s);
//            // mn = Math.min(mn, s);
//            if (s > mx) mx = s;
//            else if (s < mn) mn = s; // 效率更高的写法
//        }
//        return mx - mn;
//
        public int maxAbsoluteSum(int[] nums) {
            int num =0;
            int min = 0;
            int max = 0;
            int ans = num;
            for (int j : nums) {
                num += j;

                min = Math.min(min, num);
                max = Math.max(max, num);

                ans = Math.max(ans, max - min);


            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
