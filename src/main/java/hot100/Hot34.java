package hot100;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * 通过次数652,234提交次数1,542,832
 * @Author: chenwenshuo
 * @Date: 2022/09/27/17:56
 */
public class Hot34 {
    public static void main(String[] args) {
        System.out.println(new Hot34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0) return new int[]{-1,-1};

        int l=findLeft(nums,target);
        if (l==-1) return new int[]{-1,-1};
        int r=findRight(nums,target);

        return new int[]{l,r};
    }

    private int findRight(int[] nums, int target) {
        int r = nums.length-1;
        int l=0;

        while (l<=r){
            int mid=(l+r)>>1;
            if (nums[mid]==target){
                if (mid==nums.length-1||nums[mid]<nums[mid+1]){
                    return mid;
                }else {
                    l=mid+1;
                }
            }else if (nums[mid]>target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return -1;

    }

    private int findLeft(int[] nums, int target) {
        int r = nums.length-1;
        int l=0;

        while (l<=r){
            int mid=(l+r)>>1;
            if (nums[mid]==target){
                if (mid==0||nums[mid]>nums[mid-1]){
                    return mid;
                }else {
                    r=mid-1;
                }
            }else if (nums[mid]>target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return -1;
    }
}
