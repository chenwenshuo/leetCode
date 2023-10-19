//给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// 
//
// 
// 注意：本题与主站 206 题相同： https://leetcode-cn.com/problems/reverse-linked-list/ 
//
// Related Topics 递归 链表 👍 169 👎 0


package leetcode.editor.cn;


import org.junit.Test;

public class UHnkqh {

    @Test
    public void test() {
        //测试代码
        Solution solution = new UHnkqh().new Solution();
        solution.reverseList1(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    // Definition for singly-linked list.
    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
        }
    }

    class Solution {
        // ListNode next = curr.next;
        //            curr.next = prev;
        //            prev = curr;
        //            curr = next;
        //

        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode tem = null;
            while (head != null) {
                tem = head.next;
                head.next = pre;
                pre = head;
                head = tem;
            }
            return pre;
        }

        public ListNode reverseList2(ListNode head) {
            return recur(head, null);
        }

        private ListNode recur(ListNode cur, ListNode pre) {
          if (cur == null){
              return pre;
          }
          ListNode ans = recur(cur.next,cur);
          cur.next = pre;
          return  ans;
        }


        public ListNode reverseList1(ListNode head) {
            ListNode listNode = head;
            while (head != null) {
                head = head.next;
            }
            System.out.println(head);
            System.out.println(listNode);

            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
