package leetcode.editor.cn.zs;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: chenwenshuo
 * @Date: 2022/06/19/10:33 上午
 */
public class One {
    public static void main(String[] args) {
        String s="A";
        char[] chars = s.toCharArray();
        Set sset= new HashSet();

        char ans=' ';
        for (int i = 0; i < chars.length; i++) {
          sset.add(chars[i]);

        }


        for (char aChar : chars) {
            if (aChar<='Z'&&aChar>='A'){
                if (sset.contains(Character.toLowerCase(aChar))){
                    if (ans<=aChar)
                        ans=aChar;
                }
            }
        }

        System.out.println(test(s));
        /*String s="lEeTcOdE";
        char[] chars = s.toCharArray();

        Arrays.sort(chars);

        for (char aChar : chars) {
            System.out.println(aChar);
        }*/

    }

    static String test(String s){
        char[] chars = s.toCharArray();
        Set sset= new HashSet();

        char ans=' ';
        for (int i = 0; i < chars.length; i++) {
            sset.add(chars[i]);

        }


        for (char aChar : chars) {
            if (aChar<='Z'&&aChar>='A'){
                if (sset.contains(Character.toLowerCase(aChar))){
                    if (ans<=aChar)
                        ans=aChar;
                }
            }
        }

        return ans==' '?"":String.valueOf(ans);

    }
}
