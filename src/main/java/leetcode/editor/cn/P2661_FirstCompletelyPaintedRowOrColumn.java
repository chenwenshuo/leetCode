//给你一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数 矩阵 mat 。arr 和 mat 都包含范围 [1，m * n] 内的 所有 整数
//。 
//
// 从下标 0 开始遍历 arr 中的每个下标 i ，并将包含整数 arr[i] 的 mat 单元格涂色。 
//
// 请你找出 arr 中在 mat 的某一行或某一列上都被涂色且下标最小的元素，并返回其下标 i 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：arr = [1,3,4,2], mat = [[1,4],[2,3]]
//输出：2
//解释：遍历如上图所示，arr[2] 在矩阵中的第一行或第二列上都被涂色。
// 
//
// 示例 2： 
// 
// 
//输入：arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
//输出：3
//解释：遍历如上图所示，arr[3] 在矩阵中的第二列上都被涂色。
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n = mat[i].length 
// arr.length == m * n 
// 1 <= m, n <= 10⁵ 
// 1 <= m * n <= 10⁵ 
// 1 <= arr[i], mat[r][c] <= m * n 
// arr 中的所有整数 互不相同 
// mat 中的所有整数 互不相同 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 37 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出叠涂元素
 *
 * @author chenws
 * @date 2023-12-01 10:52:32
 */
public class P2661_FirstCompletelyPaintedRowOrColumn {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2661_FirstCompletelyPaintedRowOrColumn().new Solution();
        System.out.println(solution.firstCompleteIndex(new int[]{1,3,4,2},new int[][]{{1, 4},{2,3}}));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int firstCompleteIndex(int[] arr, int[][] mat) {

            int m = mat.length;
            int n = mat[0].length;
            int[][] map = new int[arr.length+1][2];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    map[mat[i][j]] = new int[]{i, j};
                }
            }
            int[] h = new int[m];
            int[] l = new int[n];
            for (int i = 0; i < arr.length; i++) {
                int[] nums = map[arr[i]];
                h[nums[0]]++;
                l[nums[1]]++;
                if (h[nums[0]] == n || l[nums[1]] == m) {
                    return i;
                }
            }

            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
