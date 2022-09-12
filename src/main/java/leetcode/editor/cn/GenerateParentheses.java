package leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 2858 👎 0

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
         public static void main(String[] args) {
            Solution solution = new GenerateParentheses().new Solution();
             System.out.println(solution.generateParenthesis(3));
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n)
    {if (n==0) return new ArrayList<>();

    StringBuffer path=new StringBuffer();
    List<String> list=new ArrayList<>();
    dfs(path,list,0,0,n);
        return list;
}

    private void dfs( StringBuffer path, List<String> list, int i,int j,int n) {
        if (n*2==path.length()){
            System.out.println(path);
            list.add(new String(path));
            return;
        }
        //先（ 后 ）
        if (i<n){
            path.append('(');
            dfs(path,list,i+1,j,n);
            path.deleteCharAt(path.length()-1);
        }
        if (j<i){
            path.append(')');
            dfs(path,list,i,j+1,n);
            path.deleteCharAt(path.length()-1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
