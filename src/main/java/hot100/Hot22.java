package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 * @Author: chenwenshuo
 * @Date: 2022/09/26/19:19
 */
public class Hot22 {

    List<String> ans=new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        StringBuffer sb=new StringBuffer();
        dfs(n,sb,0,0);

        return null;
    }

    /**
     * 先选择num个（  再选择num1个） 回溯
     * @param n
     * @param sb
     * @param num
     * @param num1
     */
    private void dfs(int n, StringBuffer sb, int num,int num1) {
        if (sb.length()==n){
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

