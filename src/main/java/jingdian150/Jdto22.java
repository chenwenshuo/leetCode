package jingdian150;

import java.util.ArrayList;
import java.util.List;

public class Jdto22 {
    List<String> ans=new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        StringBuffer sb=new StringBuffer();
        dfs(n,sb,0,0);

        return ans;
    }

    private void dfs(int n, StringBuffer sb, int num,int num1) {
        if (sb.length()==n*2){
            ans.add(sb.toString());
            return;
        }
        //最多可以选择n个(
        if (num<n){
            sb.append("(");
            dfs(n,sb,num+1,num1);
            sb.deleteCharAt(sb.length()-1);
        }
        if (num1<num){
            sb.append(")");
            dfs(n,sb,num,num1+1);
            sb.deleteCharAt(sb.length()-1);
        }



    }
}
