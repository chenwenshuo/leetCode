package base;

import org.junit.Test;

public class Baseuy {

    //给你两个整数：num1 和 num2 。
    //
    //在一步操作中，你需要从范围 [0, 60] 中选出一个整数 i ，并从 num1 减去 2i + num2 。
    //
    //请你计算，要想使 num1 等于 0 需要执行的最少操作数，并以整数形式返回。
    //
    //如果无法使 num1 等于 0 ，返回 -1 。
    //
    //
    //
    //示例 1：
    //
    //输入：num1 = 3, num2 = -2
    //输出：3
    //解释：可以执行下述步骤使 3 等于 0 ：
    //- 选择 i = 2 ，并从 3 减去 22 + (-2) ，num1 = 3 - (4 + (-2)) = 1 。
    //- 选择 i = 2 ，并从 1 减去 22 + (-2) ，num1 = 1 - (4 + (-2)) = -1 。
    //- 选择 i = 0 ，并从 -1 减去 20 + (-2) ，num1 = (-1) - (1 + (-2)) = 0 。
    //可以证明 3 是需要执行的最少操作数。
    //示例 2：
    //
    //输入：num1 = 5, num2 = 7
    //输出：-1
    //解释：可以证明，执行操作无法使 5 等于 0 。
    @Test
    public void test() {
        System.out.println(minimumOperations(3, -2));
    }

    public int minimumOperations(int num1, int num2) {
        if (num2 % 2 != 0) {  // 如果 num1 是奇数，无法使其等于 0
            return -1;
        }
        int ans = 0, diff = num1 - num2;
        while (diff > 0) {  // 从大到小枚举 i，每次减去 2i + num2
            if (diff >= 2) {  // 如果 diff 大于等于 2，可以选择 i = diff / 2
                diff -= diff / 2 * 2;
            } else {  // 如果 diff 小于 2，只能选择 i = 0
                diff -= 2;
            }
            ans++;
        }
        return ans;
    }

    //给你一个二元数组 nums 。
    //
    //如果数组中的某个子数组 恰好 只存在 一 个值为 1 的元素，则认为该子数组是一个 好子数组 。
    //
    //请你统计将数组 nums 划分成若干 好子数组 的方法数，并以整数形式返回。由于数字可能很大，返回其对 109 + 7 取余 之后的结果。
    //
    //子数组是数组中的一个连续 非空 元素序列。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [0,1,0,0,1]
    //输出：3
    //解释：存在 3 种可以将 nums 划分成若干好子数组的方式：
    //- [0,1] [0,0,1]
    //- [0,1,0] [0,1]
    //- [0,1,0,0] [1]
    //示例 2：
    //
    //输入：nums = [0,1,0]
    //输出：1
    //解释：存在 1 种可以将 nums 划分成若干好子数组的方式：
    //- [0,1,0]

    @Test
    public void test1() {
        System.out.println(numberOfSubarrays(new int[]{1,0,1,0,0,0}));
    }

    //[1,0,0,0,0,0,1,0,1]
    public int numberOfSubarrays(int[] nums) {
        long ans = 1;
        int tem = -1;
        int a = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                a = 1;
                if (tem != -1) {

                    ans *= (i - tem);
                }
                tem = i;
            }
        }
        return ans == 1 && a == -1 ? 0 : (int) ans % 1000000007;
    }

}
