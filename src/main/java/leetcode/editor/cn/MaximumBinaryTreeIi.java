package leetcode.editor.cn;

//最大树 定义：一棵树，并满足：其中每个节点的值都大于其子树中的任何其他值。 
//
// 给你最大树的根节点 root 和一个整数 val 。 
//
// 就像 之前的问题 那样，给定的树是利用 Construct(a) 例程从列表 a（root = Construct(a)）递归地构建的： 
//
// 
// 如果 a 为空，返回 null 。 
// 否则，令 a[i] 作为 a 的最大元素。创建一个值为 a[i] 的根节点 root 。 
// root 的左子树将被构建为 Construct([a[0], a[1], ..., a[i - 1]]) 。 
// root 的右子树将被构建为 Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) 。 
// 返回 root 。 
// 
//
// 请注意，题目没有直接给出 a ，只是给出一个根节点 root = Construct(a) 。 
//
// 假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。 
//
// 返回 Construct(b) 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,1,3,null,null,2], val = 5
//输出：[5,4,null,1,3,null,null,2]
//解释：a = [1,4,2,3], b = [1,4,2,3,5] 
//
// 示例 2： 
//
// 
//输入：root = [5,2,4,null,1], val = 3
//输出：[5,2,4,null,1,null,3]
//解释：a = [2,1,5,4], b = [2,1,5,4,3] 
//
// 示例 3： 
//
// 
//输入：root = [5,2,3,null,1], val = 4
//输出：[5,2,4,null,1,3]
//解释：a = [2,1,5,3], b = [2,1,5,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 100] 内 
// 1 <= Node.val <= 100 
// 树中的所有值 互不相同 
// 1 <= val <= 100 
// 
//
// 
//
// Related Topics 树 二叉树 👍 122 👎 0

public class MaximumBinaryTreeIi{
         public static void main(String[] args) {
            Solution solution = new MaximumBinaryTreeIi().new Solution();
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

    /**
     *
     大概意思是最大树 root 是根据特定的规则构造出来的，即给定的 root 其实对应一个具体的 nums，题目要求是将 val 追加到 nums 的尾部，然后再对得到的 nums 运用相同规则的构造，返回重新构造的最大树头结点。

     根据构造规则，若有下标 i < ji<j，则 nums[i]nums[i] 必然在 nums[j]nums[j] 水平线的左边，而 val 又是追加在原有 nums 的结尾。因此其最终位置分如下两种情况：

     val 为新 nums 中的最大值，同时 val 又是追加在原有 nums 的结尾，此时将原有的 root 挂在 val 对应节点的左子树即可，新树的根节点为 val 对应节点；
     否则，我们只需要不断在 root 的右子树中找目标位置（反证法可以知，val 必不可能出现在任一非右位置，否则可推断出在 val 右边仍有元素，这与 val 位于 nums 的结尾位置冲突）。假设目标位置的父节点为 prev，目标位置的原节点为 cur，根据构造规则可知 prev.right = node 且 node.left = cur，新树的根节点不变。

     */
    class Solution {
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            TreeNode node = new TreeNode(val);
            TreeNode tem = null, cur = root;

            while (cur!=null&&cur.val>val){
                tem=cur;
                cur=cur.right;
            }

            if (tem==null){
                node.left=cur;
                return node;
            }
            tem.right=node;
            node.left=cur;

            return root;

        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
