package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 * @Author: chenwenshuo
 * @Date: 2022/09/27/18:21
 */
public class Hot46 {
    /**
     * 回溯+标记
     */

    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;

        int[] ints = new int[length];
        dfs(nums,new ArrayList<>(),0,ints);

        return ans;

    }

    private void dfs(int[] nums, List<Integer> tem, int n, int[] ints) {
        if (tem.size()==nums.length){
            ans.add(new ArrayList<>(tem));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (ints[i]==1) continue;
            ints[i]=1;
            tem.add(nums[i]);
            dfs(nums,tem,n,ints);
            tem.remove(tem.size()-1);
            ints[i]=0;

        }
    }
}
