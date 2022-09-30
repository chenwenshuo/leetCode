package hot100;

/**
 * 31. 下一个排列
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * @Author: chenwenshuo
 * @Date: 2022/09/27/14:04
 */
public class Hot31 {
    public static void main(String[] args) {
        Hot31 hot31 = new Hot31();
        hot31.nextPermutation(new int[]{1,1});
    }

    /**
     * 流程：
     * 1 2 5 3 1 --》1 3 1 2 5
     * 找到从右向左 不是递增的第一个数  2
     * 与右边第一个大于他的数交换 3 --》13521
     * 右边正序排列--》13125
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int l=0,r=nums.length-1;
        while (r>l){
            if (nums[r]<=nums[r-1]){
                r--;
            }else {
                break;
            }
        }
       r=r-1;
        if (r >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[r] >= nums[j]) {
                j--;
            }
            swap(nums, r, j);
        }
        reverse(nums, r + 1);


            }

            public void swap(int[] nums, int i, int j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

            public void reverse(int[] nums, int start) {
                int left = start, right = nums.length - 1;
                while (left < right) {
                    swap(nums, left, right);
                    left++;
                    right--;
                }
            }
        }


