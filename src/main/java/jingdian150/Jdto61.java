package jingdian150;

import java.util.ArrayList;
import java.util.List;

public class Jdto61 {

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

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String s : list) {
            list.remove(s);
        }
        System.out.println(list);
    }
    //head = [1,2,3,4,5，1,2,3,4,5], k = 2
    //输出：[4,5,1,2,3]

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode last = head;
        int len = 1;
        while(last.next != null){
            last = last.next;
            len++;
        }
        k %= len;
        if(k == 0) return head;

        int left = len-k;
        while (left>0){
            last.next=head;
            head=head.next;
            last=last.next;
            last.next=null;
            left--;

        }
        return head;
    }

}
