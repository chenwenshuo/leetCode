package jingdian150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Jdto56 {
    //示例 1：
    //
    //输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    //输出：[[1,6],[8,10],[15,18]]
    //解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    //示例 2：
    //
    //输入：intervals = [[1,4],[4,5]]
    //输出：[[1,5]]
    //解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
    //示例 3：
    //
    //输入：intervals = [[4,7],[1,4]]
    //输出：[[1,7]]
    //解释：区间 [1,4] 和 [4,7] 可被视为重叠区间。
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ans = new ArrayList<>();
        int[] t = new int[]{intervals[0][0], intervals[0][1]};
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= t[1]) {
                t[1] = Math.max(t[1], interval[1]);
                continue;
            }
            ans.add(new int[]{t[0], t[1]});
            t = interval;
        }

        ans.add(t);

        int[][] nums = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            nums[i] = ans.get(i);
        }
        return nums;
    }
}
