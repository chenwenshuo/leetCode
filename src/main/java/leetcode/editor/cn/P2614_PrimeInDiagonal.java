//给你一个下标从 0 开始的二维整数数组 nums 。 
//
// 返回位于 nums 至少一条 对角线 上的最大 质数 。如果任一对角线上均不存在质数，返回 0 。 
//
// 注意： 
//
// 
// 如果某个整数大于 1 ，且不存在除 1 和自身之外的正整数因子，则认为该整数是一个质数。 
// 如果存在整数 i ，使得 nums[i][i] = val 或者 nums[i][nums.length - i - 1]= val ，则认为整数 
//val 位于 nums 的一条对角线上。 
// 
//
// 
//
// 在上图中，一条对角线是 [1,5,9] ，而另一条对角线是 [3,5,7] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [[1,2,3],[5,6,7],[9,10,11]]
//输出：11
//解释：数字 1、3、6、9 和 11 是所有 "位于至少一条对角线上" 的数字。由于 11 是最大的质数，故返回 11 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [[1,2,3],[5,17,7],[9,11,10]]
//输出：17
//解释：数字 1、3、9、10 和 17 是所有满足"位于至少一条对角线上"的数字。由于 17 是最大的质数，故返回 17 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 300 
// nums.length == numsi.length 
// 1 <= nums[i][j] <= 4*10⁶ 
// 
//
// Related Topics 数组 数学 矩阵 数论 👍 11 👎 0


package leetcode.editor.cn;

/**
 * 对角线上的质数
 *
 * @author chenws
 * @date 2023-09-05 18:13:22
 */
public class P2614_PrimeInDiagonal {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2614_PrimeInDiagonal().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int n = 4 * 1000000;
        boolean[] isPrime = new boolean[n + 1];

        {
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
        }

        public int diagonalPrime(int[][] nums) {
            int len = nums.length;
            int ans = 0;
            for (int i = 0; i < len; i++) {
                if (isPrime[nums[i][i]]) {
                   ans =  Math.max(ans, nums[i][i]);
                }
                if (isPrime[nums[i][len - i - 1]]) {
                    ans =  Math.max(ans, nums[i][len - i - 1]);
                }

            }
            return ans;

        }

      /*  public boolean isp(int n){
            if (n<2) return true;
            for (int i =2 ;i*i<n;i++){
                if (i)
            }
        }*/
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
