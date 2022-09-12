package leetcode.editor.cn;

//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
// Related Topics 链表 双指针 👍 863 👎 0

import java.util.List;

public class RemoveDuplicatesFromSortedListIi{
         public static void main(String[] args) {
            Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
            int a=123;
            int b=456;
             System.out.println(a&b);
 }

//leetcode submit region begin(Prohibit modification and deletion)

  //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            /**
             * 1.ans 头
             * 2.tem作为ans指针移动
             * 3.遍历head 相等直接跳过  不等于 做为tem的结尾连接
             */
            ListNode ans = new ListNode();
            ListNode tem = ans;
            while (head != null) {

                if (head.next == null || head.val != head.next.val) {
                    tem.next = head;
                    tem = head;
                }
                while (head.next != null && head.val == head.next.val) head = head.next;
                head = head.next;
            }
            tem.next = null;
            return ans.next;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
