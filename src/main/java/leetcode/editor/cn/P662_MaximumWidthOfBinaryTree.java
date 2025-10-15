//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。 
//
// 树的 最大宽度 是所有层中最大的 宽度 。 
//
// 
// 
// 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 
//null 节点，这些 null 节点也计入长度。 
// 
// 
//
// 题目数据保证答案将会在 32 位 带符号整数范围内。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,3,2,5,3,null,9]
//输出：4
//解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,3,2,5,null,null,9,6,null,7]
//输出：7
//解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
// 
//
// 示例 3： 
// 
// 
//输入：root = [1,3,2,5]
//输出：2
//解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [1, 3000] 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 702 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*/
  二叉树最大宽度
  @author chenws
  @date 2025-07-14 16:47:08
 /*/
public class P662_MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P662_MaximumWidthOfBinaryTree().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    // Definition for a binary tree node.
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

    class Pair{
        int index;
        TreeNode treeNode;

        public Pair(int index, TreeNode treeNode) {
            this.index = index;
            this.treeNode = treeNode;
        }
    }
    class Solution {
        int ans;


        public int widthOfBinaryTree1(TreeNode root) {
            ans = 1;
            Queue<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(1,root));
            while (!queue.isEmpty()){
                int size = queue.size();
                int start = 0;
                for (int i = 0; i < size; i++) {
                    Pair poll = queue.poll();
                    TreeNode treeNode = poll.treeNode;
                    start = getStart(treeNode.left, start, queue);
                    start = getStart(treeNode.right,start,queue);


                }
            }
            return ans;
        }

        private int getStart(TreeNode treeNode, int start, Queue<Pair> queue) {
            if (treeNode!=null){
                start++;
                ans = Math.max(ans, start);
                queue.offer(new Pair(start, treeNode));
            }else {
                start++;
            }
            return start;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}

