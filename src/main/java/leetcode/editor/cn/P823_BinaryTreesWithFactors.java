//给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。 
//
// 用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。 
//
// 满足条件的二叉树一共有多少个？答案可能很大，返回 对 10⁹ + 7 取余 的结果。 
//
// 
//
// 示例 1: 
//
// 
//输入: arr = [2, 4]
//输出: 3
//解释: 可以得到这些二叉树: [2], [4], [4, 2, 2] 
//
// 示例 2: 
//
// 
//输入: arr = [2, 4, 5, 10]
//输出: 7
//解释: 可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2]. 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// 2 <= arr[i] <= 10⁹ 
// arr 中的所有值 互不相同 
// 
//
// Related Topics 数组 哈希表 动态规划 排序 👍 139 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 带因子的二叉树
 * @author chenws
 * @date 2023-08-29 10:04:35
 */
public class P823_BinaryTreesWithFactors{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P823_BinaryTreesWithFactors().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int numFactoredBinaryTrees(int[] arr) {
		final int mod = (int) 1e9 + 7;
		Arrays.sort(arr);
		int n = arr.length;
		long[] f = new long[n];
		Arrays.fill(f, 1);
		Map<Integer, Integer> idx = new HashMap<>(n);
		for (int i = 0; i < n; ++i) {
			idx.put(arr[i], i);
		}
		for (int i = 0; i < n; ++i) {
			int a = arr[i];
			for (int j = 0; j < i; ++j) {
				int b = arr[j];
				if (a % b == 0) {
					int c = a / b;
					if (idx.containsKey(c)) {
						int k = idx.get(c);
						f[i] = (f[i] + f[j] * f[k]) % mod;
					}
				}
			}
		}
		long ans = 0;
		for (long v : f) {
			ans = (ans + v) % mod;
		}
		return (int) ans;
	}
}


//leetcode submit region end(Prohibit modification and deletion)

}
