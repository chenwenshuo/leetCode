//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。 
//
// 返回平面上所有回旋镖的数量。 
//
// 示例 1： 
//
// 
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 500 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 所有点都 互不相同 
// 
//
// Related Topics 数组 哈希表 数学 👍 295 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 回旋镖的数量
 *
 * @author chenws
 * @date 2024-01-08 17:33:48
 */
public class P447_NumberOfBoomerangs {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P447_NumberOfBoomerangs().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans;

        public int numberOfBoomerangs(int[][] points) {
            if (points.length < 3) {
                return 0;
            }

            for (int i = 0; i < points.length; i++) {
                Map<Integer,Integer> map = new HashMap<>();
                for (int j = 0; j < points.length; j++) {
                    map.merge(oj(points[i],points[j]),1, Integer::sum);
                }
                for (Integer value : map.values()) {
                    ans+=value*(value-1);
                }
            }
            return ans;
        }

        private int oj(int[] point, int[] point1) {
            return  (point[0] - point1[0]) * (point[0] - point1[0]) + (point[1] - point1[1]) * (point[1] - point1[1]);
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

}
