//给出基数为 -2 的两个数 arr1 和 arr2，返回两数相加的结果。 
//
// 数字以 数组形式 给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。例如，arr = [1,1,0,1] 表示数字 (-2)^3 +
// (-2)^2 + (-2)^0 = -3。数组形式 中的数字 arr 也同样不含前导零：即 arr == [0] 或 arr[0] == 1。 
//
// 返回相同表示形式的 arr1 和 arr2 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr1 = [1,1,1,1,1], arr2 = [1,0,1]
//输出：[1,0,0,0,0]
//解释：arr1 表示 11，arr2 表示 5，输出表示 16 。
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：arr1 = [0], arr2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：arr1 = [0], arr2 = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// arr1[i] 和 arr2[i] 都是 0 或 1 
// arr1 和 arr2 都没有前导0 
// 
//
// Related Topics 数组 数学 👍 75 👎 0


package leetcode.editor.cn;

/**
 * 负二进制数相加
 * @author chenws
 * @date 2023-05-18 10:17:55
 */
public class P1073_AddingTwoNegabinaryNumbers{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1073_AddingTwoNegabinaryNumbers().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
			return null;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
