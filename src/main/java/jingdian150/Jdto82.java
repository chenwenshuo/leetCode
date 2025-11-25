package jingdian150;

public class Jdto82 {
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
    }

    //[1,2,3,3,4,4,5]
    public static void main(String[] args) {
        Jdto82 jdto82 = new Jdto82();
        ListNode listNode1 = jdto82.new ListNode(1);
        ListNode listNode2 = jdto82.new ListNode(2);
        ListNode listNode3 = jdto82.new ListNode(3);
        ListNode listNode4 = jdto82.new ListNode(3);
        ListNode listNode5 = jdto82.new ListNode(4);
        ListNode listNode6 = jdto82.new ListNode(4);
        ListNode listNode7 = jdto82.new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        System.out.println(jdto82.deleteDuplicates(listNode1));
    }
    ////[1,2,3,3,4,4,5]
    // 1 2 5
    //  ListNode ans = new ListNode();
    //            ListNode tem = ans;
    //            while (head != null) {
    //
    //                if (head.next == null || head.val != head.next.val) {
    //                    tem.next = head;
    //                    tem = tem.next;
    //                }
    //                while (head.next != null && head.val == head.next.val) head = head.next;
    //                head = head.next;
    //            }
    //            tem.next = null;
    //            return ans.next;
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode();
        ListNode tem = ans;
        while (head!=null){
            if (head.next==null||head.val!=head.next.val){
                tem.next=head;
                tem=tem.next;
            }
            while (head.next!=null&&head.val==head.next.val){
                head=head.next;
            }
            head=head.next;
        }
        tem.next=null;
        return ans.next;
    }
}
