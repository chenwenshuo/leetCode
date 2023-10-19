//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数范围是 [0, 10⁴] 
// 0 <= Node.val <= 10⁴ 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树 👍 476 👎 0


package leetcode.editor.cn;

/*/
  序列化和反序列化二叉搜索树
  @author chenws
  @date 2023-09-04 14:40:31
 /*/
public class P449_SerializeAndDeserializeBst {

    public static void main(String[] args) {
        //测试代码
        //Solution solution = new P449_SerializeAndDeserializeBst().new Codec();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    // Definition for a binary tree node.
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.

        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder s =new StringBuilder();
            dfs(root, s);

            return s.toString();
        }

        private void dfs(TreeNode root, StringBuilder s) {
            if (root == null) {
                return;
            }
            s = s.append(",").append(root.val);
            dfs(root.left, s);
            dfs(root.right, s);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == "") {
                return null;
            }
            String[] split = data.substring(1).split(",");
            int length = split.length;
            int tem[] = new int[length];
            int mid = 0;
            for (int i = 0; i < length; i++) {
                tem[i] = Integer.parseInt(split[i]);
                if (tem[i] > tem[0]) {
                    mid = i;
                }
            }
            TreeNode node = new TreeNode(Integer.parseInt(split[0]));
            node.left = dfs1(1, mid - 1, tem);
            node.right = dfs1(mid, length - 1, tem);
            return node;
        }

        private TreeNode dfs1(int start, int end, int[] tem) {
            if (end < start) {
                return null;
            }
            TreeNode node = new TreeNode(tem[start]);
            int mid = start;
            for (int i = start; i <= end; i++) {

                if (tem[i] > tem[0]) {
                    mid = i;
                }
            }
            node.left = dfs1(1, mid - 1, tem);
            node.right = dfs1(mid, end, tem);
            return node;
        }
        // Your Codec object will be instantiated and called as such:
        // Codec ser = new Codec();
        // Codec deser = new Codec();
        // String tree = ser.serialize(root);
        // TreeNode ans = deser.deserialize(tree);
        // return ans;
        //leetcode submit region end(Prohibit modification and deletion)
    }
}
