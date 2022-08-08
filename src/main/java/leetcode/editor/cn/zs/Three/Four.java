package leetcode.editor.cn.zs.Three;

import org.junit.Test;

/**
 * @Author: chenwenshuo
 * @Date: 2022/08/07/11:05 上午
 */
public class Four {
    public static void main(String[] args) {
        System.out.println('c'-'a');
    }

    @Test
    public void Test(){
        //"eduktdb"
        //15
        System.out.println(longestIdealString("eduktdb", 15));
    }
    public int longestIdealString(String s, int k) {
        int length = s.length();
        if (length<=1){
            return length;
        }
        int l=0;
        int r=1;
        int ans=0;


        for (int i = 0; i < length; i++) {
               l=i;
               r=i+1;
               int tem=1;
            while (r<length&&l<r){
                char c = s.charAt(l);
                char c1 = s.charAt(r);
                if (Math.abs(c1-c)<=k){
                    tem++;
                    l=r;
                }
                r++;
            }
            ans=Math.max(ans,tem);
        }



        return ans;
    }
}
