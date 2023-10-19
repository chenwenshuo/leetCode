//给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。 
//
// 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。 
//
// 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。 
//
// 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,3,5,2,4] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [2,1,3,5,6,4,7]
//输出: [2,3,6,7,1,5,4] 
//
// 
//
// 提示: 
//
// 
// n == 链表中的节点数 
// 0 <= n <= 10⁴ 
// -10⁶ <= Node.val <= 10⁶ 
// 
//
// Related Topics 链表 👍 697 👎 0


package leetcode.editor.cn;


import org.junit.Test;

public class P328_OddEvenLinkedList{

	@Test
	public  void test() {
		//测试代码
		Solution solution = new P328_OddEvenLinkedList().new Solution();
		System.out.println(solution.oddEvenList(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))))));
	}

	//力扣代码e
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
    public ListNode oddEvenList(ListNode head) {
			if (head==null||head.next==null){
				return head;
			}
			ListNode tem =head;
			int a = 1;
			ListNode jl=new ListNode();
			ListNode ol = new ListNode();
			ListNode j=jl;
			ListNode o =ol;
			while (tem!=null){
				if (a%2==0){
					o.next =tem;
					o=o.next;
				}else {
					j.next =tem;
					j=j.next;
				}
				tem=tem.next;
				a++;
			}
			o.next=null;
			j.next=ol.next;
			return jl.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
