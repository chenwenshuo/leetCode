package leetcode.editor.cn;

//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 846 👎 0

import java.util.HashMap;

public class ZhongJianErChaShuLcof{
         public static void main(String[] args) {
            Solution solution = new ZhongJianErChaShuLcof().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int[] preorder;
        HashMap<Integer, Integer> dic = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder=preorder;
            for (int i = 0; i < inorder.length; i++) {
                dic.put(inorder[i],i);
            }
            return recur(0,0,inorder.length-1);

        }

        /**
         * preorder 前序 负责找出根节点
         * dic      中序 负责找出左右子树
         *
         * 根节点坐标 root
         *
         * i=dic.get(preorder[root]);  i在后序遍历中 <i为左子树    >i为右子树
         *
         * 在前序遍历中 root 为根节点 root+1 为左子树根节点  left为左子树边界  i-1为左子树右边界
         *                        roo+1-left+1为右子树根节点（中序遍历中root位置左边的数字个数=前序遍历中左子树个数+root）
         * 左子树在preorder 坐标为
         * @param root
         * @param left
         * @param right
         * @return
         */
        TreeNode recur(int root, int left, int right) {

            if (left>right) return null;
            TreeNode t =new TreeNode(preorder[root]);
            Integer i = dic.get(preorder[root]);
            t.left=recur(root+1,left,i-1);
            t.right=recur(root + i - left + 1, i + 1, right);
            return t;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
