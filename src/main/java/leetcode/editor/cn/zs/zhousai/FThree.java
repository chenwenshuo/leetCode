package leetcode.editor.cn.zs.zhousai;

import org.junit.Test;

/**
 * @Author: chenwenshuo
 * @Date: 2022/09/04/11:29
 */
public class FThree {

    @Test
    public void test(){
        int i = numberOfWays(81,81,2);
        System.out.println(i);
    }
    double ans=0;
    public int numberOfWays(int startPos, int endPos, int k) {

        if (k-(endPos-startPos)==0) return 1;


        if (endPos-startPos==0&&k%2!=0) return 0;
        if (endPos-startPos!=0&&k%(endPos-startPos)!=0) return 0;

        dfs(startPos,endPos,k);

        return (int) ((int)ans%(10e+7));
    }

    private void dfs(int startPos, int endPos, int k) {
        if (startPos==endPos&&k==0) {
            ans++; }
        if (k==0) return;
        if (Math.abs(endPos-startPos)>k) return;
        dfs(startPos+1,endPos,k-1);

        dfs(startPos-1,endPos,k-1);
    }
}
