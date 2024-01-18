//给你一个链表的头节点 head 。 
//
// 移除每个右侧有一个更大数值的节点。 
//
// 返回修改后链表的头节点 head 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [5,2,13,3,8]
//输出：[13,8]
//解释：需要移除的节点是 5 ，2 和 3 。
//- 节点 13 在节点 5 右侧。
//- 节点 13 在节点 2 右侧。
//- 节点 8 在节点 3 右侧。
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,1]
//输出：[1,1,1,1]
//解释：每个节点的值都是 1 ，所以没有需要移除的节点。
// 
//
// 
//
// 提示： 
//
// 
// 给定列表中的节点数目在范围 [1, 10⁵] 内 
// 1 <= Node.val <= 10⁵ 
// 
//
// Related Topics 栈 递归 链表 单调栈 👍 67 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
/
  从链表中移除节点
  @author chenws
  @date 2024-01-03 11:17:22
 /*/
public class P2487_RemoveNodesFromLinkedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P2487_RemoveNodesFromLinkedList().new Solution();
	 }
	 
//力扣代码
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
    public ListNode removeNodes(ListNode head) {
		ListNode tem = head;

		Deque<ListNode> deque = new ArrayDeque<>();

		while (tem!=null){
			while (!deque.isEmpty()&&deque.peek().val<tem.val){
				deque.poll();
			}
			deque.push(tem);
			tem=tem.next;
		}

		ListNode h = new ListNode();
		ListNode p = h;
		while (!deque.isEmpty()){
			p.next=deque.pollLast();
			p=p.next;
		}
		return h.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
