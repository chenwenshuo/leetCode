package leetcode.editor.cn;

//给定一棵二叉树 root，返回所有重复的子树。 
//
// 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,null,2,4,null,null,4]
//输出：[[2,4],[4]] 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,1]
//输出：[[1]] 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [2,2,2,3,null,3,null]
//输出：[[2,3],[3]] 
//
// 
//
// 提示： 
//
// 
// 树中的结点数在[1,10^4]范围内。 
// -200 <= Node.val <= 200 
// 
//
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 521 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees{
         public static void main(String[] args) {
            Solution solution = new FindDuplicateSubtrees().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)

  //Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    List<TreeNode> list=new ArrayList<>();
    Map<String,Integer> map=new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);


        return list;

    }

    /**
     *  if (root == null) return " ";
     *         StringBuilder sb = new StringBuilder();
     *         sb.append(root.val).append("_");
     *         sb.append(dfs(root.left)).append(dfs(root.right));
     *         String key = sb.toString();
     *         map.put(key, map.getOrDefault(key, 0) + 1);
     *         if (map.get(key) == 2) ans.add(root);
     *         return key;
     *
     * @param root
     * @return
     */
    private String dfs(TreeNode root) {
        if (root==null) return " ";
        StringBuffer s=new StringBuffer();
        s.append(root.val);
        s.append("-");
        s.append(dfs(root.left)).append(dfs(root.right));
        String v = s.toString();
        map.put(v,map.getOrDefault(v,0)+1);
        if (map.get(v)==2){
            list.add(root);
        }
        return v;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
