package leetcode.editor.cn;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 309 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CongWeiDaoTouDaYinLianBiaoLcof{
         public static void main(String[] args) {
            Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)

  //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public int[] reversePrint(ListNode head) {
      if (head==null) return new int[0];

      List<Integer> list=new ArrayList<>();
      while (head!=null){
          list.add(head.val);
          head=head.next;
      }
        int size = list.size();
      int[] a=new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i]=list.get(size-i-1);
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
