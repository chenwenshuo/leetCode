//给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目： 
//
// 
// 0 <= i < j < k < nums.length 
// nums[i]、nums[j] 和 nums[k] 两两不同 。 
// 
// 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。 
// 
// 
//
// 返回满足上述条件三元组的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,4,2,4,3]
//输出：3
//解释：下面列出的三元组均满足题目条件：
//- (0, 2, 4) 因为 4 != 2 != 3
//- (1, 2, 4) 因为 4 != 2 != 3
//- (2, 3, 4) 因为 2 != 4 != 3
//共计 3 个三元组，返回 3 。
//注意 (2, 0, 4) 不是有效的三元组，因为 2 > 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,1,1]
//输出：0
//解释：不存在满足条件的三元组，所以返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 100 
// 1 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 👍 55 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * 数组中不等三元组的数目
 * @author chenws
 * @date 2023-06-13 11:33:04
 */
public class P2475_NumberOfUnequalTripletsInArray{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P2475_NumberOfUnequalTripletsInArray().new Solution();
		System.out.println(solution.unequalTriplets(new int[]{4,4,2,4,3}));
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

		int asn =0;
		int vst[] ;
    public int unequalTriplets(int[] nums) {
			List<Integer> set =new LinkedList<>();
			vst=new int[nums.length];
			dfs(nums,0,set);
			return asn;

    }

		private void dfs(int[] nums, int a, List<Integer> set) {
			if (set.size()==3){
			asn++;
				return;
			}
			for (int i = a; i < nums.length; i++) {
				if (set.contains(nums[i])&&vst[i]==1){
					continue;
				}
				set.add(nums[i]);
				vst[i]=1;
				dfs(nums,i+1,set);
				set.remove(set.size()-1);
				vst[i]=0;
			}
		}



		public int unequalTriplets1(int[] nums) {
			int ans = 0;
			boolean[] visit = new boolean[nums.length];
			List<Integer> l = new LinkedList<>();
			int[] ansArr = new int[1];
			dfs(nums, 0, 0, visit, l, ansArr);
			ans = ansArr[0];

			return ans;
		}


		private void dfs(int[] nums, int index, int curIdx, boolean[] visit, List<Integer> s, int[] ans) {
			if (index == 3) {
				ans[0]++;
				System.out.println(s);
				return;
			}

			for (int i = curIdx; i < nums.length; i++) {
				if (visit[i] || s.contains(nums[i])) {
					continue;
				}
				s.add(nums[i]);
				visit[i] = true;
				dfs(nums, index + 1, i + 1, visit, s, ans);
				visit[i] = false;
				s.remove(s.size() - 1);
			}
		}


}
//leetcode submit region end(Prohibit modification and deletion)

}
