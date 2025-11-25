package jingdian150;

import java.util.ArrayList;
import java.util.List;


public class Jdto46 {

    int[] t ;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        t = new int[nums.length];
        dfs(ans,nums,0,new ArrayList<>());
        return ans;

    }

    private void dfs(List<List<Integer>> ans, int[] nums, int index, List<Integer> tem) {
        if (tem.size()==nums.length){
            ans.add(new ArrayList<>(tem));
            return;
        }
      //  tem.add(nums[index]);
        for (int i = 0; i < nums.length; i++) {
           if (t[i]==1) continue;;
           t[i]=1;
           tem.add(nums[i]);
           dfs(ans,nums,0,tem);
           tem.remove(tem.size()-1);
        }
    }
}
