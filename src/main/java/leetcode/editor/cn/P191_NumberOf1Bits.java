//编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。 
//
// 
//
// 提示： 
//
// 
// 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的
//还是无符号的，其内部的二进制表示形式都是相同的。 
// 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 3 中，输入表示有符号整数 -3。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
// 
//
// 示例 2： 
//
// 
//输入：n = 00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
// 
//
// 示例 3： 
//
// 
//输入：n = 11111111111111111111111111111101
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。 
//
// 
//
// 提示： 
//
// 
// 输入必须是长度为 32 的 二进制串 。 
// 
//
// 
// 
//
// 
//
// 进阶： 
//
// 
// 如果多次调用这个函数，你将如何优化你的算法？ 
// 
//
// Related Topics 位运算 分治 👍 605 👎 0


package leetcode.editor.cn;

/**
 * 位1的个数
 * @author chenws
 * @date 2023-09-19 18:07:17
 */
public class P191_NumberOf1Bits{

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P191_NumberOf1Bits().new Solution();
        System.out.println(1^0);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int i) {

     /*
     * 观察这个运算：n & (n−1)n~\&~(n - 1)n & (n−1)，其运算结果恰为把 nnn 的二进制位中的最低位的 111 变为 000 之后的结果。

如：6 & (6−1)=4,6=(110)2,4=(100)26~\&~(6-1) = 4, 6 = (110)_2, 4 = (100)_26 & (6−1)=4,6=(110)
2
​
 ,4=(100)
2
​
 ，运算结果 444 即为把 666 的二进制位中的最低位的 111 变为 000 之后的结果。

这样我们可以利用这个位运算的性质加速我们的检查过程，在实际代码中，我们不断让当前的 nnn 与 n−1n - 1n−1 做与运算，直到 nnn 变为 000 即可。因为每次运算会使得 nnn 的最低位的 111 被翻转，因此运算次数就等于 nnn 的二进制位中 111 的个数。

作者：力扣官方题解
链接：https://leetcode.cn/problems/number-of-1-bits/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * */
        int ans = 0;
        while (i!=0){
            if ((i&1)==1){
                ans++;
            }
            i>>>=1;
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
