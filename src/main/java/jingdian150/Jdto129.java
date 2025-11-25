package jingdian150;

import java.util.ArrayList;
import java.util.List;

public class Jdto129 {
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

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        ans = 0;
        // List<Integer> list = new ArrayList<>();
        sumNumbers(root, root.val);
        return ans;

    }

    private void sumNumbers(TreeNode root, int tem) {
        if (root.left == null && root.right == null) {
            // System.out.println(tem);
            ans += tem;
            return;
        }
        if (root.left != null) {
            // tem += root.val;
            sumNumbers(root.left, tem * 10 + root.val);
        }
        if (root.right != null) {
            sumNumbers(root.right, tem * 10 + root.val);
        }

    }
}
