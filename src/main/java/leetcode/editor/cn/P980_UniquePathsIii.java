//在二维网格 grid 上，有 4 种类型的方格： 
//
// 
// 1 表示起始方格。且只有一个起始方格。 
// 2 表示结束方格，且只有一个结束方格。 
// 0 表示我们可以走过的空方格。 
// -1 表示我们无法跨越的障碍。 
// 
//
// 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。 
//
// 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
//输出：2
//解释：我们有以下两条路径：
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2) 
//
// 示例 2： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
//输出：4
//解释：我们有以下四条路径： 
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
//2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
//3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
//4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3) 
//
// 示例 3： 
//
// 输入：[[0,1],[2,0]]
//输出：0
//解释：
//没有一条路能完全穿过每一个空的方格一次。
//请注意，起始和结束方格可以位于网格中的任意位置。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length * grid[0].length <= 20 
// 
//
// Related Topics 位运算 数组 回溯 矩阵 👍 282 👎 0


package leetcode.editor.cn;

/**
 * 不同路径 III
 *
 * @author chenws
 * @date 2023-08-04 14:41:06
 */
public class P980_UniquePathsIii {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P980_UniquePathsIii().new Solution();
        System.out.println(solution.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int ans;
        int[][] f = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int s,t;
        int m, n;

        int count;

        boolean[][] flag;

        public int uniquePathsIII(int[][] grid) {
            ans = 0;
            m = grid.length;
            n = grid[0].length;
            count = 0;
            flag = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        s=i;
                        t = j;
                    }
                    if (grid[i][j] == 0) {
                        count++;
                    }
                }
            }

            dfs(grid, s, t);
            return ans;
        }

        private void dfs(int[][] grid, int s, int t) {
            if (grid[s][t] == 2) {
                if (count == -1) {
                    ans++;
                }
                return;
            }
            for (int[] tem : f) {
                int x = tem[0] + s;
                int y = tem[1] + t;
                if (x >= 0 && x < m && y >= 0 && y < n &&grid[x][y]!=1&&grid[x][y]!=-1 && !flag[x][y]) {
                    flag[x][y] = true;
                    count--;
                    dfs(grid,x,y);
                    count++;
                    flag[x][y]=false;
                }

            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
