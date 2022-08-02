package leetcode.editor.cn;

//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: 0
// 
//
// 示例 2: 
//
// 
//输入: s = "loveleetcode"
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: s = "aabb"
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写字母 
// 
//
// Related Topics 队列 哈希表 字符串 计数 👍 579 👎 0

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstUniqueCharacterInAString{
         public static void main(String[] args) {
            Solution solution = new FirstUniqueCharacterInAString().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 没有相同的 put(c,1),并且offer（当前值）
     * 有相同的 put(c,-1) 如果queue不为空，并且该值为-1，poll
     *
     *取出来
     */
    class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> position=new HashMap<Character, Integer>();
        Queue<Pair> queue = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }

    class Pair {
        char ch;
        int pos;

        Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}
