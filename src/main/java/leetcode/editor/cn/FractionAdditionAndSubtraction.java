package leetcode.editor.cn;

//给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
//
// 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为
// 2/1。 
//
// 
//
// 示例 1: 
//
// 
//输入: expression = "-1/2+1/2"
//输出: "0/1"
// 
//
// 示例 2: 
//
// 
//输入: expression = "-1/2+1/2+1/3"
//输出: "1/3"
// 
//
// 示例 3: 
//
// 
//输入: expression = "1/3-1/2"
//输出: "-1/6"
// 
//
// 
//
// 提示: 
//
// 
// 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
// 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。 
// 输入只包含合法的最简分数，每个分数的分子与分母的范围是 [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。 
// 输入的分数个数范围是 [1,10]。 
// 最终结果的分子与分母保证是 32 位整数范围内的有效整数。 
// 
//
// Related Topics 数学 字符串 模拟 👍 98 👎 0

public class FractionAdditionAndSubtraction{
         public static void main(String[] args) {
            Solution solution = new FractionAdditionAndSubtraction().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionAddition(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        String ans = "";
        for (int i = 0; i < n; ) {
            int j = i + 1;
            while (j < n && cs[j] != '+' && cs[j] != '-') j++;
            String num = s.substring(i, j);
            if (cs[i] != '+' && cs[i] != '-') num = "+" + num;
            if (!ans.equals("")) ans = calc(num, ans);
            else ans = num;
            i = j;
        }
        return ans.charAt(0) == '+' ? ans.substring(1) : ans;
    }
    String calc(String a, String b) {
        boolean fa = a.charAt(0) == '+', fb = b.charAt(0) == '+';
        if (!fa && fb) return calc(b, a);
        long[] p = parse(a), q = parse(b);
        long p1 = p[0] * q[1], q1 = q[0] * p[1];
        if (fa && fb) {
            long r1 = p1 + q1, r2 = p[1] * q[1], c = gcd(r1, r2);
            return "+" + (r1 / c) + "/" + (r2 / c);
        } else if (!fa && !fb) {
            long r1 = p1 + q1, r2 = p[1] * q[1], c = gcd(r1, r2);
            return "-" + (r1 / c) + "/" + (r2 / c);
        } else {
            long r1 = p1 - q1, r2 = p[1] * q[1], c = gcd(Math.abs(r1), r2);
            String ans = (r1 / c) + "/" + (r2 / c);
            if (p1 >= q1) ans = "+" + ans;
            return ans;
        }
    }
    long[] parse(String s) {
        int n = s.length(), idx = 1;
        while (idx < n && s.charAt(idx) != '/') idx++;
        long a = Long.parseLong(s.substring(1, idx)), b = Long.parseLong(s.substring(idx + 1));
        return new long[]{a, b};
    }
    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
