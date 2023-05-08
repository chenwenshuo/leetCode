//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2150 👎 0


package leetcode.editor.cn;

import com.sun.jmx.remote.internal.ArrayQueue;
import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 * @author chenws
 * @date 2023-04-27 18:02:23
 */
public class P215_KthLargestElementInAnArray{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P215_KthLargestElementInAnArray().new Solution();
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {

			int ans=0;
			PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
			for (int i = 0; i < nums.length; i++) {
				queue.add(nums[i]);
			}

			for (int i = 0; i < k-1; i++) {
				queue.poll();
			}

			return queue.poll();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
