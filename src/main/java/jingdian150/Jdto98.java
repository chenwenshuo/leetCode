package jingdian150;

public class Jdto98 {
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

    //[5,4,6,null,null,3,7]
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }

    private boolean isValidBST(TreeNode root, int maxValue, int minValue) {
        if (root==null) return true;
        if (root.val>=maxValue|root.val<=minValue) return false;
        return isValidBST(root.left,root.val,minValue)&&isValidBST(root.right,maxValue,root.val);
    }
}
