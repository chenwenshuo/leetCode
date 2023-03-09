package leetcode.editor.cn.zs.zs311;

import org.junit.Test;

/**
 * @Author: chenwenshuo
 * @Date: 2022/09/18/10:34
 */
public class T3 {
    public int longestContinuousSubstring(String s) {

        char[] chars = s.toCharArray();

        int ans=1;
        int tem=1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i]-chars[i-1]==1){
                tem++;
                ans= Math.max(ans,tem);
            }else {
                tem=1;
            }
        }
        return ans;
    }

    @Test
    public  void  test2(){
        System.out.println(longestContinuousSubstring("ababcdaba"));
    }
}
