package jingdian150;

public class Jdto236 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right =lowestCommonAncestor(root.right,q,q);

        if (left!=null&&right!=null) return root;

        return left==null?right:left;
    }
}
