package jingdian150;

public class Jdto92 {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next = null;
        //1 2 3 4 5
        for (int i = left; i < right; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return dummyNode.next;
    }

    // 1 2 3 4 5
    public ListNode reverseList1(ListNode head) {
        if (head == null) return head;

        ListNode pre = null;
        ListNode cur = null;
        while (head != null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
