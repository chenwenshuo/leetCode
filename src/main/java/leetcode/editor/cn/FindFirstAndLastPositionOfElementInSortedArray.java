//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1597 👎 0

package leetcode.editor.cn;
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {

        if (nums.length==0||nums[0]>target||nums[nums.length-1]<target) return new int[]{-1,-1};
        int[] ans=new int[2];
        int len = nums.length;
        int a= 0;
        int b=len-1;

        while (a<=b){
            if (nums[a]<target)
                a++;
            if (nums[b]>target)
                b--;
            if (nums[a]==target&&nums[b]==target){
                return new int[]{a,b};
            }
        }
            return  new int[]{-1,-1};
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}