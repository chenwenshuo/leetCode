//给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 5
//输出：[-7,-1,1,3,4]
//解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
// 
//
// 示例 2： 
//
// 输入：n = 3
//输出：[-1,0,1]
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
//
// Related Topics 数组 数学 👍 74 👎 0


package leetcode.editor.cn;

/**
 * 和为零的 N 个不同整数
 * @author chenws
 * @date 2023-06-17 16:35:13
 */
public class P1304_FindNUniqueIntegersSumUpToZero{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P1304_FindNUniqueIntegersSumUpToZero().new Solution();
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sumZero(int n) {
			int [] ans = new int[n];
			int tem  = 0;
			for (int i = 0; i < ans.length-1; i++) {
				ans[i]=i+1;
				tem+=i+1;
			}
			ans[n-1]=-tem;
			return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
