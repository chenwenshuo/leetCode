package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * @Author: chenwenshuo
 * @Date: 2022/09/26/14:39
 */
public class Hot17 {
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return  new ArrayList<>();
        }
        HashMap<Integer, char[]> map = new HashMap<>();
        map.put(2,new char[]{'a','b','c'});
        map.put(3,new char[]{'d','e','f'});
        map.put(4,new char[]{'g','h','i'});
        map.put(5,new char[]{'j','k','l'});
        map.put(6,new char[]{'m','n','o'});
        map.put(7,new char[]{'p','q','r','s'});
        map.put(8,new char[]{'t','u','v'});
        map.put(9,new char[]{'w','x','y','z'});
        List<String> list=new ArrayList<>();
        StringBuffer path=new StringBuffer(digits);
        char[] chars = digits.toCharArray();
        dfs(map,chars,path,list,0);
        return list;

    }

    private void dfs(HashMap<Integer,char[]> map, char[] digits, StringBuffer path, List<String> list, int i) {
        if (i==digits.length){
            list.add(new String(path));
            return;
        }
        char[] chars = map.get(digits[i]-'0');
        for (int i1 = 0; i1 < chars.length; i1++) {
            path.setCharAt(i,chars[i1]);
            dfs(map,digits,path,list,i+1);
            // path.deleteCharAt(i1);
        }
    }
}
