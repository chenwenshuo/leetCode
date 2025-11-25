package jingdian150;

public class Jdto530 {
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

    int ans;
    int t;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        ans = Integer.MAX_VALUE;
        t = -1;
        dfs(root);

        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (t==-1){
            t = root.val;
        }
        ans = Math.min(ans,root.val-t);
        dfs(root.right);
    }
}
