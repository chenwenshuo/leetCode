package jingdian150;


//Definition for singly-linked list.

public class Jdto2 {
    class ListNode {
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
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode p = ans;
        int tem = 0;
        while (l1 != null || l2 != null) {
            int a = 0;
            if (l1 != null) {
                a += l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                a+=l2.val;
                l2=l2.next;
            }
            p.next = new ListNode((a + tem) % 10);
            tem = ((a + tem) / 10);
            p = p.next;
        }
        if (tem == 1) {
            p.next = new ListNode(1);
        }

        return ans.next;
    }

}
