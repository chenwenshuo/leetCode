package hot100;

public class Hot114 {
   
    //  Definition for a binary tree node.
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
    public void flatten(TreeNode root) {
          if (root==null) return;

          while (root!=null){
              
          }

    }

    private void dfs(TreeNode left, TreeNode treeNode) {
          if (left==null) return;
        treeNode.right=left;
        treeNode.left=null;
        dfs(left.left,treeNode);
        dfs(left.right,treeNode);
    }
}
