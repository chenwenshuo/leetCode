package hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: chenwenshuo
 * @Date: 2022/09/22/11:39
 */
public class Three {
    public static void main(String[] args) {
        int bbbbb = new Three().lengthOfLongestSubstring("dvdf");
        System.out.println(bbbbb);
    }

    //abcdab
    public int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int ans=0;
        int tem=0;
        char x=' ';
        int y=0;
        //abcdbag
        for (int i = 0; i < chars.length; i++) {
            int j=i+1;
            if (chars.length-j<ans)break;
            StringBuffer sb = new StringBuffer().append(chars[i]);
            tem=1;
            while (j<chars.length||(i<j)){
                if (sb.indexOf(String.valueOf(chars[j]))==-1){
                    sb.append(chars[j]);
                    tem++;
                    j++;
                    continue;
                }
                y=j;
                break;
            }
            ans=Math.max(tem,ans);
        }
        ans=Math.max(tem,ans);
        return ans;
    }

}
