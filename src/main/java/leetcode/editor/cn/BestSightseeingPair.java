package leetcode.editor.cn;

//给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。 
//
// 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离
//。 
//
// 返回一对观光景点能取得的最高分。 
//
// 
//
// 示例 1： 
//
// 
//输入：values = [8,1,5,2,6]
//输出：11
//解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
// 
//
// 示例 2： 
//
// 
//输入：values = [1,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 2 <= values.length <= 5 * 10⁴ 
// 1 <= values[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 313 👎 0

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BestSightseeingPair{
         public static void main(String[] args) {
            Solution solution = new BestSightseeingPair().new Solution();

             Calendar calendar = Calendar.getInstance();
             calendar.setTime(new Date());
             int year = calendar.get(Calendar.YEAR);
             int month = calendar.get(Calendar.MONTH) + 1;
             System.out.println(month);
             Map<Integer, Integer> MONTH_QUATER_MAPPING = new HashMap();
             for (int i = 1; i < 13; i++) {
                 MONTH_QUATER_MAPPING.put(i , ((i-1) / 3 + 1));

             }
             System.out.println(0);
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        //[8,1,5,2,6]
        /**
         * 前：mx 取开头的最大值
         * ans 取qi
         */
        int ans = 0, mx = values[0] + 0;
        for (int j = 1; j < values.length; ++j) {
            ans = Math.max(ans, mx + values[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, values[j] + j);
        }
        return ans;

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
