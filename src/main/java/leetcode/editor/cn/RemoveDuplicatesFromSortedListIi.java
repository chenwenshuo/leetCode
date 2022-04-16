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
        ListNode listNode = new ListNode(0, head);
        ListNode ans=listNode;
        /**
         *0--> 1->2>2>2>3>3>4
         * ans  1->2>2>2>3>3>4
         *     1>2>2>3>3>4
         *      1>2>3>3>4
         *      1>3>3>4
         *      1>3>4
         *      1>4
         *
         */
        while (ans.next!=null&&ans.next.next!=null){
            if (ans.next.val==ans.next.next.val){
                int x=ans.next.val;
                while (ans.next!=null&&ans.next.val==x){
                    ans.next=ans.next.next;
                }
            }else {
                ans=ans.next;
            }

        }
        return listNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
