//给你一个整数数组 nums 和两个整数 firstLen 和 secondLen，请你找出并返回两个非重叠 子数组 中元素的最大和，长度分别为 
//firstLen 和 secondLen 。 
//
// 长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后，但二者必须是不重叠的。 
//
// 子数组是数组的一个 连续 部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
//输出：20
//解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
//输出：29
//解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
//输出：31
//解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= firstLen, secondLen <= 1000 
// 2 <= firstLen + secondLen <= 1000 
// firstLen + secondLen <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 滑动窗口 👍 224 👎 0


package leetcode.editor.cn;

/**
 * 两个非重叠子数组的最大和
 *
 * @author chenws
 * @date 2023-04-26 17:33:58
 */
public class P1031_MaximumSumOfTwoNonOverlappingSubarrays {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1031_MaximumSumOfTwoNonOverlappingSubarrays().new Solution();
        //[2,1,5,6,0,9,5,0,3,8]
        //4
        //3
        System.out.println(solution.maxSumTwoNoOverlap(new int[]{2,1,5,6,0,9,5,0,3,8}, 4, 3));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {

            int f = db(nums, firstLen, secondLen);
            int s = db(nums, secondLen, firstLen);
            return Math.max(f, s);
        }

        private int db(int[] nums, int firstLen, int secondLen) {
            int ans = 0;
            int[] prefix = new int[nums.length];
            prefix[0] = nums[0];
            for (int i = 1; i < prefix.length; i++) {
                prefix[i] = nums[i] + prefix[i - 1];
            }
            int f = prefix[firstLen - 1];
            int s = prefix[firstLen + secondLen - 1] - f;
            ans = f + s;

            for (int i = firstLen + secondLen, j = firstLen; i < nums.length; i++, j++) {
                f = Math.max(f, prefix[j] - prefix[j - firstLen]);
                s = prefix[i] - prefix[i - secondLen];
                //2,1,5,6,0,9,5,0,3,8
                //0 1 2 3 4 5 6 7 8 9
                for (int k = i+1; k < nums.length; k++) {
                    s = Math.max(prefix[k] - prefix[k - secondLen], s);
                }

                ans = Math.max(ans, f + s);
            }

            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
