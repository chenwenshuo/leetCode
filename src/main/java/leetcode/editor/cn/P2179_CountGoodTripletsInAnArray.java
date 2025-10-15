//给你两个下标从 0 开始且长度为 n 的整数数组 nums1 和 nums2 ，两者都是 [0, 1, ..., n - 1] 的 排列 。 
//
// 好三元组 指的是 3 个 互不相同 的值，且它们在数组 nums1 和 nums2 中出现顺序保持一致。换句话说，如果我们将 pos1v 记为值 v 在 
//nums1 中出现的位置，pos2v 为值 v 在 nums2 中的位置，那么一个好三元组定义为 0 <= x, y, z <= n - 1 ，且 pos1x 
//< pos1y < pos1z 和 pos2x < pos2y < pos2z 都成立的 (x, y, z) 。 
//
// 请你返回好三元组的 总数目 。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [2,0,1,3], nums2 = [0,1,2,3]
//输出：1
//解释：
//总共有 4 个三元组 (x,y,z) 满足 pos1x < pos1y < pos1z ，分别是 (2,0,1) ，(2,0,3) ，(2,1,3) 和 (
//0,1,3) 。
//这些三元组中，只有 (0,1,3) 满足 pos2x < pos2y < pos2z 。所以只有 1 个好三元组。
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,0,1,3,2], nums2 = [4,1,0,2,3]
//输出：4
//解释：总共有 4 个好三元组 (4,0,3) ，(4,0,2) ，(4,1,3) 和 (4,1,2) 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length == nums2.length 
// 3 <= n <= 10⁵ 
// 0 <= nums1[i], nums2[i] <= n - 1 
// nums1 和 nums2 是 [0, 1, ..., n - 1] 的排列。 
// 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 108 👎 0


package leetcode.editor.cn;

/**
 * 统计数组中好三元组数目
 * @author chenws
 * @date 2025-09-03 17:40:09
 */
public class P2179_CountGoodTripletsInAnArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P2179_CountGoodTripletsInAnArray().new Solution();
		  //nums1 = [4,0,1,3,2], nums2 = [4,1,0,2,3]
		 System.out.println(solution.goodTriplets(new int[]{4,0,1,3,2},new int[]{4,1,0,2,3}));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int[] pos2 = new int[n];
		for (int i = 0; i < n; i++) {
			pos2[nums2[i]] = i;
		}
		int[] indexMapping = new int[n];
		for (int i = 0; i < n; i++) {
			int i1 = pos2[nums1[i]];
			System.out.println(i1);
			indexMapping[i] = pos2[nums1[i]] + 1;
		}

		FenwickTree tree = new FenwickTree(n);
		long res = 0;
		for (int i = 0; i < n; i++) {
			int left = tree.query(indexMapping[i] - 1);
			int right = (n - 1 - i) - (indexMapping[i] - 1 - left);
			res += (long) left * right;
			tree.add(indexMapping[i], 1);
		}
		return res;

    }

	class FenwickTree{
		int size;
		int[] nums;
		public FenwickTree(int size){
			this.size = size+1;
			nums=new int[this.size];
		}
		private int lowbit(int i){
			return i&(-i);
		}
		public void add(int index,int t){
			while (index<size){
				nums[index]+=t;
				index+=lowbit(index);
			}
		}

		public int query(int index){
			int sum =0;
			while (index>0){
				sum+=nums[index];
				index-=lowbit(index);
			}
			return sum;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
