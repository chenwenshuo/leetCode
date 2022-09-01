package leetcode.editor.cn;

//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 1
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 805 👎 0

public class SpiralMatrixIi{
         public static void main(String[] args) {
            Solution solution = new SpiralMatrixIi().new Solution();
 }

    class Solution {
        public int[][] generateMatrix(int n) {
            int l = 0, r = n - 1, t = 0, b = n - 1;
            int[][] mat = new int[n][n];
            int num = 1, tar = n * n;
            while(num <= tar){
                for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
                t++;
                for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
                r--;
                for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
                b--;
                for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
                l++;
            }
            return mat;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
