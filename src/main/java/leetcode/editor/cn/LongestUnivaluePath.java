package leetcode.editor.cn;

//给定一个二叉树的
// root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。 
//
// 两个节点之间的路径长度 由它们之间的边数表示。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,4,5,1,1,5]
//输出：2
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root = [1,4,5,4,4,5]
//输出：2
// 
//
// 
//
// 提示: 
//
// 
// 树的节点数的范围是
// [0, 10⁴] 
// -1000 <= Node.val <= 1000 
// 树的深度将不超过 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 626 👎 0

public class LongestUnivaluePath{
         public static void main(String[] args) {
            Solution solution = new LongestUnivaluePath().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)

 // Definition for a binary tree node.
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

    /**
     *  1.ans 为最后答案  ans-1是因为有重复计算头结点
     *  2遍历根节点的左右节点计算出左右子树的最大深度 取最大值作为根节点的最大路径 l+1  r+1 比较
     *  3.计算根节点的最长总路径 如果左右相等就是l+r 否则就取相等的一边
     *
     *  核心 ： 1 以该节点做为根节点的符合条件宗路径
     *         2 以该节点作为根节点的左右子树到该节点的总路径长度
     */
    class Solution {
        int ans = 0;
        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return Math.max(0,ans-1);
        }
        int dfs(TreeNode root) {
            if (root==null) return 0;
            int tem=1,
                    cur=1,
                    l=dfs(root.left),
                    r=dfs(root.right);

            if (root.left!=null&&root.val==root.left.val){
               tem=l+1;
               cur+=l;
            }

            if (root.right!=null&&root.val==root.right.val){
                tem=Math.max(tem,r+1);
                cur+=r;
            }
            ans=Math.max(ans,cur);


            return tem;

        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}
