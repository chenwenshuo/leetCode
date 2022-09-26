package hot100;

import org.junit.Test;

/*/
  19. 删除链表的倒数第 N 个结点
  给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 
 
 
  示例 1：
 
 
  输入：head = [1,2,3,4,5], n = 2
  输出：[1,2,3,5]
  示例 2：
 
  输入：head = [1], n = 1
  输出：[]
  示例 3：
 
  输入：head = [1,2], n = 1
  输出：[1]
 
 
  提示：
 
  链表中结点的数目为 sz
  1 <= sz <= 30
  0 <= Node.val <= 100
  1 <= n <= sz
 
  @Author: chenwenshuo
  @Date: 2022/09/26/17:49
 /*/
public class Hot19 {

    @Test
    public void test(){
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));

        ListNode listNode1 = new ListNode(1, null);

        removeNthFromEnd(listNode1,1);
    }
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
     
    public ListNode removeNthFromEnd(ListNode head, int n) {

          if (head==null) return head;

          ListNode ans=new ListNode(0,head);
          ListNode pre=head;
          ListNode tem=ans;
          int m=0;
          while (pre!=null){
              if (m==n){
              pre=pre.next;
              tem=tem.next;
              }else {
                  m++;
                  pre=pre.next;
              }
          }
          tem.next=tem.next.next;

          return ans.next;

    }
}
