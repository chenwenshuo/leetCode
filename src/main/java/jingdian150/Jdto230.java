package jingdian150;

public class Jdto230 {
    class TreeNode {
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

    int c = 0;
    int ans;

    public int kthSmallest(TreeNode root, int k) {
        c = k;
        ans = 0;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root==null) return;
        if (c<0) return;

        dfs(root.left);
        if (c==0){
            ans=root.val;
            return;
        }
        c--;
        dfs(root.right);
    }
}
