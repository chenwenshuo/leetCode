//给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。 
//
// 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
//输出：13
//解释：
//所有非零偏移下降路径包括：
//[1,5,9], [1,5,7], [1,6,7], [1,6,8],
//[2,4,8], [2,4,9], [2,6,7], [2,6,8],
//[3,4,8], [3,4,9], [3,5,7], [3,5,9]
//下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[7]]
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// -99 <= grid[i][j] <= 99 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 127 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 下降路径最小和  II
 *
 * @author chenws
 * @date 2023-08-10 10:16:54
 */
public class P1289_MinimumFallingPathSumIi {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1289_MinimumFallingPathSumIi().new Solution();

        System.out.println(solution.minFallingPathSum(new int[][]{{7}}));

    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int n;

        public int minFallingPathSum(int[][] grid) {

            n = grid.length;
            if (n == 1) {
                return grid[0][0];
            }
            Integer[][] d = new Integer[n][n];
            int ans = Integer.MAX_VALUE;
            for (int l = 0; l < n; l++) {
                ans = Math.min(ans, dfs(grid, 0, l, d));
            }
            return ans;
        }

        //
        private int dfs(int[][] grid, int h, int l, Integer[][] d) {
            if (h >= n) {
                return 0;
            }
            if (d[h][l] != null) {
                return d[h][l];
            }
            int ans = Integer.MAX_VALUE;
            d[h][l] = ans;
            for (int i = 0; i < n; i++) {
                if (i == l) {
                    continue;
                }

                ans = Math.min(ans, grid[h][l] + dfs(grid, h + 1, i, d));
                d[h][l] = ans;
            }
            return d[h][l];
        }
        public int minFallingPathSum1(int[][] grid) {

            n = grid.length;
            if (n == 1) {
                return grid[0][0];
            }
          int ans = Integer.MAX_VALUE;
            int[] f = new int[2];
            int[] s = new int[2];
            int tem =Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                s=f.clone();
                tem = Math.min(tem,grid[0][i]);
             f= new int[]{i,tem};
            }
            for (int i = 1; i < n; i++) {
                int c= Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                   int a= f[0];
                   if(a==j){
                      s =f.clone();
                      c=Math.min(tem,grid[i][j]+s[1]);
                   }
                }
            }
            return 0;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)





}
