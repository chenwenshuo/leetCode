//给你一个字符串 s 和一个正整数 k 。 
//
// 用 vowels 和 consonants 分别表示字符串中元音字母和辅音字母的数量。 
//
// 如果某个字符串满足以下条件，则称其为 美丽字符串 ： 
//
// 
// vowels == consonants，即元音字母和辅音字母的数量相等。 
// (vowels * consonants) % k == 0，即元音字母和辅音字母的数量的乘积能被 k 整除。 
// 
//
// 返回字符串 s 中 非空美丽子字符串 的数量。 
//
// 子字符串是字符串中的一个连续字符序列。 
//
// 英语中的 元音字母 为 'a'、'e'、'i'、'o' 和 'u' 。 
//
// 英语中的 辅音字母 为除了元音字母之外的所有字母。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "baeyh", k = 2
//输出：2
//解释：字符串 s 中有 2 个美丽子字符串。
//- 子字符串 "baeyh"，vowels = 2（["a","e"]），consonants = 2（["y","h"]）。
//可以看出字符串 "aeyh" 是美丽字符串，因为 vowels == consonants 且 vowels * consonants % k == 0 。
//
//- 子字符串 "baeyh"，vowels = 2（["a","e"]），consonants = 2（["b","y"]）。
//可以看出字符串 "baey" 是美丽字符串，因为 vowels == consonants 且 vowels * consonants % k == 0 。
//
//可以证明字符串 s 中只有 2 个美丽子字符串。
// 
//
// 示例 2： 
//
// 
//输入：s = "abba", k = 1
//输出：3
//解释：字符串 s 中有 3 个美丽子字符串。
//- 子字符串 "abba"，vowels = 1（["a"]），consonants = 1（["b"]）。
//- 子字符串 "abba"，vowels = 1（["a"]），consonants = 1（["b"]）。
//- 子字符串 "abba"，vowels = 2（["a","a"]），consonants = 2（["b","b"]）。
//可以证明字符串 s 中只有 3 个美丽子字符串。
// 
//
// 示例 3： 
//
// 
//输入：s = "bcdf", k = 1
//输出：0
//解释：字符串 s 中没有美丽子字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= k <= 1000 
// s 仅由小写英文字母组成。 
// 
//
// Related Topics 字符串 枚举 前缀和 👍 3 👎 0


package leetcode.editor.cn;

import java.util.Set;

/**
 * 统计美丽子字符串 I
 *
 * @author chenws
 * @date 2023-11-30 15:07:51
 */
public class P2947_CountBeautifulSubstringsI {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2947_CountBeautifulSubstringsI().new Solution();
        System.out.println(solution.beautifulSubstrings("baeyh",2));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int beautifulSubstrings(String s, int k) {
            Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
            int length = s.length();
            int[] count = new int[length + 1];
            int cnt = 0;
            for (int i = 0; i < length; i++) {
                if (set.contains(s.charAt(i))) {
                    cnt++;
                }
                count[i + 1] = cnt;
            }
            int ans = 0;

            for (int i = 0; i < length; i++) {
                for (int j = i; j < length; j++) {
                    int x = count[j + 1] - count[i];
                    int t = j - i + 1 - x;
                    if (x == t && x * t % k == 0) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
