package hot100;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * @Author: chenwenshuo
 * @Date: 2022/09/28/15:59
 */
public class Hot53 {
    public static void main(String[] args) {
        System.out.println(new Hot53().maxSubArray(new int[]{5, 4, -1, 7, 8}));

    }

    /**
     * 前一个比较 tem表示连续最大值 当《0时候赋值为0
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int ans=nums[0];
        int tem=nums[0]>0?nums[0]:0;
        for (int i = 1; i < nums.length; i++) {
            ans=Math.max(ans,tem+nums[i]);
            tem=Math.max(0,tem+nums[i]);
        }
        return ans;
    }
}
