package leetcode.editor.cn;

//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 459 👎 0

import java.util.*;
import java.util.stream.Collectors;

public class HuaDongChuangKouDeZuiDaZhiLcof{
         public static void main(String[] args) {

         }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null||nums.length==0) return new int[]{};
        int length = nums.length;

        int l=0;

        boolean f=true;
        int[] ans = new int[length - k + 1];
        int tem=nums[0];

        while (l+k<=length){
          if (f){
               tem=nums[l];
              for (int i = l; i < k+l; i++) {
                  tem=Math.max(tem,nums[i]);
              }

          }else {
              tem=Math.max(tem,nums[l+k-1]);
          }
            if (tem==nums[l]) f=true;
            ans[l]=tem;
            l++;


        }

        return ans;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums==null||nums.length==0) return new int[]{};
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
