package jingdian150;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Jdto20 {
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    public boolean isValid(String s) {

        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Deque<Character> deque = new LinkedList<>();
        deque.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (deque.isEmpty()){
                if (map.containsKey(s.charAt(i))) return false;
                deque.push(s.charAt(i));
                continue;
            }
            if (deque.peek().equals(map.get(s.charAt(i)))){
                deque.poll();
                continue;
            }
            deque.push(s.charAt(i));

        }

        return deque.isEmpty();
    }
}
