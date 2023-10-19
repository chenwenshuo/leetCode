//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 1747 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最长连续序列
 * @author chenws
 * @date 2023-08-09 17:00:57
 */
public class P128_LongestConsecutiveSequence{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P128_LongestConsecutiveSequence().new Solution();
		System.out.println(solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
			if (nums.length==0)
				return 0;
			Arrays.sort(nums);
			int ans = 1;
			int tem = 1;
			for (int i = 0; i < nums.length-1; i++) {
				if (nums[i+1]-nums[i]==1){
					tem++;
					continue;
				}
				if(nums[i+1]==nums[i]){
					continue;
				}
				ans = Math.max(ans,tem);
				tem = 1;
			}
			return Math.max(ans,tem);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
