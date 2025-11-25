package jingdian150;

public class JDto104 {
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

    public int maxDepth(TreeNode root) {
      int d = 0;
      if (root==null) return d;
      d+=Math.max(maxDepth(root.left),maxDepth(root.right));
      return d;
    }
}
