//给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数
//字的某个数位。
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [4,1,3], nums2 = [5,7]
//输出：15
//解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
// 
//
// 示例 2： 
//
// 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
//输出：3
//解释：数字 3 的数位 3 在两个数组中都出现了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 9 
// 1 <= nums1[i], nums2[i] <= 9 
// 每个数组中，元素 互不相同 。 
// 
//
// Related Topics 数组 哈希表 枚举 👍 36 👎 0


package leetcode.editor.cn;

/**
 * 从两个数字数组里生成最小数字
 *
 * @author chenws
 * @date 2023-09-05 09:54:38
 */
public class P2605_FormSmallestNumberFromTwoDigitArrays {

    public static boolean isP(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 6 != 1 && n % 6 != 5) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || (n % (i + 2)) == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int n = 100; // 求 0 到 100 之间的质数
        boolean[] isPrime = new boolean[n + 1]; // 标记数组，默认所有数都是质数
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true; // 初始化所有数为质数
        }
        for (int i = 2; i * i <= n; i++) { // 从 2 到 sqrt(n) 遍历
            if (isPrime[i]) { // 如果 i 是质数
                for (int j = i * i; j <= n; j += i) { // 将 i 的倍数标记为合数
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) { // 输出所有质数
            if (isPrime[i]) {
                System.out.print(i + " ");
                System.out.println(isP(i));
            }
        }
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minNumber(int[] nums1, int[] nums2) {
            int ans = 100;
            for (int i : nums1) {
                for (int j : nums2) {
                    if (i == j) {
                        ans = Math.min(ans, i);
                        continue;
                    }
                    if (i > j) {
                        ans = Math.min(ans, j * 10 + i);
                        continue;
                    }
                    ans = Math.min(ans, i * 10 + j);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
