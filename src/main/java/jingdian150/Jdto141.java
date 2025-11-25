package jingdian150;


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Jdto141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow==fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
