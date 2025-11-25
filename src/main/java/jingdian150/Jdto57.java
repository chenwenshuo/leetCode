package jingdian150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jdto57 {

    //：intervals = [[1,3],[6,9]], newInterval = [2,5]

    //输出：[[1,5],[6,9]]

    //intervals = [[1,3],[6,9]], newInterval = [4,5]
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[1] < newInterval[0]) {
                ans.add(interval);
                continue;
            }
            if (interval[0] > newInterval[1] && flag) {
                ans.add(newInterval);
                flag = false;
            }
            if (interval[0] > newInterval[1]) {
                ans.add(interval);
                continue;
            }
            newInterval[0] = Math.min(newInterval[0], interval[0]);
            newInterval[1] = Math.max(newInterval[1], interval[1]);

        }
        if (flag) {
            ans.add(newInterval);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
