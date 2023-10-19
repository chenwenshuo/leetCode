//有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示
//水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。 
//
// 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足 
//xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。 
//
// 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。 
//
// 示例 1： 
//
// 
//输入：points = [[10,16],[2,8],[1,6],[7,12]]
//输出：2
//解释：气球可以用2支箭来爆破:
//-在x = 6处射出箭，击破气球[2,8]和[1,6]。
//-在x = 11处发射箭，击破气球[10,16]和[7,12]。 
//
// 示例 2： 
//
// 
//输入：points = [[1,2],[3,4],[5,6],[7,8]]
//输出：4
//解释：每个气球需要射出一支箭，总共需要4支箭。 
//
// 示例 3： 
//
// 
//输入：points = [[1,2],[2,3],[3,4],[4,5]]
//输出：2
//解释：气球可以用2支箭来爆破:
//- 在x = 2处发射箭，击破气球[1,2]和[2,3]。
//- 在x = 4处射出箭，击破气球[3,4]和[4,5]。 
//
// 
//
// 
// 
//
// 提示: 
//
// 
// 1 <= points.length <= 10⁵ 
// points[i].length == 2 
// -2³¹ <= xstart < xend <= 2³¹ - 1 
// 
//
// Related Topics 贪心 数组 排序 👍 855 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 用最少数量的箭引爆气球
 *
 * @author chenws
 * @date 2023-09-08 16:56:38
 */
public class P452_MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P452_MinimumNumberOfArrowsToBurstBalloons().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //[[10,16],[2,8],[1,6],[7,12]]
        //[[-2147483646,-2147483645],[2147483646,2147483647]]
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, (a, b) -> {
                if (a[0] - b[0] == 0) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });
            int ans = 1;
            int max = points[0][1];
            int min = points[0][0];
            for (int i = 1; i < points.length; i++) {
                if (points[i][0]>max){
                    ans++;
                    max = points[i][1];
                    min = points[i][0];
                }else {
                    max = Math.min(max,points[i][1]);
                    min = Math.max(min,points[i][0]);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
