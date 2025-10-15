//给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。在每一轮中，你可以完成 2 个或者 3 个 相同难度级别 的任
//务。 
//
// 返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：tasks = [2,2,3,3,2,4,4,4,4,4]
//输出：4
//解释：要想完成所有任务，一个可能的计划是：
//- 第一轮，完成难度级别为 2 的 3 个任务。 
//- 第二轮，完成难度级别为 3 的 2 个任务。 
//- 第三轮，完成难度级别为 4 的 3 个任务。 
//- 第四轮，完成难度级别为 4 的 2 个任务。 
//可以证明，无法在少于 4 轮的情况下完成所有任务，所以答案为 4 。
// 
//
// 示例 2： 
//
// 输入：tasks = [2,3,3]
//输出：-1
//解释：难度级别为 2 的任务只有 1 个，但每一轮执行中，只能选择完成 2 个或者 3 个相同难度级别的任务。因此，无法完成所有任务，答案为 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tasks.length <= 10⁵ 
// 1 <= tasks[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 哈希表 计数 👍 38 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 完成所有任务需要的最少轮数
 * @author chenws
 * @date 2024-05-14 11:36:40
 */
public class P2244_MinimumRoundsToCompleteAllTasks{
	public static void main(String[] args) {
		//测试代码
		Solution solution = new P2244_MinimumRoundsToCompleteAllTasks().new Solution();

		List<String> list = new ArrayList<>();
		list.add("1");
		test(list);
		System.out.println(list);
	}

	public static void test(List<String> list){
		list.clear();
		list = new ArrayList<>();
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumRounds(int[] tasks) {
		int ans = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for (int task : tasks) {
			Integer orDefault = map.getOrDefault(task, 0);
			map.put(task,orDefault+1);
		}
		for (Integer value : map.values()) {
			if (value<2) {
				return -1;
			}
			ans=value%3==0?value/3:value/3+1;
		}
		return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
