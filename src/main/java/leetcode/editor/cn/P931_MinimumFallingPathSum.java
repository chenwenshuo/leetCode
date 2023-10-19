//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。 
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：如图所示，为和最小的两条下降路径
// 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：如图所示，为和最小的下降路径
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 267 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 下降路径最小和
 *
 * @author chenws
 * @date 2023-07-13 14:12:28
 */
public class P931_MinimumFallingPathSum {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P931_MinimumFallingPathSum().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int[][] dp = new int[n][n];
            System.arraycopy(matrix[0], 0, dp[0], 0, matrix[0].length);
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = matrix[i][j] +
                        Math.min(dp[i - 1][j], Math.min(dp[i - 1][j > 0 ? j - 1 : j], dp[i - 1][j < n - 1 ? j + 1 : j]));
                }
            }
            return Arrays.stream(dp[n - 1]).min().getAsInt();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
