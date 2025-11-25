package jingdian150;

import java.util.*;

public class Jdto49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String t = new String(charArray);
            map.computeIfAbsent(t,a->new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
