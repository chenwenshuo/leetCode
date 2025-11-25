package jingdian150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Jdto17 {
    HashMap<Integer, char[]> map;
    List<String> ans;

    public List<String> letterCombinations(String digits) {
        if (Objects.equals(digits, "")) return new ArrayList<>();
        map = new HashMap<>();
        ans = new ArrayList<>();
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});
        dfs(digits, "", 0);
        return ans;
    }

    private void dfs(String digits, String s, int index) {
        if (index == digits.length()) {
            ans.add(s);
            return;
        }
        char c = digits.charAt(index);
        char[] chars = map.get(c - '0');
        for (char aChar : chars) {
            dfs(digits, s + aChar, index + 1);
        }
    }
}
