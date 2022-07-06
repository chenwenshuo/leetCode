package leetcode.editor.cn;

//给你一个整数数组 nums 和一个正整数 threshold ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。 
//
// 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。 
//
// 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。 
//
// 题目保证一定有解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,5,9], threshold = 6
//输出：5
//解释：如果除数为 1 ，我们可以得到和为 17 （1+2+5+9）。
//如果除数为 4 ，我们可以得到和为 7 (1+1+2+3) 。如果除数为 5 ，和为 5 (1+1+1+2)。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3,5,7,11], threshold = 11
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：nums = [19], threshold = 5
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10^4 
// 1 <= nums[i] <= 10^6 
// nums.length <= threshold <= 10^6 
// 
// Related Topics 数组 二分查找 👍 73 👎 0

public class FindTheSmallestDivisorGivenAThreshold{
         public static void main(String[] args) {
            Solution solution = new FindTheSmallestDivisorGivenAThreshold().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l=1,r=(int)1e6,ans=0;

        while (l<=r){
            int mid=l+r>>1;
            if (check(nums,threshold,mid)){
                r=mid-1;
                ans=mid;
            }else {
                l=mid+1;
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int threshold, int mid) {
        int sum=0;
        for (int num : nums) {
            sum+=Math.ceil(num*1.0/mid);
        }
        return sum<=threshold;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
