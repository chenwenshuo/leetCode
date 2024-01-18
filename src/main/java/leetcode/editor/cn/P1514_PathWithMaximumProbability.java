//给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b 
//的一条无向边，且该边遍历成功的概率为 succProb[i] 。 
//
// 指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。 
//
// 如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, 
//end = 2
//输出：0.25000
//解释：从起点到终点有两条路径，其中一条的成功概率为 0.2 ，而另一条为 0.5 * 0.5 = 0.25
// 
//
// 示例 2： 
//
// 
//
// 输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, 
//end = 2
//输出：0.30000
// 
//
// 示例 3： 
//
// 
//
// 输入：n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
//输出：0.00000
//解释：节点 0 和 节点 2 之间不存在路径
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10^4 
// 0 <= start, end < n 
// start != end 
// 0 <= a, b < n 
// a != b 
// 0 <= succProb.length == edges.length <= 2*10^4 
// 0 <= succProb[i] <= 1 
// 每两个节点之间最多有一条边 
// 
//
// Related Topics 图 数组 最短路 堆（优先队列） 👍 142 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 概率最大的路径
 *
 * @author chenws
 * @date 2023-11-30 16:47:00
 */
public class P1514_PathWithMaximumProbability {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1514_PathWithMaximumProbability().new Solution();
        PriorityQueue<Double> queue = new PriorityQueue<>((a, b) -> a - b > 0 ? -1 : 1);
        queue.add(1D);
        queue.add(2D);
        System.out.println(queue.peek());
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Pair {

            int node;
            double succ;

            public Pair(int node, double succ) {
                this.node = node;
                this.succ = succ;
            }
        }
        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            List<Pair>[] g = new List[n];
            Arrays.setAll(g,k->new ArrayList<>());

            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                g[edge[0]].add(new Pair(edge[1],succProb[i]));
                g[edge[1]].add(new Pair(edge[0],succProb[i]));
            }
            PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.succ - b.succ > 0 ? -1 : 1);
            queue.add(new Pair(start_node, 1));
            double[] t = new double[n];
            boolean[] ex = new boolean[n];
            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                int node = pair.node;
                double succ = pair.succ;
                if (node == end_node) {
                    return succ;
                }
                ex[node] = true;
                List<Pair> pairs = g[node];
                for (Pair value : pairs) {
                    int node1 = value.node;
                    double succ1 = value.succ;
                    if (!ex[node1] && succ1 > 0 && succ * succ1 > t[node1]) {
                        t[node1] = succ * succ1;
                        queue.offer(new Pair(node1, t[node1]));
                    }
                }

            }
            return 0;
        }

        //数组超时--
        public double maxProbability1(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            double[][] pairs = new double[n][n];
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                pairs[edge[0]][edge[1]] = succProb[i];
                pairs[edge[1]][edge[0]] = succProb[i];

            }
            PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.succ - b.succ > 0 ? -1 : 1);
            queue.add(new Pair(start_node, 1));
            double[] t = new double[n];
            boolean[] ex = new boolean[n];
            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                int node = pair.node;
                double succ = pair.succ;
                if (node == end_node) {
                    return succ;
                }
                ex[node] = true;
                for (int i = 0; i < n; i++) {
                    if (!ex[i] && pairs[node][i] > 0 && succ * pairs[node][i] > t[i]) {
                        t[i] = succ * pairs[node][i];
                        queue.offer(new Pair(i, t[i]));
                    }
                }
            }
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}
