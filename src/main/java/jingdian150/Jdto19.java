package jingdian150;

public class Jdto19 {
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

    // 1 2 3 4 5
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = new ListNode();
        slow.next = head;
        ListNode pre = slow;
        while (fast != null) {
            fast = fast.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return slow.next;
    }


}
