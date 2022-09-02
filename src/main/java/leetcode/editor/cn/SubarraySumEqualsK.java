package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 1653 👎 0

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK{
         public static void main(String[] args) {
            Solution solution = new SubarraySumEqualsK().new Solution();
             System.out.println(solution.subarraySum(new int[]{1,2,3},3));
 }

//leetcode submit region begin(Prohibit modification and deletion)

    public class Solution {

        public int subarraySum(int[] nums, int k) {
            Map<Integer,Integer> map=new HashMap<>();

            map.put(0,1);

            int pre=0;

            int ans=0;
            for (int num : nums) {
                pre+=num;
                if (map.containsKey(pre-k)){
                    ans+=map.get(pre-k);
                }

                map.put(pre,map.getOrDefault(pre,0)+1);
            }

            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
