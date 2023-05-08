//共有 n 位员工，每位员工都有一个从 0 到 n - 1 的唯一 id 。 
//
// 给你一个二维整数数组 logs ，其中 logs[i] = [idi, leaveTimei] ： 
//
// 
// idi 是处理第 i 个任务的员工的 id ，且 
// leaveTimei 是员工完成第 i 个任务的时刻。所有 leaveTimei 的值都是 唯一 的。 
// 
//
// 注意，第 i 个任务在第 (i - 1) 个任务结束后立即开始，且第 0 个任务从时刻 0 开始。 
//
// 返回处理用时最长的那个任务的员工的 id 。如果存在两个或多个员工同时满足，则返回几人中 最小 的 id 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10, logs = [[0,3],[2,5],[0,9],[1,15]]
//输出：1
//解释：
//任务 0 于时刻 0 开始，且在时刻 3 结束，共计 3 个单位时间。
//任务 1 于时刻 3 开始，且在时刻 5 结束，共计 2 个单位时间。
//任务 2 于时刻 5 开始，且在时刻 9 结束，共计 4 个单位时间。
//任务 3 于时刻 9 开始，且在时刻 15 结束，共计 6 个单位时间。
//时间最长的任务是任务 3 ，而 id 为 1 的员工是处理此任务的员工，所以返回 1 。
// 
//
// 示例 2： 
//
// 
//输入：n = 26, logs = [[1,1],[3,7],[2,12],[7,17]]
//输出：3
//解释：
//任务 0 于时刻 0 开始，且在时刻 1 结束，共计 1 个单位时间。
//任务 1 于时刻 1 开始，且在时刻 7 结束，共计 6 个单位时间。
//任务 2 于时刻 7 开始，且在时刻 12 结束，共计 5 个单位时间。
//任务 3 于时刻 12 开始，且在时刻 17 结束，共计 5 个单位时间。
//时间最长的任务是任务 1 ，而 id 为 3 的员工是处理此任务的员工，所以返回 3 。
// 
//
// 示例 3： 
//
// 
//输入：n = 2, logs = [[0,10],[1,20]]
//输出：0
//解释：
//任务 0 于时刻 0 开始，且在时刻 10 结束，共计 10 个单位时间。
//任务 1 于时刻 10 开始，且在时刻 20 结束，共计 10 个单位时间。
//时间最长的任务是任务 0 和 1 ，处理这两个任务的员工的 id 分别是 0 和 1 ，所以返回最小的 0 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 500 
// 1 <= logs.length <= 500 
// logs[i].length == 2 
// 0 <= idi <= n - 1 
// 1 <= leaveTimei <= 500 
// idi != idi + 1 
// leaveTimei 按严格递增顺序排列 
// 
//
// Related Topics 数组 👍 30 👎 0


package leetcode.editor.cn;

/**
 * 处理用时最长的那个任务的员工
 * @author chenws
 * @date 2023-05-05 13:49:56
 */
public class P2432_TheEmployeeThatWorkedOnTheLongestTask{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P2432_TheEmployeeThatWorkedOnTheLongestTask().new Solution();
		//70
		//[[36,3],[1,5],[12,8],[25,9],[53,11],[29,12],[52,14]]
		//10
		//[[0,3],[2,5],[0,9],[1,15]]
		//System.out.println(solution.hardestWorker(70, new int[][]{{36, 3}, {1, 5}, {12, 8}, {25, 9}, {53, 11}, {29, 12}, {52, 14}}));
		System.out.println(solution.hardestWorker(10, new int[][]{{0,3}, {2, 5}, {0, 9}, {1, 15}}));
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hardestWorker(int n, int[][] logs) {
			int ansId = logs[0][0];
			int temp = logs[0][1];
			for (int i = 1; i < logs.length; i++) {
				int s = logs[i][1] - logs[i - 1][1];
				if (temp < s) {
					ansId = logs[i][0];
					temp = s;
				}
				if (temp == s) {
					ansId = Math.min(logs[i][0],ansId);

				}
			}

			return ansId;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
