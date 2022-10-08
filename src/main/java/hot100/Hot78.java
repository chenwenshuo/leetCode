package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 * 通过次数530,457提交次数656,318
 */
public class Hot78 {

    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        dfs(nums,0,new ArrayList<>());
        return ans;

    }

    private void dfs(int[] nums, int c,List<Integer> list) {
        ans.add(new ArrayList<>(list));

        for (int i = c; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }
}
