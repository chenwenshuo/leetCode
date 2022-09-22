package hot100;




public class Two {

     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
     
  
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode ans =new ListNode();
         ListNode p=ans;
         int tem=0;
         while (l1!=null&&l2!=null){
             int a=l1.val+l2.val;

             p.next=new ListNode((a+tem)%10);
             tem=((a+tem)/10);
             p=p.next;
             l1=l1.next;
             l2=l2.next;
         }
         while (l1!=null){
             p.next=new ListNode((l1.val+tem)%10);
             tem=(l1.val+tem)/10;
             p=p.next;
             l1=l1.next;

         }
            while (l2!=null) {
                p.next=new ListNode((l2.val+tem)%10);
                tem=(l2.val+tem)/10;
                p=p.next;
                l2=l2.next;
            }

            if (tem==1){
                p.next=new ListNode(1);
            }

          return ans.next;
        }
    
}
