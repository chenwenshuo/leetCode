//如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ： 
//
// 
// 操作 1：交换任意两个 现有 字符。 
// 
//
// 
// 例如，abcde -> aecdb 
// 
// 
// 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
// 
// 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ） 
// 
// 
//
//
// 你可以根据需要对任意一个字符串多次使用这两种操作。 
//
// 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "abc", word2 = "bca"
//输出：true
//解释：2 次操作从 word1 获得 word2 。
//执行操作 1："abc" -> "acb"
//执行操作 1："acb" -> "bca"
// 
//
// 示例 2： 
//
// 
//输入：word1 = "a", word2 = "aa"
//输出：false
//解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。 
//
// 示例 3： 
//
// 
//输入：word1 = "cabbba", word2 = "abbccc"
//输出：true
//解释：3 次操作从 word1 获得 word2 。
//执行操作 1："cabbba" -> "caabbb"
//执行操作 2："caabbb" -> "baaccc"
//执行操作 2："baaccc" -> "abbccc"
// 
//
// 示例 4： 
//
// 
//输入：word1 = "cabbba", word2 = "aabbss"
//输出：false
//解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 10⁵ 
// word1 和 word2 仅包含小写英文字母 
// 
//
// Related Topics 哈希表 字符串 排序 👍 91 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 确定两个字符串是否接近
 *
 * @author chenws
 * @date 2023-11-30 10:17:31
 */
public class P1657_DetermineIfTwoStringsAreClose {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1657_DetermineIfTwoStringsAreClose().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //字符相同，长度相同
        //每个字符出现次数的集合 -》相同  aab -- bab  -> 1 2 ==1 2
        //	执行耗时:126 ms,击败了5.14% 的Java用户
        //	内存消耗:43.9 MB,击败了6.87% 的Java用户
        public boolean closeStrings1(String word1, String word2) {
            if (word1.length() != word2.length()) {
                return false;
            }

            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();

            Set<Character> set = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            for (int i = 0; i < word1.length(); i++) {
                map1.merge(word1.charAt(i), 1, Integer::sum);
                map2.merge(word2.charAt(i), 1, Integer::sum);
                set.add(word1.charAt(i));
                set2.add(word1.charAt(i));
                set2.add(word2.charAt(i));
            }
            if (set2.size() != set.size()) {
                return false;
            }
            List<Integer> list1 = map1.values().stream().sorted().collect(Collectors.toList());
            List<Integer> list2 = map2.values().stream().sorted().collect(Collectors.toList());

            for (int i = 0; i < list1.size(); i++) {
                if (!list1.get(i).equals(list2.get(i))) {
                    return false;
                }
            }
            return true;
        }


        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length()) {
                return false;
            }
            int[] a = new int[26];
            int[] b = new int[26];
            for (int i = 0; i < word1.length(); i++) {
                a[word1.charAt(i) - 'a']++;
                b[word2.charAt(i) - 'a']++;
            }
            for (int i = 0; i < a.length; i++) {
                if (a[i] != 0 && b[i] == 0 || (a[i] == 0 && b[i] != 0)) {
                    return false;

                }
            }
            Arrays.sort(a);
            Arrays.sort(b);
            return Arrays.equals(a, b);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
