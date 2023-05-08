//给定两个整数void数组 iint[]norintderint[] 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 999 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] ints = solution.supplyWagon(new int[]{7, 3, 6, 1, 8});
        System.out.println("99");
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

        int post_idx;
        int[] postorder;
        int[] inorder;
        Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

        public TreeNode helper(int in_left, int in_right) {
            // 如果这里没有节点构造二叉树了，就结束
            if (in_left > in_right) {
                return null;
            }

            TreeNode treeNode = new TreeNode(postorder[in_right]);
            Integer idx = idx_map.get(postorder[in_right]);
            post_idx--;

            //  treeNode.left = helper();
            return null;
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.postorder = postorder;
            this.inorder = inorder;
            post_idx = postorder.length - 1;

            for (int i = 0; i < inorder.length; i++) {
                idx_map.put(inorder[i], i);
            }

            return helper(0, post_idx);
        }


        public int[] supplyWagon(int[] supplies) {
            int length = supplies.length;
            int len = length / 2;


            return  tr(supplies, len);
        }


    }

    private int[] tr(int[] supplies, int len) {
        if (supplies.length == len) {
            return supplies;
        }
        int tem = supplies[0] + supplies[1];
        int temp[] = new int[supplies.length - 1];
        int a = 0;
        for (int i = 2; i < supplies.length; i++) {

            if (supplies[i] + supplies[i - 1] < tem) {
                a = i-1;
                tem = supplies[i] + supplies[i - 1];
            }
        }

        for (int i = 0; i < supplies.length-1; i++) {
            if (i==a){
                temp[a ] = tem;
            }
            else if (i>a){  //1 2 3 4 5
                         // 1 2 4 5
                temp[i]=supplies[i+1];
            }else {
                temp[i] =supplies[i];
            }
        }
        return tr(temp,len);

    }


    public int adventureCamp(String[] expeditions) {
        Map<Integer, Set<String>> map =new HashMap<>();

        for (int i = 0; i < expeditions.length; i++) {
            Set<String> collect = Arrays.stream(expeditions[i].split("->")).collect(Collectors.toSet());
            map.put(i,collect);
        }

        int ans = map.get(0).size();
        int n=0;
        for (int i = 1; i < expeditions.length; i++) {
            int a =0;
            Set<String> strings = map.get(i);
            Set<String> tem = new HashSet<>();
            for (int j = 0; j < i-1; j++) {
              tem.addAll(map.get(j));
            }
            for (String string : strings) {
                if (!tem.contains(string)){
                    a++;
                }
            }
           if (ans<a){
               n=i;
           }

        }
        return  n==0?-1:n;

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
