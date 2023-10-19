//给你一个正整数 n ，表示总共有 n 个城市，城市从 1 到 n 编号。给你一个二维数组 roads ，其中 roads[i] = [ai, bi, 
//distancei] 表示城市 ai 和 bi 之间有一条 双向 道路，道路距离为 distancei 。城市构成的图不一定是连通的。 
//
// 两个城市之间一条路径的 分数 定义为这条路径中道路的 最小 距离。 
//
// 城市 1 和城市 n 之间的所有路径的 最小 分数。 
//
// 注意： 
//
// 
// 一条路径指的是两个城市之间的道路序列。 
// 一条路径可以 多次 包含同一条道路，你也可以沿着路径多次到达城市 1 和城市 n 。 
// 测试数据保证城市 1 和城市n 之间 至少 有一条路径。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
//输出：5
//解释：城市 1 到城市 4 的路径中，分数最小的一条为：1 -> 2 -> 4 。这条路径的分数是 min(9,5) = 5 。
//不存在分数更小的路径。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
//输出：2
//解释：城市 1 到城市 4 分数最小的路径是：1 -> 2 -> 1 -> 3 -> 4 。这条路径的分数是 min(2,2,4,7) = 2 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10⁵ 
// 1 <= roads.length <= 10⁵ 
// roads[i].length == 3 
// 1 <= ai, bi <= n 
// ai != bi 
// 1 <= distancei <= 10⁴ 
// 不会有重复的边。 
// 城市 1 和城市 n 之间至少有一条路径。 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 18 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两个城市间路径的最小分数
 *
 * @author chenws
 * @date 2023-06-30 15:26:00
 */
public class P2492_MinimumScoreOfAPathBetweenTwoCities {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2492_MinimumScoreOfAPathBetweenTwoCities().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int ans = Integer.MAX_VALUE;
        boolean[] vis = new boolean[100005];

        public int minScore(int n, int[][] roads) {
            List[] g = new List[n + 1];
            Arrays.setAll(g, k -> new ArrayList<>());
            for (int[] road : roads) {
                int i = road[0];
                int i1 = road[1];
                int f = road[2];
                g[i].add(new int[]{i1, f});
                g[i1].add(new int[]{i, f});
            }
            dfs( g, 1);
            return ans;
        }

        private void dfs( List[] g, int x) {
            vis[x] = true;
            List<int[]> list = g[x];
            for (int[] ints : list) {
                ans = Math.min(ans, ints[1]);
                if (!vis[ints[0]]) {
                    dfs( g, ints[0]);
                }
            }

        }
        //leetcode submit region end(Prohibit modification and deletion)

    }
}

class Solution {

    List<int[]>[] g;
    boolean[] vis = new boolean[100005];
    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        g = new ArrayList[n + 5];
        Arrays.setAll(g, val -> new ArrayList<>());
        for (int[] e : roads) {
            g[e[0]].add(new int[]{e[1], e[2]});
            g[e[1]].add(new int[]{e[0], e[2]});
        }
        dfs(1);
        return ans;
    }

    void dfs(int u) {
        vis[u] = true;
        for (int[] t : g[u]) {
            int v = t[0], w = t[1];
            ans = Math.min(ans, w);
            if (!vis[v]) {
                dfs(v);
            }
        }
    }
}


