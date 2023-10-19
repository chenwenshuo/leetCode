//给出二叉树的根节点 root，树上每个节点都有一个不同的值。 
//
// 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。 
//
// 返回森林中的每棵树。你可以按任意顺序组织答案。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
//输出：[[1,2,null,4],[6],[7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,4,null,3], to_delete = [3]
//输出：[[1,2,4]]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数最大为 1000。 
// 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。 
// to_delete.length <= 1000 
// to_delete 包含一些从 1 到 1000、各不相同的值。 
// 
//
// Related Topics 树 深度优先搜索 数组 哈希表 二叉树 👍 257 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/*/
  删点成林
  @author chenws
  @date 2023-05-30 13:47:21
 /*/
public class P1110_DeleteNodesAndReturnForest {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1110_DeleteNodesAndReturnForest().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    //Definition for a binary tree node.
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

    class Solution {

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<TreeNode> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Set<Integer> collect = new HashSet<>();
            for (int i : to_delete) {
                collect.add(i);
            }
            Queue<TreeNode> q = new LinkedList();
            q.add(root);
            Map<Integer,TreeNode> map = new HashMap<>();
            map.put(root.val,root);
            while (!q.isEmpty()) {
                TreeNode poll = q.poll();

                if (poll.left!=null){
                    q.offer(poll.left);
                    if (collect.contains(poll.left.val)){
                        poll.left=null;
                    }
                }
                if (poll.right!=null){
                    q.offer(poll.right);
                    if (collect.contains(poll.right.val)){
                        poll.right=null;
                    }
                }
                if (collect.contains(poll.val)){
                    map.remove(poll.val);
                    if (poll.left!=null){
                        map.put(poll.left.val,poll.left);
                    }
                    if (poll.right!=null){
                        map.put(poll.right.val,poll.right);
                    }

                }
            }
           list= new ArrayList<>(map.values());
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
