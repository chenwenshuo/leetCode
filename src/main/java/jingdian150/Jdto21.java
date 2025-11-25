package jingdian150;

public class Jdto21 {
    
     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode pre = ans;

        while (list1!=null&&list2!=null){
            int a = list1.val;
            int b = list2.val;
            if (a<=b){
                pre.next=new ListNode(a);
                pre=pre.next;
                list1=list1.next;
            }else {
                pre.next=new ListNode(b);
                pre=pre.next;
                list2=list2.next;
            }
        }
        if (list1!=null){
            pre.next=list1;
        }
        if (list2!=null){
            pre.next=list2;
        }
        return ans.next;
    }
}
