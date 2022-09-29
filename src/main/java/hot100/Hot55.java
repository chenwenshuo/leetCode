package hot100;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 * @Author: chenwenshuo
 * @Date: 2022/09/28/16:11
 */
public class Hot55 {
    /**
     * dp 每次取最远的跳跃位置 看是否可以到达 f(x)=Max(f(x-1),num[i]+i)
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int ans=nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (ans<i) return false;
            if (ans>=nums.length-1) return true;
            ans=Math.max(ans,i+nums[i]);
        }
        return ans>=nums.length-1?true:false;

    }

}
