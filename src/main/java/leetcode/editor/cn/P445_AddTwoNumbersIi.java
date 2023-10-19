//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
//
// Related Topics 栈 链表 数学 👍 643 👎 0


package leetcode.editor.cn;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 两数相加 II
 * @author chenws
 * @date 2023-07-03 15:20:45
 */
public class P445_AddTwoNumbersIi{

	public static void main(String[] args) {
		//测试代码
		Solution solution = new P445_AddTwoNumbersIi().new Solution();
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

//  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			BigInteger s= getNum(l1).add(getNum(l2));
			String s1 = String.valueOf(s);
			ListNode ans = new ListNode();
			ListNode tem = ans;
			for (int i = 0; i < s1.length(); i++) {
				tem.next = new ListNode(Character.getNumericValue(s1.charAt(i)));
				tem = tem.next;
			}

			return ans;
		}

	private BigInteger getNum(ListNode l1) {

		BigInteger ans = new BigInteger(String.valueOf(0));
		while (l1!=null){
			ans=ans.multiply(new BigInteger(String.valueOf(l1.val))).add(ans);
			l1=l1.next;
		}
		return ans;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
