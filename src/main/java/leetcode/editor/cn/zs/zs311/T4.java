package leetcode.editor.cn.zs.zs311;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenwenshuo
 * @Date: 2022/09/18/11:27
 */
public class T4 {

    @Test
    public void test(){
        for (int i : sumPrefixScores(new String[]{"abc", "ab", "bc", "b"})) {
            System.out.println(i);
        }
    }
    public int[] sumPrefixScores(String[] words) {
        Map<String,Integer> map=new HashMap<>();

        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                map.merge(word.substring(0,i+1),1,Integer::sum);
            }
        }

        int[] ans=new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();
            for (int j = 0; j< length; j++) {
                ans[i]+=map.get(words[i].substring(0,j+1));
            }
        }

        return ans;
    }
}
