//给你一个正整数数组 arr，考虑所有满足以下条件的二叉树： 
//
// 
// 每个节点都有 0 个或是 2 个子节点。 
// 数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应。 
// 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。 
// 
//
// 在所有这样的二叉树中，返回每个非叶节点的值的最小可能总和。这个和的值是一个 32 位整数。 
//
// 如果一个节点有 0 个子节点，那么该节点为叶节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：arr = [6,2,4]
//输出：32
//解释：有两种可能的树，第一种的非叶节点的总和为 36 ，第二种非叶节点的总和为 32 。 
// 
//
// 示例 2： 
// 
// 
//输入：arr = [4,11]
//输出：44
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 40 
// 1 <= arr[i] <= 15 
// 答案保证是一个 32 位带符号整数，即小于 2³¹ 。 
// 
//
// Related Topics 栈 贪心 数组 动态规划 单调栈 👍 331 👎 0


package leetcode.editor.cn;

import org.junit.Test;

/**
 * 叶值的最小代价生成树
 *
 * @author chenws
 * @date 2023-05-31 14:14:05
 */
public class P1130_MinimumCostTreeFromLeafValues {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1130_MinimumCostTreeFromLeafValues().new Solution();
        System.out.println(solution.mctFromLeafValues(new int[]{6, 2, 4}));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        int sum = 0;

        public int mctFromLeafValues(int[] arr) {
            dfs(arr, 0, arr.length - 1);
            return sum;
        }


        //找准题意： 1、非叶节点的值是由左右子树中的最大值乘积得来； 2、中序遍历结果中叶子结点的相对顺序要和数组一样；
        //
        //分析可以理解为：找每一段中的最大值，因为非叶节点的值是由左右子树中的最大值乘积得来，所以每一段区间中的最大值，
        // 要层深尽可能低，则找到最大值，就左右两边继续分子树，保证当前区间段层深不会还有比自己更小的（会有同层深，不允许层低）。
        //
        //作者：故里
        //链接：https://leetcode.cn/problems/minimum-cost-tree-from-leaf-values/solutions/2290630/you-ge-di-gui-fen-zhi-zhe-chong-si-lu-bu-c3kp/
        //来源：力扣（LeetCode）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        //6 2 4
        public int dfs(int[] arr, int l, int r) {
            if (l > r) {
                return -1;
            }
            int max = -1;
            int index = -1;
            for (int i = l; i <= r; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    index = i;
                }
            }
            int left = dfs(arr, l, index - 1);
            int right = dfs(arr, index + 1, r);
            if (left != -1) {
                sum += left * max;
            }
            if (right != -1) {
                sum += right * max;
            }
            return max;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
