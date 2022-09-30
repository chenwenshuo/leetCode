package hot100;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 * @Author: chenwenshuo
 * @Date: 2022/09/29/11:28
 */
public class Hot64 {
    public static void main(String[] args) {
        System.out.println(new Hot64().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
    public int minPathSum(int[][] grid) {
        int l = grid.length;
        int h = grid[0].length;

        int[][] dp=new int[l][h];
        dp[0][0]=grid[0][0];
        for (int i = 1; i < l; i++) {
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        for (int i = 1; i < h; i++) {
            dp[0][i]=grid[0][i]+dp[0][i-1];
        }
        for (int i = 1; i < l; i++) {
            for (int j = 1; j < h; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[l-1][h-1];
    }
}
