package leetcode.editor.cn;

//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 1054 👎 0

public class HouseRobberIi{
         public static void main(String[] args) {
            Solution solution = new HouseRobberIi().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length==1) return nums[0];
        if (length==2) return Math.max(nums[0],nums[1]);

        int[] dp=new int[length];
        dp[0]=nums[0];
        dp[1]=nums[0];

        int[] dp1=new int[length];
        dp1[1]=nums[1];
        dp1[2]=Math.max(nums[2],nums[1]);


        for (int i = 2; i < nums.length; i++) {
            //从0开始
            if (i!=length-1){
                dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);}

            //从1开始
            if (i>2){
                dp1[i]=Math.max(dp1[i-2]+nums[i],dp1[i-1]);
            }
        }
        return Math.max(dp[length-2],dp1[length-1]);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
