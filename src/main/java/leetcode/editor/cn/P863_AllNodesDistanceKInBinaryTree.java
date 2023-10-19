//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 k 。 
//
// 返回到目标结点 target 距离为 k 的所有结点的值的列表。 答案可以以 任何顺序 返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
//输出：[7,4,1]
//解释：所求结点为与目标结点（值为 5）距离为 2 的结点，值分别为 7，4，以及 1
// 
//
// 示例 2: 
//
// 
//输入: root = [1], target = 1, k = 3
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 500] 范围内 
// 0 <= Node.val <= 500 
// Node.val 中所有值 不同 
// 目标结点 target 是树上的结点。 
// 0 <= k <= 1000 
// 
//
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 639 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 二叉树中所有距离为 K 的结点
 *
 * @author chenws
 * @date 2023-06-21 16:43:28
 */
public class P863_AllNodesDistanceKInBinaryTree {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P863_AllNodesDistanceKInBinaryTree().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    //Definition for a binary tree node.
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        int m = 501;
        Set<Integer>[] gg = new Set[m];
        // 根据数据范围最多有 501 个点，每个点最多有 2 条无向边（两个子节点）

        public List<Integer> distanceK1(TreeNode root, TreeNode target, int k) {
            List<Integer> ans = new ArrayList<>();
            if (k == 0) {
                ans.add(target.val);
                return ans;
            }
            Arrays.setAll(gg, x -> new HashSet<>());

            convertToAdjacencyMatrix(root);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(target.val);
            boolean[] vst = new boolean[m];
            vst[target.val] = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = queue.poll();
                    Set<Integer> set = gg[poll];

                    for (Integer integer : set) {
                        if (!vst[integer]) {
                            if (k == 1) {
                                ans.add(integer);
                                continue;
                            }
                            queue.offer(integer);
                            vst[integer] = true;
                        }
                    }

                }
                k--;
            }
            //建图
            return ans;
        }

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            List<Integer> ans = new ArrayList<>();
            if (k == 0) {
                ans.add(target.val);
                return ans;
            }
            Arrays.setAll(gg, x -> new HashSet<>());

            convertToAdjacencyMatrix(root);
            boolean[] vst = new boolean[m];
            dfs(vst, target.val, k, ans);
            return ans;
        }
        private void dfs(boolean[] vst, int target, int k, List<Integer> ans) {
            if (vst[target]) {
                return;
            }
            vst[target] = true;
            if (k == 0) {
                ans.add(target);
                return;
            }
            for (Integer integer : gg[target]) {
                if (!vst[integer]) {
                    dfs(vst, integer,k-1,ans);
                }


            }
        }

        public void convertToAdjacencyMatrix(TreeNode root) {
            if (root == null) {
                return;
            }

            if (root.left != null) {
                addEdge(root.val, root.left.val);
                convertToAdjacencyMatrix(root.left);
            }

            if (root.right != null) {
                addEdge(root.val, root.right.val);
                convertToAdjacencyMatrix(root.right);
            }
        }

        private void addEdge(int val, int val1) {
            gg[val].add(val1);
            gg[val1].add(val);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
