//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 请你实现时间复杂度为 
//O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics 数组 哈希表 👍 1810 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 缺失的第一个正数
 * @author chenws
 * @date 2023-05-06 22:54:08
 */
public class P41_FirstMissingPositive{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P41_FirstMissingPositive().new Solution();

		List list = new ArrayList<>();
		list.addAll(new ArrayList());
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
			Arrays.sort(nums);
			int ans =1;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i]==ans){
					ans++;
				}

			}

return ans;
    }

		public int runeReserve(int[] runes) {
			int ans = 1;
			Arrays.sort(runes);
			int tem=1;
			for (int i = 1; i < runes.length; i++) {
				if (runes[i]-runes[i-1]==1){
					tem++;
				}else {
					tem=1;
				}
				ans =Math.max(ans,tem);
			}
			return ans;

		}

		//随着兽群逐渐远去，一座大升降机缓缓的从地下升到了远征队面前。借由这台升降机，他们将能够到达地底的永恒至森。
		//在升降机的操作台上，是一个由魔法符号组成的矩阵，为了便于辨识，我们用小写字母来表示。 matrix[i][j] 表示矩阵第 i 行 j 列的字母。该矩阵上有一个提取装置，可以对所在位置的字母提取。
		//提取装置初始位于矩阵的左上角 [0,0]，可以通过每次操作移动到上、下、左、右相邻的 1 格位置中。提取装置每次移动或每次提取均记为一次操作。
		//
		//远征队需要按照顺序，从矩阵中逐一取出字母以组成 mantra，才能够成功的启动升降机。请返回他们 最少 需要消耗的操作次数。如果无法完成提取，返回 -1。
		//
		//注意：
		//
		//提取装置可对同一位置的字母重复提取，每次提取一个
		//提取字母时，需按词语顺序依次提取
		//示例 1：
		//
		//输入：matrix = ["sd","ep"], mantra = "speed"
		//
		//输出：10
		//
		//解释：如下图所示
		//矩阵 (2).gif
		//
		//示例 2：
		//
		//输入：matrix = ["abc","daf","geg"]， mantra = "sad"
		//
		//输出：-1
		//
		//解释：矩阵中不存在 s ，无法提取词语
		//
		//提示：
		//
		//0 < matrix.length, matrix[i].length <= 100
		//0 < mantra.length <= 100
		//matrix 和 mantra 仅由小写字母组成

		public int extractMantra(String[] matrix, String mantra) {
			Map<Character, List<int[]>> map = new HashMap<>();
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length(); j++) {
					char c = matrix[i].charAt(j);
					if (!map.containsKey(c)) {
						map.put(c, new ArrayList<>());
					}
					map.get(c).add(new int[]{i, j});
				}
			}

			int steps = 0;
			int[] cur = new int[]{0, 0};
			if (!map.containsKey(mantra.charAt(0)) || map.get(mantra.charAt(0)).isEmpty()) {
				return -1;
			}
			for (int[] f : map.get(mantra.charAt(0))) {
				int[] tem = f;
				for (int i = 1; i < mantra.length(); i++) {
					char c= mantra.charAt(i);
					if (!map.containsKey(c) || map.get(c).isEmpty()) {
						return -1;
					}

					for (int[] ints : map.get(c)) {
						steps += Math.abs(ints[0]-tem[0])+Math.abs(ints[1]-tem[1]);
						tem = ints;
					}
			}

			}

			return 0;
		}


		public int extractMantra1(String[] matrix, String mantra) {
			int[][] temp = new int[matrix.length][matrix[0].length()];
			List<int[]> list = new ArrayList<>();
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length(); j++) {
					temp[i][j] =matrix[i].charAt(j);
					if (mantra.charAt(0)==matrix[i].charAt(j)){
						//list.add();
					}
				}
			}

			int steps = 0;

			return 0;
		}


	}
//leetcode submit region end(Prohibit modification and deletion)

}
