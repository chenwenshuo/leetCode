package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,5,2,6], k = 100
//输出：8
//解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 0
//输出：0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
// Related Topics 数组 滑动窗口 👍 477 👎 0

import java.util.ArrayList;
import java.util.List;

public class SubarrayProductLessThanK{
         public static void main(String[] args) {
            Solution solution = new SubarrayProductLessThanK().new Solution();
             System.out.println(solution.numSubarrayProductLessThanK(new int[]{1,1,1}, 2));
         }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
             int c=0;
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int a=1;
       // List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            dfs1(nums,k,i,a);
        }

        return c>=0?c:0;

    }
    private void dfs1(int[] nums, int k, int b, int a) {
        if (a*nums[b]<k){
            c++;
        }
        if (a*nums[b]>=k) return;
        if (a>=k) return;

        if (b+1>=nums.length) return;

        dfs1(nums,k,b+1,a*nums[b]);

    }
    private void dfs(int[] nums, int k, int b, int a,List<Integer> list) {
        if (a<k){
            c++;
            System.out.println(list);
        }
        if (a*nums[b]>=k) return;
        if (a>=k) return;

        if (b+1>=nums.length) return;

            list.add(nums[b]);
            dfs(nums,k,b+1,a*nums[b],list);
            list.remove(list.size()-1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
