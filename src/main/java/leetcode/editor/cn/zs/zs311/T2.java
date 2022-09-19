package leetcode.editor.cn.zs.zs311;


import leetcode.editor.cn.NAryTreeLevelOrderTraversal;

import java.util.*;

public class T2 {
   
      //Definition for a binary tree node.
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
     
    public TreeNode reverseOddLevels(TreeNode root) {

          TreeNode ans =new TreeNode();
        Queue<TreeNode> queue=new LinkedList<>();
        List<Integer> lists=new ArrayList<>();

        queue.offer(root);
        int tem=1;
        while (!queue.isEmpty()){
            int count=queue.size();
            List<Integer> list=new ArrayList<>();

            if (tem%2==1){
                for (int i = 0; i < count; i++) {
                   //反转
                    TreeNode poll = queue.poll();
                    if (poll!=null){
                        list.add(poll.val);
                        queue.offer(poll.left);
                        queue.offer(poll.right);}

                }
                Collections.reverse(list);
            }else {
                for (int i = 0; i < count; i++) {
                    //反转
                    TreeNode poll = queue.poll();
                    if (poll!=null){
                        list.add(poll.val);
                        queue.offer(poll.left);
                        queue.offer(poll.right);}

                }
            }
            lists.addAll(list);
        }

        ans=parse(lists,0);
          return  ans;

    }

    private TreeNode parse(List<Integer> lists, int start) {
        if (start > lists.size() || lists.get(start) == null ){
            return null;
        }

        //声明父节点
        TreeNode treeNode = new TreeNode(Integer.parseInt(lists.get(start) + ""));
        treeNode.left = parse(lists,(start + 1) * 2 -1);
        treeNode.right = parse(lists,(start + 1) * 2);

        return treeNode;
    }
}
