package hot100;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 */
public class Hot101 {

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

    public boolean isSymmetric(TreeNode root) {
         if (root==null) return true;

         return isSymmetric(root.left,root.right);


    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
         if (left==null&&right==null)return true;

         if (left==null) return  false;
         if (right==null) return false;
         if (left.val!=right.val) return false;

         return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }
}
