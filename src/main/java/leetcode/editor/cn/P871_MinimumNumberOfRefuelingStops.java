//汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。 
//
// 沿途有加油站，用数组 stations 表示。其中 stations[i] = [positioni, fueli] 表示第 i 个加油站位于出发位置东面
// positioni 英里处，并且有 fueli 升汽油。 
//
// 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。当汽车到达加油站时，它可能停下来加油，将所有汽
//油从加油站转移到汽车中。 
//
// 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。 
//
// 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 1, startFuel = 1, stations = []
//输出：0
//解释：可以在不加油的情况下到达目的地。
// 
//
// 示例 2： 
//
// 
//输入：target = 100, startFuel = 1, stations = [[10,100]]
//输出：-1
//解释：无法抵达目的地，甚至无法到达第一个加油站。
// 
//
// 示例 3： 
//
// 
//输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
//输出：2
//解释：
//出发时有 10 升燃料。
//开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
//然后，从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
//并将汽油从 10 升加到 50 升。然后开车抵达目的地。
//沿途在两个加油站停靠，所以返回 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target, startFuel <= 10⁹ 
// 0 <= stations.length <= 500 
// 1 <= positioni < positioni+1 < target 
// 1 <= fueli < 10⁹ 
// 
//
// Related Topics 贪心 数组 动态规划 堆（优先队列） 👍 419 👎 0


package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * 最低加油次数
 *
 * @author chenws
 * @date 2023-12-14 15:12:55
 */
public class P871_MinimumNumberOfRefuelingStops {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P871_MinimumNumberOfRefuelingStops().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minRefuelStops(int target, int startFuel, int[][] stations) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
            int n = stations.length, idx = 0;
            int remain = startFuel, loc = 0, ans = 0;
            while (loc < target) {
                if (remain == 0) {
                    if (!queue.isEmpty() && ++ans >= 0) {
                        remain += queue.poll();
                    } else {
                        return -1;
                    }
                }
                loc = remain;
                remain = 0;
                while (idx < n && stations[idx++][0] < loc) {
                    queue.offer(stations[idx][1]);
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
