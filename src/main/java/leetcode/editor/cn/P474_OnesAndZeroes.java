//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。 
//
// 
// 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。 
// 
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 
//n 的值 3 。
// 
//
// 示例 2： 
//
// 
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] 仅由 '0' 和 '1' 组成 
// 1 <= m, n <= 100 
// 
//
// Related Topics 数组 字符串 动态规划 👍 1287 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 一和零
 * @author chenws
 * @date 2025-11-11 14:59:34
 */
public class P474_OnesAndZeroes{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P474_OnesAndZeroes().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 int ans;
		 int tem;
		 List<int[]> list;
    public int findMaxForm(String[] strs, int m, int n) {
    	ans = 0;
		tem=0;
		list = new ArrayList<>();
		for (String str : strs) {
			list.add(getZAndO(str));
		}
		dfs(strs,m,n,0);
		return ans;
	}

	private void dfs(String[] strings,int m,int n,int index){
		if (n<0||m<0) return;
		ans = Math.max(ans,tem);

		for (int i = index; i < strings.length; i++) {
			//String s = strings[i];
			int[] zAndO = list.get(i);
			tem++;
			dfs(strings,m-zAndO[0],n-zAndO[1],i+1);
			tem--;
		}
	}
	private int[] getZAndO(String s){
		int[] ans =new int[2];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='0'){
				ans[0]++;
			}else {
				ans[1]++;
			}
		}
		return ans;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
