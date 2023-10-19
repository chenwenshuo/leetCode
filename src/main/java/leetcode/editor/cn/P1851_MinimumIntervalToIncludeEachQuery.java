//给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti] 表示第 i 个区间开始于 lefti 、结束
//于 righti（包含两侧取值，闭区间）。区间的 长度 定义为区间中包含的整数数目，更正式地表达是 righti - lefti + 1 。 
//
// 再给你一个整数数组 queries 。第 j 个查询的答案是满足 lefti <= queries[j] <= righti 的 长度最小区间 i 的长度
// 。如果不存在这样的区间，那么答案是 -1 。 
//
// 以数组形式返回对应查询的所有答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]
//输出：[3,3,1,4]
//解释：查询处理如下：
//- Query = 2 ：区间 [2,4] 是包含 2 的最小区间，答案为 4 - 2 + 1 = 3 。
//- Query = 3 ：区间 [2,4] 是包含 3 的最小区间，答案为 4 - 2 + 1 = 3 。
//- Query = 4 ：区间 [4,4] 是包含 4 的最小区间，答案为 4 - 4 + 1 = 1 。
//- Query = 5 ：区间 [3,6] 是包含 5 的最小区间，答案为 6 - 3 + 1 = 4 。
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[2,3],[2,5],[1,8],[20,25]], queries = [2,19,5,22]
//输出：[2,-1,4,6]
//解释：查询处理如下：
//- Query = 2 ：区间 [2,3] 是包含 2 的最小区间，答案为 3 - 2 + 1 = 2 。
//- Query = 19：不存在包含 19 的区间，答案为 -1 。
//- Query = 5 ：区间 [2,5] 是包含 5 的最小区间，答案为 5 - 2 + 1 = 4 。
//- Query = 22：区间 [20,25] 是包含 22 的最小区间，答案为 25 - 20 + 1 = 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁵ 
// 1 <= queries.length <= 10⁵ 
// intervals[i].length == 2 
// 1 <= lefti <= righti <= 10⁷ 
// 1 <= queries[j] <= 10⁷ 
// 
//
// Related Topics 数组 二分查找 排序 扫描线 堆（优先队列） 👍 106 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 包含每个查询的最小区间
 *
 * @author chenws
 * @date 2023-07-18 15:55:28
 */
public class P1851_MinimumIntervalToIncludeEachQuery {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1851_MinimumIntervalToIncludeEachQuery().new Solution();
      //  System.out.println(solution.minInterval(new int[][]{{1, 4}, {2, 4}, {3, 6}, {4, 4}}, new int[]{2, 3, 4, 5}));
        System.out.println(solution.minInterval(new int[][]{{2,3},{2,5},{1,8},{20,25}},new int[]{2,19,5,22}));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] minInterval(int[][] intervals, int[] queries) {
            int n = intervals.length, m = queries.length;
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            int[][] qs = new int[m][0];
            for (int i = 0; i < m; ++i) {
                qs[i] = new int[] {queries[i], i};
            }
            Arrays.sort(qs, (a, b) -> a[0] - b[0]);
            int[] ans = new int[m];
            Arrays.fill(ans, -1);
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            int i = 0;
            for (int[] q : qs) {
                while (i < n && intervals[i][0] <= q[0]) {
                    int a = intervals[i][0], b = intervals[i][1];
                    pq.offer(new int[] {b - a + 1, b});
                    ++i;
                }
                while (!pq.isEmpty() && pq.peek()[1] < q[0]) {
                    pq.poll();
                }
                if (!pq.isEmpty()) {
                    ans[q[1]] = pq.peek()[0];
                }
            }
            return ans;
        }
    }


}
    //leetcode submit region end(Prohibit modification and deletion)

