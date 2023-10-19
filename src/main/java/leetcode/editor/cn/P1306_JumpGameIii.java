//这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - 
//arr[i]。 
//
// 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。 
//
// 注意，不管是什么情况下，你都无法跳到数组之外。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [4,2,3,0,3,1,2], start = 5
//输出：true
//解释：
//到达值为 0 的下标 3 有以下可能方案： 
//下标 5 -> 下标 4 -> 下标 1 -> 下标 3 
//下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3 
// 
//
// 示例 2： 
//
// 输入：arr = [4,2,3,0,3,1,2], start = 0
//输出：true 
//解释：
//到达值为 0 的下标 3 有以下可能方案： 
//下标 0 -> 下标 4 -> 下标 1 -> 下标 3
// 
//
// 示例 3： 
//
// 输入：arr = [3,0,2,1,2], start = 2
//输出：false
//解释：无法到达值为 0 的下标 1 处。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 5 * 10^4 
// 0 <= arr[i] < arr.length 
// 0 <= start < arr.length 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数组 👍 148 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 跳跃游戏 III
 *
 * @author chenws
 * @date 2023-06-17 16:16:34
 */
public class P1306_JumpGameIii {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1306_JumpGameIii().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canReach(int[] arr, int start) {
            boolean[] b = new boolean[arr.length];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(start);
            if (arr[start] == 0) {
                return true;
            }
            b[start] = true;
            while (!queue.isEmpty()) {
                Integer tem = queue.poll();

                int i = arr[tem];
                int a = tem - i;
                if (a >= 0 && !b[a]) {
                    if (arr[a] == 0) {
                        return true;
                    }
                    queue.offer(a);
                    b[a] = true;
                }
                a = tem + i;
                if (a < arr.length && !b[a]) {
                    if (arr[a] == 0) {
                        return true;
                    }
                    queue.offer(a);
                    b[a] = true;
                }
            }

            return false;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
