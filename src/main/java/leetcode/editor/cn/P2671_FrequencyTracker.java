//请你设计并实现一个能够对其中的值进行跟踪的数据结构，并支持对频率相关查询进行应答。 
//
// 实现 FrequencyTracker 类： 
//
// 
// FrequencyTracker()：使用一个空数组初始化 FrequencyTracker 对象。 
// void add(int number)：添加一个 number 到数据结构中。 
// void deleteOne(int number)：从数据结构中删除一个 number 。数据结构 可能不包含 number ，在这种情况下不删除任何内
//容。 
// bool hasFrequency(int frequency): 如果数据结构中存在出现 frequency 次的数字，则返回 true，否则返回 
//false。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["FrequencyTracker", "add", "add", "hasFrequency"]
//[[], [3], [3], [2]]
//输出
//[null, null, null, true]
//
//解释
//FrequencyTracker frequencyTracker = new FrequencyTracker();
//frequencyTracker.add(3); // 数据结构现在包含 [3]
//frequencyTracker.add(3); // 数据结构现在包含 [3, 3]
//frequencyTracker.hasFrequency(2); // 返回 true ，因为 3 出现 2 次
// 
//
// 示例 2： 
//
// 
//输入
//["FrequencyTracker", "add", "deleteOne", "hasFrequency"]
//[[], [1], [1], [1]]
//输出
//[null, null, null, false]
//
//解释
//FrequencyTracker frequencyTracker = new FrequencyTracker();
//frequencyTracker.add(1); // 数据结构现在包含 [1]
//frequencyTracker.deleteOne(1); // 数据结构现在为空 []
//frequencyTracker.hasFrequency(1); // 返回 false ，因为数据结构为空
// 
//
// 示例 3： 
//
// 
//输入
//["FrequencyTracker", "hasFrequency", "add", "hasFrequency"]
//[[], [2], [3], [1]]
//输出
//[null, false, null, true]
//
//解释
//FrequencyTracker frequencyTracker = new FrequencyTracker();
//frequencyTracker.hasFrequency(2); // 返回 false ，因为数据结构为空
//frequencyTracker.add(3); // 数据结构现在包含 [3]
//frequencyTracker.hasFrequency(1); // 返回 true ，因为 3 出现 1 次
// 
//
// 
//
// 提示： 
//
// 
// 1 <= number <= 10⁵ 
// 1 <= frequency <= 10⁵ 
// 最多调用 add、deleteOne 和 hasFrequency 共计 2 * 10⁵ 次 
// 
//
// Related Topics 设计 哈希表 👍 33 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 频率跟踪器
 *
 * @author chenws
 * @date 2024-03-21 14:07:33
 */
public class P2671_FrequencyTracker {
    public static void main(String[] args) {
        //测试代码
        // Solution solution = new P2671_FrequencyTracker().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class FrequencyTracker {
        Map<Integer, Integer> countMap;
        Map<Integer, Integer> mMAp;

        public FrequencyTracker() {
            countMap = new HashMap<>();
            mMAp = new HashMap<>();

        }

        public void add(int number) {
            Integer count = countMap.getOrDefault(number, 0);
            mMAp.merge(count + 1, 1, Integer::sum);
            mMAp.put(count,mMAp.getOrDefault(count,0)-1);
            countMap.put(number, count + 1);
        }

        public void deleteOne(int number) {
            if (countMap.containsKey(number)) {
                Integer integer = countMap.get(number);
                mMAp.put(integer, mMAp.get(integer) - 1);
                if (integer == 1) {
                    countMap.remove(number);
                    return;
                }
                mMAp.put(integer - 1, mMAp.getOrDefault(integer - 1, 0) + 1);
                countMap.put(number, integer - 1);
            }

        }

        public boolean hasFrequency(int frequency) {
            return mMAp.getOrDefault(frequency, 0) > 0;

        }
    }

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
