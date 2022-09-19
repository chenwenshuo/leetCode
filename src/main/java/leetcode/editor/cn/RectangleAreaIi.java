package leetcode.editor.cn;

//我们给出了一个（轴对齐的）二维矩形列表 rectangles 。 对于 rectangle[i] = [x1, y1, x2, y2]，其中（x1，y1）是
//矩形 i 左下角的坐标，
// (xi1, yi1) 是该矩形 左下角 的坐标，
// (xi2, yi2) 是该矩形 右上角 的坐标。 
//
// 计算平面中所有 rectangles 所覆盖的 总面积 。任何被两个或多个矩形覆盖的区域应只计算 一次 。 
//
// 返回 总面积 。因为答案可能太大，返回
// 10⁹ + 7 的 模 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
//输出：6
//解释：如图所示，三个矩形覆盖了总面积为6的区域。
//从(1,1)到(2,2)，绿色矩形和红色矩形重叠。
//从(1,0)到(2,3)，三个矩形都重叠。
// 
//
// 示例 2： 
//
// 
//输入：rectangles = [[0,0,1000000000,1000000000]]
//输出：49
//解释：答案是 10¹⁸ 对 (10⁹ + 7) 取模的结果， 即 49 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rectangles.length <= 200 
// rectanges[i].length = 4
// 
// 0 <= xi1, yi1, xi2, yi2 <= 10⁹ 
// 矩形叠加覆盖后的总面积不会超越 2^63 - 1 ，这意味着可以用一个 64 位有符号整数来保存面积结果。 
// 
//
// Related Topics 线段树 数组 有序集合 扫描线 👍 184 👎 0

import java.util.*;

public class RectangleAreaIi{
         public static void main(String[] args) {
            Solution solution = new RectangleAreaIi().new Solution();

            String s="Line";
             String[] s1 = s.split("_");
             for (String s2 : s1) {
                 System.out.println(s2);
             }
             System.out.println(solution.rectangleArea1(new int[][]{{0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}}));
         }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int MOD = (int)1e9+7;
    public int rectangleArea(int[][] rs) {
        List<Integer> list = new ArrayList<>();
        long ans=0;
        for (int[] r : rs) {
            list.add(r[0]);
            list.add(r[2]);
        }
        Collections.sort(list);

        for (int i = 1; i < list.size(); i++) {
            int tem=list.get(i),tem1=list.get(i-1), a=tem-tem1;
            if (a==0) continue;

            List<int[]> lin=new ArrayList<>();
            for (int[] info : rs) {
                if (info[0] <= tem && tem1 <= info[2]) lin.add(new int[]{info[1], info[3]});
            }
            Collections.sort(lin, (l1, l2)->{
                return l1[0] != l2[0] ? l1[0] - l2[0] : l1[1] - l2[1];
            });
                //取当前列的并集
                //已经覆盖 未覆盖 没有值
                long tot = 0, l = -1, r1 = -1;
                for (int[] cur : lin) {
                    if (cur[0] > r1) {
                        tot += r1- l;
                        l = cur[0]; r1 = cur[1];
                    } else if (cur[1] > r1) {
                        r1 = cur[1];
                    }
                }
                tot += r1 - l;
                ans += tot *a ;
                ans %= MOD;


            }




        return (int) ans;
    }

    public int rectangleArea1(int[][] rs) {
        List<Integer> list = new ArrayList<>();
        for (int[] info : rs) {
            list.add(info[0]); list.add(info[2]);
        }
        Collections.sort(list);
        long ans = 0;
        for (int i = 1; i < list.size(); i++) {
            int a = list.get(i - 1), b = list.get(i), len = b - a;
            if (len == 0) continue;
            List<int[]> lines = new ArrayList<>();
            for (int[] info : rs) {
                if (info[0] <= a && b <= info[2]) lines.add(new int[]{info[1], info[3]});
            }
            Collections.sort(lines, (l1, l2)->{
                return l1[0] != l2[0] ? l1[0] - l2[0] : l1[1] - l2[1];
            });
            long tot = 0, l = -1, r = -1;
            int max=-1;
            int pre=0;
            for (int[] cur : lines) {
               /* if (cur[0] > r) {
                    tot += r - l;
                    l = cur[0]; r = cur[1];
                } else if (cur[1] > r) {
                    r = cur[1];
                }*/
                if (cur[1]<max)
                    continue;
                if (cur[0]>=max){
                    pre+=cur[1]-cur[0];
                    max=cur[1];
                }else if (cur[1]>max){
                    pre+=cur[1]-max;
                    max=cur[1];
                }

            }
            tot += r - l;
            ans += pre * len;
            ans %= MOD;
        }
        return (int) ans;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}
