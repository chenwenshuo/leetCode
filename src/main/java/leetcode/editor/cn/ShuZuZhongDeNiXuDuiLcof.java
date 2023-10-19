//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 1041 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import javax.swing.plaf.IconUIResource;

/**
 * 数组中的逆序对
 * @author chenws
 * @date 2023-08-12 18:38:36
 */
public class ShuZuZhongDeNiXuDuiLcof {

	public static void main(String[] args) {
		//测试代码
		Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
		System.out.println(solution.reversePairs(new int[]{1,3,2,3,1}));
	}

	//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)


	class Solution {

		Map<Integer, Integer> map;

		public int reversePairs(int[] nums) {
			map = new HashMap<>();
			int ans = 0;
			dfs(0, nums);
			for (Integer value : map.values()) {
				ans+=value;
			}
			return ans;

		}

		private int dfs(int index, int[] nums) {
			if (index >= nums.length - 1) {
				return 0;
			}
			int a = 0;
			for (int i = index + 1; i < nums.length; i++) {
				if (nums[index] > nums[i]) {
					if (map.containsKey(i)) {
						a = a + map.get(i) + 1;
					} else {
						int b= dfs(i, nums);
						a += b+1;
					}
				}else {
					dfs(i,nums);
				}

			}
			map.put(index,a);
			return a;
		}
		//leetcode submit region end(Prohibit modification and deletion)

	}
}
