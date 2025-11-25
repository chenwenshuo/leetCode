package jingdian150;

import java.util.HashMap;
import java.util.Map;

public class Jdto106 {
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

    //输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
    //输出：[3,9,20,null,null,15,7]
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        int length = postorder.length;
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, length - 1, 0, length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int right, int left, int inRight) {
        if (left > right) return null;

        int r = postorder[right];
        Integer inRoot = map.get(r);
        TreeNode root = new TreeNode(r);
        int rightSize = inRight - inRoot;
        root.right = buildTree(inorder, postorder, right-1, right - rightSize, inRight);
        root.left = buildTree(inorder, postorder, right - rightSize - 1, left, inRoot - 1);

        return root;
    }

}
