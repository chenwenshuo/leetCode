//给你一个长度为 5 的字符串 time ，表示一个电子时钟当前的时间，格式为 "hh:mm" 。最早 可能的时间是 "00:00" ，最晚 可能的时间是 
//"23:59" 。 
//
// 在字符串 time 中，被字符 ? 替换掉的数位是 未知的 ，被替换的数字可能是 0 到 9 中的任何一个。 
//
// 请你返回一个整数 answer ，将每一个 ? 都用 0 到 9 中一个数字替换后，可以得到的有效时间的数目。 
//
// 
//
// 示例 1： 
//
// 输入：time = "?5:00"
//输出：2
//解释：我们可以将 ? 替换成 0 或 1 ，得到 "05:00" 或者 "15:00" 。注意我们不能替换成 2 ，因为时间 "25:00" 是无效时间。所
//以我们有两个选择。
// 
//
// 示例 2： 
//
// 输入：time = "0?:0?"
//输出：100
//解释：两个 ? 都可以被 0 到 9 之间的任意数字替换，所以我们总共有 100 种选择。
// 
//
// 示例 3： 
//
// 输入：time = "??:??"
//输出：1440
//解释：小时总共有 24 种选择，分钟总共有 60 种选择。所以总共有 24 * 60 = 1440 种选择。
// 
//
// 
//
// 提示： 
//
// 
// time 是一个长度为 5 的有效字符串，格式为 "hh:mm" 。 
// "00" <= hh <= "23" 
// "00" <= mm <= "59" 
// 字符串中有的数位是 '?' ，需要用 0 到 9 之间的数字替换。 
// 
//
// Related Topics 字符串 枚举 👍 37 👎 0


package leetcode.editor.cn;

/**
 * 有效时间的数目
 *
 * @author chenws
 * @date 2023-05-09 10:48:06
 */
public class P2437_NumberOfValidClockTimes {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2437_NumberOfValidClockTimes().new Solution();
        System.out.println(solution.countTime("?2:16"));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countTime(String time) {
            char[] charArray = time.toCharArray();
            int s = 1;
            int f = 1;

            if (charArray[0] == '?') {
                if (charArray[1] == '?') {
                    s = 24;
                } else {
                    s = charArray[1] > '3' ? 2 : 3;
                }
            } else {
                if (charArray[1] == '?') {
                    s = charArray[0] < '2' ? 10 : 4;
                }
            }

            if (charArray[3] == '?') {
                if (charArray[4] == '?') {
                    f = 60;
                } else {
                    f = 6;
                }
            } else {
                if (charArray[4] == '?') {
                    f = 10;
                }
            }

            return s * f;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
