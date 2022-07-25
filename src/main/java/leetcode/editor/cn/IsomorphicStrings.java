package leetcode.editor.cn;

//给定两个字符串 s 和 t ，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// t.length == s.length 
// s 和 t 由任意有效的 ASCII 字符组成 
// 
//
// Related Topics 哈希表 字符串 👍 487 👎 0

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings{
         public static void main(String[] args) {
            Solution solution = new IsomorphicStrings().new Solution();

            String  s = "paper", t = "title";
             boolean isomorphic = solution.isIsomorphic(s, t);
             System.out.println(isomorphic);
         }

//leetcode submit region begin(Prohibit modification and deletion)

    // 对于已有映射 a -> s2t[a]，若和当前字符映射 a -> b 不匹配，
    // 说明有一对多的映射关系，则返回 false ；
    // 对于映射 b -> a 也同理
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>(), t2s = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);

            if (s2t.containsKey(a) && s2t.get(a) != b ||
                    t2s.containsKey(b) && t2s.get(b) != a)
                return false;
            s2t.put(a, b);
            t2s.put(b, a);
        }
        return true;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}
