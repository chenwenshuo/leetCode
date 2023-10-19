//这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。 
//
// 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。 
//
// 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[1,0],[0,1]]
//输出：0
//解释：没有一台服务器能与其他服务器进行通信。 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[1,0],[1,1]]
//输出：3
//解释：所有这些服务器都至少可以与一台别的服务器进行通信。
// 
//
// 示例 3： 
//
// 
//
// 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
//输出：4
//解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m <= 250 
// 1 <= n <= 250 
// grid[i][j] == 0 or 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 计数 矩阵 👍 70 👎 0


package leetcode.editor.cn;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 统计参与通信的服务器
 *
 * @author chenws
 * @date 2023-08-24 09:47:12
 */
public class P1267_CountServersThatCommunicate {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1267_CountServersThatCommunicate().new Solution();
        BigDecimal bigDecimal = new BigDecimal("0");
        BigDecimal bigDecimal1 = bigDecimal.setScale(4, RoundingMode.HALF_UP);
        System.out.println(bigDecimal1.toString());
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int ans;
        int m, n;



        public int countServers(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            if (m == 1 && n == 1) {
                return 0;
            }
            int[] h = new int[m];
            int[] l = new int[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j]==1){
                        h[i]++;
                        l[j]++;
                    }
                }
            }
            ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j]==1&&(h[i]>1||l[j]>1)){
                        ans++;
                    }
                }
            }


            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
