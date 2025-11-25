package jingdian150;

import java.util.ArrayList;
import java.util.List;

public class Jdto77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        dfs(ans, 1, n, k, new ArrayList<>());
        return ans;

    }

    private void dfs(List<List<Integer>> ans, int cur, int n, int k, List<Integer> tem) {
        if (k == 0) {
            ans.add(new ArrayList<>(tem));
            return;
        }
        for (int i = cur; i <= n; i++) {
            tem.add(i);
            dfs(ans, i + 1, n, k-1, tem);
            tem.remove(tem.size() - 1);
        }

    }
}
