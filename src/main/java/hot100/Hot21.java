package hot100;

/**
  21. 合并两个有序链表
  将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 
 
 
  示例 1：
 
 
  输入：l1 = [1,2,4], l2 = [1,3,4]
  输出：[1,1,2,3,4,4]
  示例 2：
 
  输入：l1 = [], l2 = []
  输出：[]
  示例 3：
 
  输入：l1 = [], l2 = [0]
  输出：[0]
 
  @Author: chenwenshuo
  @Date: 2022/09/26/19:06
 **/
public class Hot21 {
    

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    /**
     * 遍历
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

          ListNode ans=new ListNode(0,null);
          ListNode tem=ans;
          if (list1==null) return list2;
          if (list2==null) return list1;

          while (list1!=null&&list2!=null){
              int val1 = list1.val;
              int val2 = list2.val;
              if (val1>=val2){
                  tem.next=new ListNode(val2);
                  list2=list2.next;
              }else {
                  tem.next=new ListNode(val1);
                  list1=list1.next;
              }
              tem=tem.next;


          }
          if (list1!=null){
              tem.next=list1;
          }
          if (list2!=null){
              tem.next=list2;
          }


          return ans.next;
    }
}
