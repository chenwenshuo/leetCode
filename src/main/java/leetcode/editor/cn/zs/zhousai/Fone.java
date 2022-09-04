package leetcode.editor.cn.zs.zhousai;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenwenshuo
 * @Date: 2022/09/04/10:38
 */
public class Fone {
    public static void main(String[] args) {
        System.out.println('c'-'a');
        checkDistances("abaccb",null);
    }

    public static boolean checkDistances(String s, int[] distance) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i],i-map.getOrDefault(chars[i],-1));
        }

        for (Character character : map.keySet()) {
           if (map.get(character-'a')!=distance[character-'a'])
               return false;
        }

        return true;
    }
}
