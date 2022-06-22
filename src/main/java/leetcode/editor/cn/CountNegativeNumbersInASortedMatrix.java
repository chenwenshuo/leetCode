package leetcode.editor.cn;

//给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//输出：8
//解释：矩阵中共有 8 个负数。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[3,2],[1,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// -100 <= grid[i][j] <= 100 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？ 
// Related Topics 数组 二分查找 矩阵 👍 98 👎 0

public class CountNegativeNumbersInASortedMatrix{
         public static void main(String[] args) {
            Solution solution = new CountNegativeNumbersInASortedMatrix().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 二分找每行
     */
    class Solution {
    public int countNegatives(int[][] grid) {


        int result = 0;
        for (int[] item : grid) {
            int l = 0;
            int r = item.length - 1;
            int pos = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (item[mid] < 0) {
                    pos = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (pos != -1) {
                result += item.length - pos;
            }
        }
        return result;




    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
