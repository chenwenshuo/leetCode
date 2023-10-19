//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1342 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和 II
 *
 * @author chenws
 * @date 2023-05-19 14:47:21
 */
public class P40_CombinationSumIi {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P40_CombinationSumIi().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> list = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(list, new ArrayList<>(), 0, candidates, target);
            return list;

        }

        private void dfs(List<List<Integer>> list, ArrayList<Integer> objects, int i, int[] candidates, int target) {
            if (target == 0) {
                list.add(new ArrayList<>(objects));
            }
            if (target < 0) {
                return;
            }
            for (int j = i; j < candidates.length; j++) {
                if (j > i && candidates[j] == candidates[j - 1]) {
                    continue;
                }
                objects.add(candidates[j]);
                dfs(list, objects, j + 1, candidates, target - candidates[j]);
                objects.remove(objects.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
