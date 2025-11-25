package jingdian150;

import javax.swing.plaf.IconUIResource;
import java.util.HashSet;
import java.util.Set;

public class Jdto3 {

    public int lengthOfLongestSubstring(String s) {
        //pwwkew
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int l = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)){
                set.add(c);
                ans = Math.max(ans,set.size());
                continue;
            }
            while (set.contains(s.charAt(i))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);

        }
        return Math.max(ans,set.size());
    }
}
