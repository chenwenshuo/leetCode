package leetcode.editor.cn;

//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
//
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 770 👎 0

import java.util.Arrays;

public class PartitionToKEqualSumSubsets{
         public static void main(String[] args) {
            Solution solution = new PartitionToKEqualSumSubsets().new Solution();
             System.out.println(solution.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1},4));
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (sum % k != 0) return false;
        int target = sum / k;
        int[] bucket = new int[k + 1];
        return backtrack(nums, 0, bucket, k, target);
    }
    // index : 第 index 个球开始做选择
// bucket : 桶
    private boolean backtrack(int[] nums, int index, int[] bucket, int k, int target) {

        // 结束条件：已经处理完所有球
        if (index == nums.length) {
            // 判断现在桶中的球是否符合要求 -> 路径是否满足要求
            for (int i = 0; i < k; i++) {
                if (bucket[i] != target) return false;
            }
            return true;
        }

        // nums[index] 开始做选择
        for (int i = 0; i < k; i++) {
          if (bucket[i]+nums[index]>target){
              continue;
          }
          bucket[i]+=nums[index];
          boolean f=backtrack(nums,index+1,bucket,k,target);
          if (f) return true;
            bucket[i]-=nums[index];
        }

        // k 个桶都不满足要求
        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
