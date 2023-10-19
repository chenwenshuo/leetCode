//给你一个长度为 n 、下标从 1 开始的二进制字符串，所有位最开始都是 0 。我们会按步翻转该二进制字符串的所有位（即，将 0 变为 1）。 
//
// 给你一个下标从 1 开始的整数数组 flips ，其中 flips[i] 表示对应下标 i 的位将会在第 i 步翻转。 
//
// 二进制字符串 前缀一致 需满足：在第 i 步之后，在 闭 区间 [1, i] 内的所有位都是 1 ，而其他位都是 0 。 
//
// 返回二进制字符串在翻转过程中 前缀一致 的次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：flips = [3,2,4,1,5]
//输出：2
//解释：二进制字符串最开始是 "00000" 。
//执行第 1 步：字符串变为 "00100" ，不属于前缀一致的情况。
//执行第 2 步：字符串变为 "01100" ，不属于前缀一致的情况。
//执行第 3 步：字符串变为 "01110" ，不属于前缀一致的情况。
//执行第 4 步：字符串变为 "11110" ，属于前缀一致的情况。
//执行第 5 步：字符串变为 "11111" ，属于前缀一致的情况。
//在翻转过程中，前缀一致的次数为 2 ，所以返回 2 。
// 
//
// 示例 2： 
//
// 
//输入：flips = [4,1,2,3]
//输出：1
//解释：二进制字符串最开始是 "0000" 。
//执行第 1 步：字符串变为 "0001" ，不属于前缀一致的情况。
//执行第 2 步：字符串变为 "1001" ，不属于前缀一致的情况。
//执行第 3 步：字符串变为 "1101" ，不属于前缀一致的情况。
//执行第 4 步：字符串变为 "1111" ，属于前缀一致的情况。
//在翻转过程中，前缀一致的次数为 1 ，所以返回 1 。 
//
// 
//
// 提示： 
//
// 
// n == flips.length 
// 1 <= n <= 5 * 10⁴ 
// flips 是范围 [1, n] 中所有整数构成的一个排列 
// 
//
// Related Topics 数组 👍 108 👎 0


package leetcode.editor.cn;

/**
 * 二进制字符串前缀一致的次数
 * @author chenws
 * @date 2023-06-14 16:42:24
 */
public class P1375_NumberOfTimesBinaryStringIsPrefixAligned{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P1375_NumberOfTimesBinaryStringIsPrefixAligned().new Solution();
		System.out.println(solution.numTimesAllBlue(new int[]{3,2,4,1,5}));
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

		///输入：flips = [3,2,4,1,5]
		////输出：2
		////解释：二进制字符串最开始是 "00000" 。
		////执行第 1 步：字符串变为 "00100" ，不属于前缀一致的情况。
		////执行第 2 步：字符串变为 "01100" ，不属于前缀一致的情况。
		////执行第 3 步：字符串变为 "01110" ，不属于前缀一致的情况。
		////执行第 4 步：字符串变为 "11110" ，属于前缀一致的情况。
		////执行第 5 步：字符串变为 "11111" ，属于前缀一致的情况。
		////在翻转过程中，前缀一致的次数为 2 ，所以返回 2 。
    public int numTimesAllBlue(int[] flips) {
			int ans =0;
			int max=0;
			for (int i = 0; i < flips.length; i++) {
				int tem = flips[i]-1;
				max = Math.max(tem,max);
				if (max==i){
					ans++;
				}
			}
			return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
