//给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。 
//
//
// （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先） 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
//输出：7
//解释： 
//我们有大量的节点与其祖先的差值，其中一些如下：
//|8 - 3| = 5
//|3 - 7| = 4
//|8 - 1| = 7
//|10 - 13| = 3
//在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,null,2,null,0,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在 2 到 5000 之间。 
// 0 <= Node.val <= 10⁵ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 159 👎 0


package leetcode.editor.cn;

public class P1026_MaximumDifferenceBetweenNodeAndAncestor {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1026_MaximumDifferenceBetweenNodeAndAncestor().new Solution();

    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    //Definition for a binary tree node.
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
   

        int maxLeft = 0;
        int minLeft = 0;
        int maxRight = 0;
        int minRight = 0;

        public int maxAncestorDiff(TreeNode root) {
            return dfs(root, root.val, root.val);
        }

        private int dfs(TreeNode root, int max, int min) {
            return root == null ? max - min : Math.max(Math.max(Math.abs(max - root.val), Math.abs(min - root.val)),
                Math.max(dfs(root.left, Math.max(max, root.val), Math.min(min, root.val)),
                    dfs(root.right, Math.max(max, root.val), Math.min(min, root.val))));
        }

        public int visit(TreeNode root, int max, int min) {
            if (root == null) {
                return max - min;
            }
            int ans = Math.max(Math.abs(max - root.val), Math.abs(min - root.val));
            int left = visit(root.left, Math.max(max, root.val), Math.min(min, root.val));
            int right = visit(root.right, Math.max(max, root.val), Math.min(min, root.val));
            return Math.max(ans, Math.max(left, right));
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
