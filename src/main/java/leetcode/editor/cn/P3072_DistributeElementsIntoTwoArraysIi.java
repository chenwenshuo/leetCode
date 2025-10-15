//给你一个下标从 1 开始、长度为 n 的整数数组 nums 。 
//
// 现定义函数 greaterCount ，使得 greaterCount(arr, val) 返回数组 arr 中 严格大于 val 的元素数量。 
//
// 你需要使用 n 次操作，将 nums 的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二
//次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中： 
//
// 
// 如果 greaterCount(arr1, nums[i]) > greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 
//arr1 。 
// 如果 greaterCount(arr1, nums[i]) < greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 
//arr2 。 
// 如果 greaterCount(arr1, nums[i]) == greaterCount(arr2, nums[i]) ，将 nums[i] 追加到元
//素数量较少的数组中。 
// 如果仍然相等，那么将 nums[i] 追加到 arr1 。 
// 
//
// 连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 
//result = [1,2,3,4,5,6] 。 
//
// 返回整数数组 result 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,3,3]
//输出：[2,3,1,3]
//解释：在前两次操作后，arr1 = [2] ，arr2 = [1] 。
//在第 3 次操作中，两个数组中大于 3 的元素数量都是零，并且长度相等，因此，将 nums[3] 追加到 arr1 。
//在第 4 次操作中，两个数组中大于 3 的元素数量都是零，但 arr2 的长度较小，因此，将 nums[4] 追加到 arr2 。
//在 4 次操作后，arr1 = [2,3] ，arr2 = [1,3] 。
//因此，连接形成的数组 result 是 [2,3,1,3] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,14,3,1,2]
//输出：[5,3,1,2,14]
//解释：在前两次操作后，arr1 = [5] ，arr2 = [14] 。
//在第 3 次操作中，两个数组中大于 3 的元素数量都是一，并且长度相等，因此，将 nums[3] 追加到 arr1 。
//在第 4 次操作中，arr1 中大于 1 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[4] 追加到 arr1 。
//在第 5 次操作中，arr1 中大于 2 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[5] 追加到 arr1 。
//在 5 次操作后，arr1 = [5,3,1,2] ，arr2 = [14] 。
//因此，连接形成的数组 result 是 [5,3,1,2,14] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3,3,3]
//输出：[3,3,3,3]
//解释：在 4 次操作后，arr1 = [3,3] ，arr2 = [3,3] 。
//因此，连接形成的数组 result 是 [3,3,3,3] 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 树状数组 线段树 数组 模拟 👍 34 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 将元素分配到两个数组中 II
 * @author chenws
 * @date 2024-06-05 15:56:46
 */
public class P3072_DistributeElementsIntoTwoArraysIi{
	public static void main(String[] args) {
		//测试代码
		Solution solution = new P3072_DistributeElementsIntoTwoArraysIi().new Solution();
		System.out.println(Arrays.toString(solution.resultArray(new int[]{9, 58, 43, 42, 46, 25, 38, 2, 42, 72, 54, 96, 78, 44, 2, 52, 74, 70, 66, 8})));
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] resultArray(int[] nums) {
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();

		TreeSet<Integer> atreeSet= new TreeSet<>();
		TreeSet<Integer> btreeSet= new TreeSet<>();

		a.add(nums[0]);
		b.add(nums[1]);
		atreeSet.add(nums[0]);
		btreeSet.add(nums[1]);
		for (int i = 2; i < nums.length; i++) {
			int num = nums[i];
			int c1 = greaterCount(a,num,atreeSet);
			int c2 = greaterCount(b,num,btreeSet);
			System.out.println("--------------------"+num);
			if (c1>c2){
				a.add(num);
				atreeSet.add(num);
			}else if (c1<c2){
				b.add(num);
				btreeSet.add(num);
			}else {
				if (a.size()<b.size()){
					a.add(num);
					atreeSet.add(num);
				}else if (a.size()>b.size()){
					b.add(num);
					btreeSet.add(num);
				}else {
					a.add(num);
					atreeSet.add(num);
				}
			}
			System.out.println("a:"+i+"==="+a);
			System.out.println("b:"+i+"==="+b);
		}
		int[] ans = new  int[nums.length];
		int x = 0;
		for (Integer integer : a) {
			ans[x++]=integer;
		}
		for (Integer integer : b) {
			ans[x++]=integer;
		}
		System.out.println("========");
		System.out.println(a);
		System.out.println(b);
		return ans;

    }

		private int greaterCount(List<Integer> a, int num, TreeSet<Integer> atreeSet) {
			Set<Integer> integers = atreeSet.tailSet(num, false);
			return integers.size();
		}
}
//leetcode submit region end(Prohibit modification and deletion)

}
