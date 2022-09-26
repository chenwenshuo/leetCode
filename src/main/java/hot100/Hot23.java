package hot100;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 * @Author: chenwenshuo
 * @Date: 2022/09/26/19:40
 * 归并
 */
public class Hot23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val;
            this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0)
            return null;
        ListNode listNode = merge1(lists, 0, lists.length-1);
        return listNode;
    }
    public ListNode merge1(ListNode[] lists,int l, int r) {
        int mid=(l+r)/2;
        if (l==r)
            return lists[l];
        ListNode listNode=lists[l];

        ListNode listNode1 = merge1(lists, l, mid);
        ListNode listNode2 = merge1(lists, mid+1, r);

        return margeTwo(listNode1,listNode2);
    }

    public ListNode margeTwo(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode l=new ListNode(0);
        ListNode pre=l;

        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                pre.next=l1;
                l1=l1.next;
            }else{
                pre.next=l2;
                l2=l2.next;
            }
            pre=pre.next;
        }
        if(l1!=null){
            pre.next=l1;
            ;
        }
        if(l2!=null){
            pre.next=l2;

        }
        return l.next;
    }
}
