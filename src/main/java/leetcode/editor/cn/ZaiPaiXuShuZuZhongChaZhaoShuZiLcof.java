package leetcode.editor.cn;

//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 👍 325 👎 0

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
         public static void main(String[] args) {
            Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length==0) return 0;

        int f=findF(nums,target);
        if (f==-1) return 0;
        int end=findE(nums,f,target);
        return end-f+1;

    }

    private int findE(int[] nums, int f, int target) {

        int l=f,r=nums.length-1;
        while (l<=r){
            int mid=l+r>>1;
            if (nums[mid]>target) r=mid-1;
            if (nums[mid]<target) l=mid+1;

            while (nums[mid]==target){
                if (mid==nums.length-1) return mid;
                if (nums[mid+1]==target){
                    mid=mid+1;
                }else {
                    return mid;
                }
            }

        }
        return -1;
    }

    private int findF(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=l+r>>1;
            if (nums[mid]>target) r=mid-1;
            if (nums[mid]<target) l=mid+1;

            while (nums[mid]==target){
                if (mid==0) return mid;
                if (nums[mid-1]==target){
                    mid=mid-1;
                }else {
                    return mid;
                }
            }

        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
