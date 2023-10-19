//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics 栈 数组 单调栈 👍 1626 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 每日温度
 * @author chenws
 * @date 2023-10-07 17:45:15
 */
public class P739_DailyTemperatures{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P739_DailyTemperatures().new Solution();
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures){
			int length = temperatures.length;
			int[] ans= new int[length];
			Deque<Integer> deque = new ArrayDeque<>();
			for (int i = 0; i < temperatures.length; i++) {
				while (!deque.isEmpty()&&temperatures[i]>temperatures[deque.peek()]){
					Integer pop = deque.pop();
					ans[pop]=i-pop;
				}
				deque.push(i);
			}
			return ans;
		}
}
//leetcode submit region end(Prohibit modification and deletion)

}
