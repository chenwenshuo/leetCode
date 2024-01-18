//有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候
//进入锁住的房间。 
//
// 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。 
//
// 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：rooms = [[1],[2],[3],[]]
//输出：true
//解释：
//我们从 0 号房间开始，拿到钥匙 1。
//之后我们去 1 号房间，拿到钥匙 2。
//然后我们去 2 号房间，拿到钥匙 3。
//最后我们去了 3 号房间。
//由于我们能够进入每个房间，我们返回 true。
// 
//
// 示例 2： 
//
// 
//输入：rooms = [[1,3],[3,0,1],[2],[0]]
//输出：false
//解释：我们不能进入 2 号房间。
// 
//
// 
//
// 提示： 
//
// 
// n == rooms.length 
// 2 <= n <= 1000 
// 0 <= rooms[i].length <= 1000 
// 1 <= sum(rooms[i].length) <= 3000 
// 0 <= rooms[i][j] < n 
// 所有 rooms[i] 的值 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 👍 356 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 钥匙和房间
 *
 * @author chenws
 * @date 2024-01-17 17:05:42
 */
public class P841_KeysAndRooms {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P841_KeysAndRooms().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {
            Set<Integer> set = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            set.add(0);
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                List<Integer> list = rooms.get(poll);
                for (Integer integer : list) {
                    if (!set.contains(integer)) {
                        queue.offer(integer);
                        set.add(integer);
                    }
                }
                if (rooms.size() == set.size()) {
                    return true;
                }
            }
            return false;
        }

        Set<Integer> set;

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            set = new HashSet<>();
            set.add(0);
            dfs(rooms, 0);
            return set.size() == rooms.size();
        }

        private void dfs(List<List<Integer>> rooms, int inx) {
            if (set.size()==rooms.size()) return;
            List<Integer> list = rooms.get(inx);
            for (Integer integer : list) {
                if (!set.contains(integer)) {
                    set.add(integer);
                    dfs(rooms, integer);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
