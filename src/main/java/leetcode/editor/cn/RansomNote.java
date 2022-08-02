package leetcode.editor.cn;

//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 419 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RansomNote{
         public static void main(String[] args) {
            Solution solution = new RansomNote().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int length = ransomNote.length();
        int length1 = magazine.length();
        if (length>length1) return false;


        Map<Character,Integer> map=new HashMap<>();
        Map<Character,Integer> map1=new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = ransomNote.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < length1; i++) {
            char c = magazine.charAt(i);
            map1.put(c,map1.getOrDefault(c,0)+1);
            if (map1.getOrDefault(c,0)<map1.get(c))
                return false;
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (map1.getOrDefault(entry.getKey(),0)<entry.getValue())
                return false;
        }

        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
