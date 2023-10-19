//给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。 
//
// 
//
// 示例 1： 
//
// 输入：n = 234
//输出：15 
//解释：
//各位数之积 = 2 * 3 * 4 = 24 
//各位数之和 = 2 + 3 + 4 = 9 
//结果 = 24 - 9 = 15
// 
//
// 示例 2： 
//
// 输入：n = 4421
//输出：21
//解释： 
//各位数之积 = 4 * 4 * 2 * 1 = 32 
//各位数之和 = 4 + 4 + 2 + 1 = 11 
//结果 = 32 - 11 = 21
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^5 
// 
//
// Related Topics 数学 👍 125 👎 0


package leetcode.editor.cn;

/**
 * 整数的各位积和之差
 *
 * @author chenws
 * @date 2023-08-09 10:07:30
 */
public class P1281_SubtractTheProductAndSumOfDigitsOfAnInteger {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1281_SubtractTheProductAndSumOfDigitsOfAnInteger().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int subtractProductAndSum(int n) {
            long sum = 0;
            long j = 1;
            int tem;
            while (n != 0) {
                tem = n % 10;
                n = n / 10;
                sum += tem;
                j *= tem;
            }
            return (int) (j - sum);

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
