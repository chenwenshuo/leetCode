//给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。 
//
// 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。 
//
// 
// 
// 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。 
// 
// 
//
// 返回必须翻转的 0 的最小数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 2 <= n <= 100 
// grid[i][j] 为 0 或 1 
// grid 中恰有两个岛 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 463 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 最短的桥
 *
 * @author chenws
 * @date 2023-06-13 14:32:46
 */
public class P934_ShortestBridge {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P934_ShortestBridge().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int shortestBridge(int[][] grid) {
            int n = grid.length;
            int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            List<int[]> island = new ArrayList<int[]>();
            Queue<int[]> queue = new ArrayDeque<int[]>();
            outer:
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = -1;
                        queue.add(new int[]{i, j});
                        while (!queue.isEmpty()) {
                            int[] poll = queue.poll();
                            island.add(poll);

                            for (int[] dir : dirs) {
                                int x = poll[0] + dir[0];
                                int y = poll[1] + dir[1];
                                if (x < n && x >= 0 && y < n && y >= 0) {
                                    if (grid[x][y] == 1) {
                                        grid[x][y] = -1;
                                        queue.offer(new int[]{x,y});
                                    }
                                }
                            }

                        }
                        break outer;
                    }

                }
            }
            for (int[] land : island) {
                queue.offer(land);
            }
            int ans =0;
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    for (int[] dir : dirs) {
                        int x = dir[0]+poll[0];
                        int y = dir[1]+poll[1];
                        if (x < n && x >= 0 && y < n && y >= 0){
                            if (grid[x][y]==1){
                                return ans;
                            }else if (grid[x][y]==0){
                                grid[x][y]=-1;
                                queue.offer(new int[]{x,y});
                            }
                        }
                    }
                }
                ans++;
            }
            return 0;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
