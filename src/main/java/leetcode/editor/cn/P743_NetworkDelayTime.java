//有 n 个网络节点，标记为 1 到 n。 
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， 
//wi 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 👍 697 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 网络延迟时间
 *
 * @author chenws
 * @date 2023-10-20 14:21:33
 */
public class P743_NetworkDelayTime {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P743_NetworkDelayTime().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int networkDelayTime(int[][] times, int n, int k) {
            int[] tem = new int[n + 1];
            Arrays.fill(tem, Integer.MAX_VALUE);
            boolean vst[] = new boolean[n + 1];
            Set[] g = new Set[n + 1];
            Arrays.setAll(g, j -> new ArrayList<int[]>());
            for (int[] time : times) {
                g[time[0]].add(new int[]{time[1], time[2]});
            }
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(k);
            tem[k] = 0;
            tem[0] = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = queue.poll();
                    // 访问到就置为false 因为后续有可能继续访问
                    vst[poll] = false;
                    Set<int[]> set = g[poll];
                    //当到当前位置距离小于原始值时候，再计算。
                    for (int[] t : set) {
                        if (tem[t[0]] <= tem[poll] + t[1]) {
                            continue;
                        }
                        tem[t[0]] = Math.min(tem[t[0]], tem[poll] + t[1]);
                        if (vst[t[0]]) {
                            continue;
                        }
                        queue.offer(t[0]);
                        vst[t[0]] = true;
                    }
                }
            }
            int asInt = 0;
            for (int i : tem) {
                asInt = Math.max(asInt, i);
            }

            return asInt == Integer.MAX_VALUE ? -1 : asInt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
