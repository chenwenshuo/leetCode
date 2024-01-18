//一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。 
//
// 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返回其位置
// [i,j] 。 
//
// 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。 
//
// 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法 
//
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: mat = [[1,4],[3,2]]
//输出: [0,1]
//解释: 3 和 4 都是峰值，所以[1,0]和[0,1]都是可接受的答案。
// 
//
// 示例 2: 
//
// 
//
// 
//输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
//输出: [1,1]
//解释: 30 和 32 都是峰值，所以[1,1]和[2,2]都是可接受的答案。
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 500 
// 1 <= mat[i][j] <= 10⁵ 
// 任意两个相邻元素均不相等. 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 122 👎 0


package leetcode.editor.cn;

/**
 * 寻找峰值 II
 *
 * @author chenws
 * @date 2023-12-19 14:39:39
 */
public class P1901_FindAPeakElementIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1901_FindAPeakElementIi().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findPeakGrid(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int l = 0, r = m - 2;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                int j = maxIdx(mat[mid]);
                if (mat[mid][j] > mat[mid+1][j]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return new int[]{l, maxIdx(mat[l])};
        }

        private int maxIdx(int[] a) {
            int max = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[max] < a[i]) {
                    max = i;
                }
            }
            return max;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
