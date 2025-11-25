package jingdian150;

import java.util.Deque;
import java.util.LinkedList;

public class Jdto114 {
    public class TreeNode {
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

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(root);

        TreeNode pre = null;
        while (!stack.isEmpty()){
            TreeNode poll = stack.poll();

            if (pre!=null){
                pre.left=null;
                pre.right = poll;
            }
            TreeNode left = poll.left;
            TreeNode right = poll.right;
            if (right!=null){
                stack.push(right);
            }
            if (left!=null){
                stack.push(left);
            }

            pre=poll;
        }
    }
}
