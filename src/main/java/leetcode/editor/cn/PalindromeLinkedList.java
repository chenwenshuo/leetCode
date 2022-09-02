package leetcode.editor.cn;

//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1495 👎 0

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeLinkedList{
         public static void main(String[] args) {
            Solution solution = new PalindromeLinkedList().new Solution();
            ListNode listNode=new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1,null))));
             System.out.println(solution.isPalindrome(listNode));
         }

//leetcode submit region begin(Prohibit modification and deletion)

  //Definition for singly-linked list.
  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
             //使用栈
    public boolean isPalindrome(ListNode head) {
        if (head==null||head.next==null) return true;
        Deque<Integer> stack=new LinkedList<>();
          ListNode low=head;
          stack.push(low.val);
          ListNode fast=head.next;
        while (fast.next!=null&&fast.next.next!=null){

            low=low.next;
            stack.push(low.val);
            fast=fast.next.next;
        }

        if (fast.next!=null){
            low=low.next.next;
        }else {
            low=low.next;
        }
        while (low!=null){
            if (stack.poll()==low.val)
                low=low.next;
            else  return false;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
