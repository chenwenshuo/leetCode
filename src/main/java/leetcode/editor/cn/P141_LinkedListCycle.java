//给你一个链表的头节点 head ，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环 ，则返回 true 。 否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 10⁴] 
// -10⁵ <= Node.val <= 10⁵ 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
//
// 
//
// 进阶：你能用 O(1)（即，常量）内存解决此问题吗？ 
//
// Related Topics 哈希表 链表 双指针 👍 1920 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * 环形链表
 *
 * @author chenws
 * @date 2023-07-29 21:11:37
 */
public class P141_LinkedListCycle {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P141_LinkedListCycle().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    //Definition for singly-linked list.
    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {

        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode pre = head;
            ListNode fast = head.next;
            while (pre != null && fast != null && fast.next != null) {
                if (pre == fast) {
                    return true;
                }
                pre = pre.next;
                fast = fast.next.next;
            }
            return false;
        }
    }

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int hour : hours) {
            if (hour >= target) {
                ans++;
            }
        }
        return ans;

    }

    //[1786,1786,1786,114]
    @Test
    public void test() {
/*        System.out.println(countCompleteSubarrays(new int[]{1786, 1786, 1786, 114, 1, 1}));//6 3 4 4
        System.out.println(countCompleteSubarrays(new int[]{1786, 1786, 1786, 114}));
        System.out.println(countCompleteSubarrays(new int[]{1,1, 3, 1, 2,2, 2}));  1 +2+2+2*2
        System.out.println(countCompleteSubarrays(new int[]{1917, 1917, 608, 608, 1313, 751, 558, 1561, 608}));*/
        System.out.println(countCompleteSubarrays(new int[]{1898,370,822,1659,1360,128,370,360,261,1898}));
    }

    public int countCompleteSubarrays(int[] nums) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();

        int length = nums.length;
        if (size == 1) {
            return length * (length + 1) / 2;
        }
        for (int i = 0; i < nums.length; i++) {
            int a = size;
            int t = 0;
            int h = 0;
            Set<Integer> setTem = new HashSet<>();
            if (i + size <= length) {
                for (int j = i; j < length; j++) {
                    setTem.add(nums[j]);
                    if (setTem.size() == size) {
                        t = i;
                        h = length - (j+1);
                       count=Math.max(count,1 + (h + t) + h * t);
                    }
                }
            }

        }

        return count;
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
