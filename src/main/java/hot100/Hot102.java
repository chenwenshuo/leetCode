package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 输出：[]
  

 提示：

 树中节点数目在范围 [0, 2000] 内
 -1000 <= Node.val <= 1000
 通过次数684,819提交次数1,051,796

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/binary-tree-level-order-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Hot102 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll==null) continue;
                list.add(poll.val);
                if (poll.left!=null)
                 queue.add(poll.left);
                if (poll.right!=null)
                 queue.add(poll.right);

            }
            ans.add(list);
        }

        return ans;
    }
}
