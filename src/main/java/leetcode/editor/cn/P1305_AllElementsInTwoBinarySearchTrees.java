//给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树的节点数在 [0, 5000] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 排序 👍 166 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P1305_AllElementsInTwoBinarySearchTrees{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1305_AllElementsInTwoBinarySearchTrees().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

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
 
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
			List<Integer> one = dfs(root1);
			List<Integer> two = dfs(root2);
			return merge(one,two);

    }

	private List<Integer> merge(List<Integer> one, List<Integer> two) {
			one.addAll(two);
			return one.stream().sorted().collect(Collectors.toList());
	}

	private List<Integer> dfs(TreeNode root1) {
		List<Integer> list = new ArrayList<>();
		dfs(list,root1);
		return list;
	}

	private void dfs(List<Integer> list, TreeNode root1) {
			if (root1==null){
				return;
			}
				dfs(list,root1.left);
			list.add(root1.val);
			dfs(list,root1.right);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
