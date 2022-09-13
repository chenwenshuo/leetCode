package leetcode.editor.cn;

//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
//2673   7465
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
//
// Related Topics 贪心 数学 👍 342 👎 0

import java.util.ArrayList;
import java.util.List;

public class MaximumSwap{
         public static void main(String[] args) {
            Solution solution = new MaximumSwap().new Solution();
             System.out.println(solution.maximumSwap(86678));
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10); num /= 10;
        }
        int n = list.size(), ans = 0;
        int[] idx = new int[n];
        for (int i = 0, j = 0; i < n; i++) {
            if (list.get(i) > list.get(j)) j = i;
            idx[i] = j;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (list.get(idx[i]) != list.get(i)) {
                int c = list.get(idx[i]);
                list.set(idx[i], list.get(i));
                list.set(i, c);
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) ans = ans * 10 + list.get(i);
        return ans;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}
