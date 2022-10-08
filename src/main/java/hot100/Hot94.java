package hot100;

import java.util.ArrayList;
import java.util.List;

public class Hot94 {
    
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

      List<Integer> ans=new ArrayList<>();
 public List<Integer> inorderTraversal(TreeNode root) {
     dfs(root);
     return ans;
    }

    private void dfs(TreeNode root) {
        if (root==null) return;
        ans.remove(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
