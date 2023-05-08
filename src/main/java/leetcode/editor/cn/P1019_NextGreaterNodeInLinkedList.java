//给定一个长度为 n 的链表 head 
//
// 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。 
//
// 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点
//，设置 answer[i] = 0 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [2,1,5]
//输出：[5,5,0]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [2,7,4,3,5]
//输出：[7,0,5,5,0]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数为 n 
// 1 <= n <= 10⁴ 
// 1 <= Node.val <= 10⁹ 
// 
//
// Related Topics 栈 数组 链表 单调栈 👍 282 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 链表中的下一个更大节点
 * @author chenws
 * @date 2023-04-10 17:26:28
 */
public class P1019_NextGreaterNodeInLinkedList{

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1019_NextGreaterNodeInLinkedList().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
       // 8 2 3 1 5 2 9
    public int[] nextLargerNodes(ListNode head) {
        int a = 0;
        Stack<Integer[]> stack = new Stack<>();
        List<Integer[]> list = new ArrayList<>();
        while (head!=null){

            while (!stack.empty()&&stack.peek()[1]<head.val){
                Integer[] pop = stack.pop();
                list.add(new Integer[]{pop[0],head.val});
            }
            stack.push(new Integer[]{a,head.val});
            a++;
            head = head.next;
        }
        int[] ans = new int[a];
        for (Integer[] integers : list) {
            ans[integers[0]] = integers[1];
        }
        while (!stack.empty()){
            Integer[] pop = stack.pop();
            ans[pop[0]] =pop[1];
        }
        return ans;
    }
    //Deque<Integer> st = new ArrayDeque<>()
    public int[] nextLargerNodes1(ListNode head) {
        int a = 0;
        Deque<Integer[]> stack = new ArrayDeque<>();
        List<Integer[]> list = new ArrayList<>();
        while (head!=null){

            while (!stack.isEmpty()&&stack.peek()[1]<head.val){
                Integer[] pop = stack.pop();
                list.add(new Integer[]{pop[0],head.val});
            }
            stack.push(new Integer[]{a,head.val});
            a++;
            head = head.next;
        }
        int[] ans = new int[a];
        for (Integer[] integers : list) {
            ans[integers[0]] = integers[1];
        }
        while (!stack.isEmpty()){
            Integer[] pop = stack.pop();
            ans[pop[0]] =pop[1];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
