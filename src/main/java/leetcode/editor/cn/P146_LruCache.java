//
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 3516 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存
 *
 * @author chenws
 * @date 2025-06-24 11:20:54
 */
public class P146_LruCache {
    public static void main(String[] args) {
        //测试代码
        LRUCache lruCache = new P146_LruCache().new LRUCache(2);
        lruCache.put(1,0);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);

        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

        lruCache.put(1,0);
        lruCache.put(1,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));

        //[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],
        // [2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],
        // [5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],
        // [10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],
        // [7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],
        // [6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],
        // [11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],
        // [3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],
        // [11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],
        // [11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]



    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {


        class DLinkNode {
            int key;
            int v;
            DLinkNode next;
            DLinkNode pre;


            public DLinkNode(int key, DLinkNode next, DLinkNode pre) {
                this.key = key;
                this.next = next;
                this.pre = pre;
            }
        }

        Map<Integer, DLinkNode> map = new HashMap<>();
        int cap;
        int size;
        DLinkNode head;
        DLinkNode last;

        public LRUCache(int capacity) {
            cap = capacity;
            size = 0;
            head = new DLinkNode(0, null, null);
            last = new DLinkNode(0, null, null);
            head.next = last;
            last.pre = head;

        }

        public int get(int key) {
            DLinkNode dLinkNode = map.get(key);
            return extracted(dLinkNode);
        }

        private int extracted(DLinkNode dLinkNode) {
            if (dLinkNode == null) {
                return -1;
            }
            if (size == 1) {
                return dLinkNode.v;
            }
            if (dLinkNode.pre == head) {
                return dLinkNode.v;
            }
            DLinkNode next = head.next;
            DLinkNode dNext = dLinkNode.next;
            DLinkNode dPre = dLinkNode.pre;

            head.next = dLinkNode;
            dLinkNode.pre = head;

            dLinkNode.next = next;
            next.pre = dLinkNode;

            dNext.pre = dPre;
            dPre.next = dNext;


            return dLinkNode.v;
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                size++;
                DLinkNode next = head.next;
                DLinkNode dLinkNode = new DLinkNode(key, next, head);
                dLinkNode.v = value;
                head.next = dLinkNode;
                next.pre = dLinkNode;
                map.put(key,dLinkNode);
            } else {
                DLinkNode dLinkNode = map.get(key);
                dLinkNode.v = value;
                extracted(dLinkNode);
            }

            if (size > cap) {
                DLinkNode pre = last.pre;
                DLinkNode pre1 = pre.pre;
                pre1.next = last;
                last.pre = pre1;
                map.remove(pre.key);
                size=cap;
            }


        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
