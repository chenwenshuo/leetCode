//给你一个数组 points 和一个整数 k 。数组中每个元素都表示二维平面上的点的坐标，并按照横坐标 x 的值从小到大排序。也就是说 points[i] =
// [xi, yi] ，并且在 1 <= i < j <= points.length 的前提下， xi < xj 总成立。 
//
// 请你找出 yi + yj + |xi - xj| 的 最大值，其中 |xi - xj| <= k 且 1 <= i < j <= points.
//length。 
//
// 题目测试数据保证至少存在一对能够满足 |xi - xj| <= k 的点。 
//
// 
//
// 示例 1： 
//
// 输入：points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
//输出：4
//解释：前两个点满足 |xi - xj| <= 1 ，代入方程计算，则得到值 3 + 0 + |1 - 2| = 4 。第三个和第四个点也满足条件，得到值 1
//0 + -10 + |5 - 6| = 1 。
//没有其他满足条件的点，所以返回 4 和 1 中最大的那个。 
//
// 示例 2： 
//
// 输入：points = [[0,0],[3,0],[9,2]], k = 3
//输出：3
//解释：只有前两个点满足 |xi - xj| <= 3 ，代入方程后得到值 0 + 0 + |0 - 3| = 3 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= points.length <= 10^5 
// points[i].length == 2 
// -10^8 <= points[i][0], points[i][1] <= 10^8 
// 0 <= k <= 2 * 10^8 
// 对于所有的1 <= i < j <= points.length ，points[i][0] < points[j][0] 都成立。也就是说，xi 是严格
//递增的。 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 118 👎 0


package leetcode.editor.cn;

/**
 * 满足不等式的最大值
 * @author chenws
 * @date 2023-07-21 17:21:23
 */
public class P1499_MaxValueOfEquation{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1499_MaxValueOfEquation().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
			return 0;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
