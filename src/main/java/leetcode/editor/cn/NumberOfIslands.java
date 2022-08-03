package leetcode.editor.cn;

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1831 👎 0

/**
 *思路：
 * 1.dfs
 * 从头遍历，类似于树 要遍历上下左右四个节点
 * return 条件 边界值+不符合岛屿时候
 * 符合条件加一
 *
 */
public class NumberOfIslands{
         public static void main(String[] args) {
            Solution solution = new NumberOfIslands().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
             int num=0;
    public int numIslands(char[][] grid) {
        int length = grid.length;
        int length1 = grid[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length1; j++) {
                if (grid[i][j]=='1'){

                    dfs(grid,i,j);
                    num++;
                }
            }
        }

             return num;
    }

    private void dfs(char[][] grid, int h, int l) {
        if (h<0||l<0||h>grid.length-1||l>grid[0].length-1) return;
        if (grid[h][l]!='1') return;
        grid[h][l]='0';

        dfs(grid,h-1,l);
        dfs(grid,h+1,l);
        dfs(grid,h,l-1);
        dfs(grid,h,l+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
