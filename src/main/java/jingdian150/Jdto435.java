package jingdian150;

import java.util.Arrays;

public class Jdto435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int max = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int o = interval[0];
            int t = interval[1];
            if (o >= max) {
                max = t;
                continue;
            }
            max = Math.max(max, t);
            ans++;
        }

        return ans;
    }
}
