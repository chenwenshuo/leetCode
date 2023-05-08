//给你一个整数数组 nums ，返回出现最频繁的偶数元素。 
//
// 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [0,1,2,2,4,4,1]
//输出：2
//解释：
//数组中的偶数元素为 0、2 和 4 ，在这些元素中，2 和 4 出现次数最多。
//返回最小的那个，即返回 2 。 
//
// 示例 2： 
//
// 输入：nums = [4,4,4,9,2,4]
//输出：4
//解释：4 是出现最频繁的偶数元素。
// 
//
// 示例 3： 
//
// 输入：nums = [29,47,21,41,13,37,25,7]
//输出：-1
//解释：不存在偶数元素。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2000 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 计数 👍 38 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 出现最频繁的偶数元素
 * @author chenws
 * @date 2023-04-13 11:35:21
 */
public class P2404_MostFrequentEvenElement{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P2404_MostFrequentEvenElement().new Solution();
		solution.mostFrequentEven1(null);
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mostFrequentEven(int[] nums) {
			Map<Integer, Integer> cnt = new HashMap<>();
			for (int x : nums) {
				if (x % 2 == 0) {
					cnt.merge(x, 1, Integer::sum);
				}
			}
			int ans = -1, mx = 0;
			for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
				int x = e.getKey(), v = e.getValue();
				if (mx < v || (mx == v && ans > x)) {
					ans = x;
					mx = v;
				}
			}
			return ans;

    }

		public int mostFrequentEven1(int[] nums) {

			List<Good> list =new ArrayList<>();
			list.add(new Good("1","2"));
			list.add(new Good("a","b"));

			list.stream().peek(good -> {
				good.setA("s");
				good.setB("S");
			}).forEach(System.out::println);
			return 1;
		}

		class Good{

			String a;
			String b;

			public String getA() {
				return a;
			}

			public void setA(String a) {
				this.a = a;
			}

			public String getB() {
				return b;
			}

			public void setB(String b) {
				this.b = b;
			}

			@Override
			public String toString() {
				return "Good{" +
					"a='" + a + '\'' +
					", b='" + b + '\'' +
					'}';
			}

			public Good(String a, String b) {
				this.a = a;
				this.b = b;
			}
		}
}
//leetcode submit region end(Prohibit modification and deletion)

}
