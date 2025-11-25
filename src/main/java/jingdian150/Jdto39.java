package jingdian150;

import java.util.ArrayList;
import java.util.List;

public class Jdto39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        dfs(ans,candidates,target,0,new ArrayList<>());
        return ans;

    }

    private void dfs(List<List<Integer>> ans, int[] candidates, int target, int index,List<Integer> tem) {
        if (target==0){
            ans.add(new ArrayList<>(tem));
            return;
        }
        if (target<0) return;
        for (int i = index; i < candidates.length; i++) {
            tem.add(candidates[i]);
            dfs(ans,candidates,target-candidates[i],i,tem);
            tem.remove(tem.size()-1);
        }
    }
}
