//给你 n 个项目，编号从 0 到 n - 1 。同时给你一个整数数组 milestones ，其中每个 milestones[i] 表示第 i 个项目中的阶
//段任务数量。 
//
// 你可以按下面两个规则参与项目中的工作： 
//
// 
// 每周，你将会完成 某一个 项目中的 恰好一个 阶段任务。你每周都 必须 工作。 
// 在 连续的 两周中，你 不能 参与并完成同一个项目中的两个阶段任务。 
// 
//
// 一旦所有项目中的全部阶段任务都完成，或者仅剩余一个阶段任务都会导致你违反上面的规则，那么你将 停止工作 。注意，由于这些条件的限制，你可能无法完成所有阶段
//任务。 
//
// 返回在不违反上面规则的情况下你 最多 能工作多少周。 
//
// 
//
// 示例 1： 
//
// 
//输入：milestones = [1,2,3]
//输出：6
//解释：一种可能的情形是：
//​​​​- 第 1 周，你参与并完成项目 0 中的一个阶段任务。
//- 第 2 周，你参与并完成项目 2 中的一个阶段任务。
//- 第 3 周，你参与并完成项目 1 中的一个阶段任务。
//- 第 4 周，你参与并完成项目 2 中的一个阶段任务。
//- 第 5 周，你参与并完成项目 1 中的一个阶段任务。
//- 第 6 周，你参与并完成项目 2 中的一个阶段任务。
//总周数是 6 。
// 
//
// 示例 2： 
//
// 
//输入：milestones = [5,2,1]
//输出：7
//解释：一种可能的情形是：
//- 第 1 周，你参与并完成项目 0 中的一个阶段任务。
//- 第 2 周，你参与并完成项目 1 中的一个阶段任务。
//- 第 3 周，你参与并完成项目 0 中的一个阶段任务。
//- 第 4 周，你参与并完成项目 1 中的一个阶段任务。
//- 第 5 周，你参与并完成项目 0 中的一个阶段任务。
//- 第 6 周，你参与并完成项目 2 中的一个阶段任务。
//- 第 7 周，你参与并完成项目 0 中的一个阶段任务。
//总周数是 7 。
//注意，你不能在第 8 周参与完成项目 0 中的最后一个阶段任务，因为这会违反规则。
//因此，项目 0 中会有一个阶段任务维持未完成状态。 
//
// 
//
// 提示： 
//
// 
// n == milestones.length 
// 1 <= n <= 10⁵ 
// 1 <= milestones[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 👍 90 👎 0


package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * 你可以工作的最大周数
 * @author chenws
 * @date 2024-05-16 17:08:17
 */
public class P1953_MaximumNumberOfWeeksForWhichYouCanWork{
	public static void main(String[] args) {
		//测试代码
		Solution solution = new P1953_MaximumNumberOfWeeksForWhichYouCanWork().new Solution();
		System.out.println(solution.numberOfWeeks(new int[]{1,2,3}));
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long numberOfWeeks(int[] milestones) {
		int ans=0;
		PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->b[1]-a[1]);
		for (int i = 0; i < milestones.length; i++) {
			queue.add(new int[]{i,milestones[i]});
		}
		int t=-1;
		while (!queue.isEmpty()){
			int[] poll = queue.poll();
			if (poll[0]!=t){
				ans++;
				if (poll[1]!=1){
					poll[1]--;
					queue.add(poll);
					t = poll[0];
				}else {
					t=-1;
				}

			}else {
				if (queue.isEmpty()){
					return ans;
				}
				ans++;
				int[] poll1 = queue.poll();
				if (poll1[1]!=1){
					poll1[1]--;
					queue.add(poll1);
					t = poll1[0];
				}else {
					t=-1;
				}
				queue.add(poll);

			}
		}
		return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
