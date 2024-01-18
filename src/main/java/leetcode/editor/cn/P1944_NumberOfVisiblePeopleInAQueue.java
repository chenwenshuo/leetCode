//有 n 个人排成一个队列，从左到右 编号为 0 到 n - 1 。给你以一个整数数组 heights ，每个整数 互不相同，heights[i] 表示第 
//i 个人的高度。 
//
// 一个人能 看到 他右边另一个人的条件是这两人之间的所有人都比他们两人 矮 。更正式的，第 i 个人能看到第 j 个人的条件是 i < j 且 min(
//heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]) 。 
//
// 请你返回一个长度为 n 的数组 answer ，其中 answer[i] 是第 i 个人在他右侧队列中能 看到 的 人数 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：heights = [10,6,8,5,11,9]
//输出：[3,1,2,1,1,0]
//解释：
//第 0 个人能看到编号为 1 ，2 和 4 的人。
//第 1 个人能看到编号为 2 的人。
//第 2 个人能看到编号为 3 和 4 的人。
//第 3 个人能看到编号为 4 的人。
//第 4 个人能看到编号为 5 的人。
//第 5 个人谁也看不到因为他右边没人。
// 
//
// 示例 2： 
//
// 
//输入：heights = [5,1,2,3,10]
//输出：[4,1,1,1,0]
// 
//
// 
//
// 提示： 
//
// 
// n == heights.length 
// 1 <= n <= 10⁵ 
// 1 <= heights[i] <= 10⁵ 
// heights 中所有数 互不相同 。 
// 
//
// Related Topics 栈 数组 单调栈 👍 97 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 队列中可以看到的人数
 *
 * @author chenws
 * @date 2024-01-05 11:34:49
 */
public class P1944_NumberOfVisiblePeopleInAQueue {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1944_NumberOfVisiblePeopleInAQueue().new Solution();
       // System.out.println(Arrays.toString(solution.canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9})));
        System.out.println(Arrays.toString(new int[]{32,7,21,47,2,12,19,17,5,51,48,50,3,16,4,45,27,43,49,37,10,24,42,11,18,44,28,46,15,29,23,20,36,8,33,14,22,38,9,1,40,13,6,26,30,35,34,41}));
        System.out.println(Arrays.toString(solution.canSeePersonsCount(new int[]{ 38, 9, 1, 40, 13, 6, 26, 30, 35, 34,41 })));
      //  System.out.println(Arrays.toString(solution.canSeePersonsCount(new int[]{ 32,7,21,47,2,12,19,17,5,51,48,50,3,16,4,45,27,43,49,37,10,24,42,11,18,44,28,46,15,29,23,20,36,8,33,14,22,38,9,1,40,13,6,26,30,35,34,41 })));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] canSeePersonsCount(int[] heights) {
            int length = heights.length;
            int[] ans = new int[length];
            Deque<Integer> deque = new LinkedList<>();
            //[10,6,8,5,11,9]
            //[3,2,2,1,1,0]
            //预期结果
            //[3,1,2,1,1,0]
            int[] k = new int[length];
            for (int i = length - 1; i >= 0; i--) {
                int height = heights[i];
                int t =0;
                while (!deque.isEmpty() && height >= deque.peek()) {
                    deque.poll();
                    t++;
                }
                if (!deque.isEmpty()){
                    t++;
                }
                k[i] = t;
                deque.push(height);
            }
            //2,2,1,5,2,1,1,1,2,1,0

            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
