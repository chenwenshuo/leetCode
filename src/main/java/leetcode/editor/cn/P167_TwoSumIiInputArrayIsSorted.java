//给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这
//两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.
//length 。 
//
// 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。 
//
// 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。 
//
// 你所设计的解决方案必须只使用常量级的额外空间。 
//
// 示例 1： 
//
// 
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。 
//
// 示例 2： 
//
// 
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
//解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。 
//
// 示例 3： 
//
// 
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
//解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= numbers.length <= 3 * 10⁴ 
// -1000 <= numbers[i] <= 1000 
// numbers 按 非递减顺序 排列 
// -1000 <= target <= 1000 
// 仅存在一个有效答案 
// 
//
// Related Topics 数组 双指针 二分查找 👍 1132 👎 0


package leetcode.editor.cn;

import java.util.Random;

/**
 * 两数之和 II - 输入有序数组
 *
 * @author chenws
 * @date 2023-09-27 14:16:47
 */
public class P167_TwoSumIiInputArrayIsSorted {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P167_TwoSumIiInputArrayIsSorted().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] twoSum(int[] numbers, int target) {
            for (int l = 0, r = numbers.length - 1; l < r; ) {
                int number = numbers[l];
                int number1 = numbers[r];
                if (number1 + number == target) {
                    return new int[]{l, r};
                }
                if (number1 + number > target) {
                    r--;
                    continue;
                }
                l++;
            }
            return new int[]{};

        }

        public int[] twoSum1(int[] numbers, int target) {
            for (int i = 0; i < numbers.length - 1; i++) {
                int l = i + 1, r = numbers.length - 1;
                int t = target - numbers[i];
                while (l <= r) {
                    int mid = l + r >>> 1;
                    if (numbers[mid] == t) {
                        return new int[]{i + 1, mid + 1};
                    }
                    if (numbers[mid] > t) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }

            return new int[]{-1, -1};
        }

        public int[] twoSum2(int[] numbers, int target) {
            int i = 0, j = numbers.length - 1;
            while (i < j) {
                int m = (i + j) >>> 1;
                if (numbers[i] + numbers[m] > target) {
                    j = m - 1;
                    continue;
                }
                if (numbers[m] + numbers[j] < target) {
                    i = m + 1;
                    continue;
                }
                if (numbers[i] + numbers[j] > target) {
                    j--;
                    continue;
                }
                if (numbers[i] + numbers[j] < target) {
                    i++;
                    continue;
                }
                return new int[]{i + 1, j + 1};
            }

            return new int[]{-1, -1};
        }


    }        //leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {

        public int[] sortArray(int[] nums) {

            int l = 0;
            int r = nums.length - 1;
            fsort(nums, l, r);
            return nums;
        }

        private void fsort(int[] nums, int l, int r) {
            if (l > r) {
                return;
            }
            int t = new Random().nextInt(r - l + 1) + l;
            int key = nums[t];
            swap(nums, t, l);

            int i = l;
            int j = r;
            while (l < r) {
                while (r > l && key <= nums[r]) {
                    r--;
                }
                nums[l] = nums[r];
                while (l < r && key > nums[l]) {
                    l++;
                }
                nums[r] = nums[l];
            }
            nums[l] = key;
            fsort(nums, i, l - 1);
            fsort(nums, l + 1, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
