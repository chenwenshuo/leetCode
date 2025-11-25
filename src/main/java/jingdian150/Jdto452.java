package jingdian150;

import java.util.Arrays;
import java.util.Comparator;

public class Jdto452 {
    //输入：points = [[10,16],[2,8],[1,6],[7,12]]
    //输出：2
    //解释：气球可以用2支箭来爆破:
    //-在x = 6处射出箭，击破气球[2,8]和[1,6]。
    //-在x = 11处发射箭，击破气球[10,16]和[7,12]。
    //示例 2：
    //
    //输入：points = [[1,2],[3,4],[5,6],[7,8]]
    //输出：4
    //解释：每个气球需要射出一支箭，总共需要4支箭。
    //示例 3：
    //
    //输入：points = [[1,2],[2,3],[3,4],[4,5]]
    //输出：2
    //解释：气球可以用2支箭来爆破:
    //- 在x = 2处发射箭，击破气球[1,2]和[2,3]。
    //- 在x = 4处射出箭，击破气球[3,4]和[4,5]。
    public int findMinArrowShots(int[][] points) {
       Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
       int ans = 1;
       int max = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > max) {
                ans++;
                max = points[i][1];
            }
        }
        return ans;
    }
}
