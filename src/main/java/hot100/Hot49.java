package hot100;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 * @Author: chenwenshuo
 * @Date: 2022/09/28/15:43
 */
public class Hot49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map=new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String a=new String(chars);
            if (map.containsKey(a)){
                List<String> list = map.get(a);
                list.add(str);
            }else {
                map.put(a,new ArrayList<String>(Collections.singleton(str)));
            }
        }

        return map.values().stream().collect(Collectors.toList());
    }
}
