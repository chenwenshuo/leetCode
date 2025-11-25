package jingdian150;

import java.util.List;

public class Jdto120 {

    public static void main(String[] args) {
        // [[2],[3,4],[6,5,7],[4,1,8,3]]
        System.out.println(minimumTotal(List.of(
                List.of(2),
                List.of(3,4),
                List.of(6,5,7),
                List.of(4,1,8,3)
        )));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int ans = Integer.MAX_VALUE;
        int size = triangle.size();
        int[] tems = new int[size];
        tems[0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = list.size() - 1; j >= 0; j--) {
                if (j == 0) {
                    tems[j] = tems[j] + list.get(j);
                    continue;
                }
                if (j == list.size() - 1) {
                    tems[j] = tems[j-1] + list.get(j);
                    continue;
                }
                tems[j] = Math.min(tems[j-1],tems[j])+list.get(j);

            }
        }

        for (int tem : tems) {
            ans = Math.min(ans,tem);
        }
        return ans;
    }
}
