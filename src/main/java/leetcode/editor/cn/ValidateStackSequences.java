package leetcode.editor.cn;

//给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时
//，返回 true；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 示例 2： 
//
// 
//输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pushed.length <= 1000 
// 0 <= pushed[i] <= 1000 
// pushed 的所有元素 互不相同 
// popped.length == pushed.length 
// popped 是 pushed 的一个排列 
// 
//
// Related Topics 栈 数组 模拟 👍 319 👎 0

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ValidateStackSequences{
         public static void main(String[] args) {
            Solution solution = new ValidateStackSequences().new Solution();
             System.out.println(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4,3,5,1,2}));
         }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Deque<Integer> stack=new LinkedList<>();
        //Stack stack1=new Stack(); stack 比LinkedList 效率低
        /**
         * Stack：基于数组实现，随机访问（查找）效率更高，增删改效率较低       执行耗时:4 ms,击败了16.24% 的Java用户
         * LinkedList：基于链表实现，增删改效率更高，随机访问（查找）效率较低   执行耗时:1 ms,击败了95.71% 的Java用户
         */
        int length = pushed.length;
        int phl=0;
        int ppl=0;
        while (ppl<length){
            if (stack.peek()!=null&&popped[ppl]==stack.peek()){
                stack.pop();
                ppl++;
            } else if (phl<length){
                stack.push(pushed[phl]);
                phl++;
            }else {
                return false;
            }

        }

        return stack.size()==0;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
