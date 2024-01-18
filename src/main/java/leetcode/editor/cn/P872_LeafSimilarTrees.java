//请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。 
//
// 
//
// 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。 
//
// 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。 
//
// 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,
//null,null,null,null,9,8]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,2,3], root2 = [1,3,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定的两棵树结点数在 [1, 200] 范围内 
// 给定的两棵树上的值在 [0, 200] 范围内 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 227 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/*/
  叶子相似的树
  @author chenws
  @date 2023-12-21 17:35:29
 /*/
public class P872_LeafSimilarTrees {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P872_LeafSimilarTrees().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    ///Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> l1 = new ArrayList<>();
            dfs(root1, l1);
            List<Integer> l2 = new ArrayList<>();
            dfs(root2, l2);
            if (l1.size()!=l2.size()){
                return false;
            }
            for (int i = 0; i < l1.size(); i++) {
                if (!l1.get(i).equals(l2.get(i))){
                    return false;
                }
            }
            return true;

        }

        private void dfs(TreeNode root1, List<Integer> l1) {
            if (root1 == null) {
                return;
            }
            if (root1.left==null&&root1.right==null){
                l1.add(root1.val);
                return;
            }
            dfs(root1.left,l1);
            dfs(root1.right,l1);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
