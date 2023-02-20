//给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。 
//
// 正整数的 各位数字之和 是其所有位上的对应数字相加的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 4
//输出：2
//解释：
//只有 2 和 4 满足小于等于 4 且各位数字之和为偶数。    
// 
//
// 示例 2： 
//
// 
//输入：num = 30
//输出：14
//解释：
//只有 14 个整数满足小于等于 30 且各位数字之和为偶数，分别是： 
//2、4、6、8、11、13、15、17、19、20、22、24、26 和 28 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 1000 
// 
//
// Related Topics 数学 模拟 👍 52 👎 0


package leetcode.editor.cn;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 统计各位数字之和为偶数的整数个数
 * @author chenws
 * @date 2023-01-06 17:39:51
 */
public class P2180_CountIntegersWithEvenDigitSum{

	public static void main(String[] args) {
		System.out.println(1+1);
	}
	private static LocalDate getMonthStartBillingPeriodDateFromServiceDate(LocalDate serviceStart, int contractStartDay) {
		LocalDate monthStart = serviceStart;

		if (serviceStart.getDayOfMonth() != contractStartDay) {
			LocalDate billingPeriodStartDateAdjusted = LocalDate.of(serviceStart.getYear(), serviceStart.getMonthValue(), 1).minusDays(1);

			if (contractStartDay < serviceStart.getDayOfMonth()) {
				billingPeriodStartDateAdjusted = serviceStart;
			}

			if (serviceStart.getMonthValue() < billingPeriodStartDateAdjusted.getMonthValue() &&
				(serviceStart.getMonthValue() != 1 && billingPeriodStartDateAdjusted.getMonthValue() != 12)) {
				billingPeriodStartDateAdjusted = serviceStart;
			}

			while (billingPeriodStartDateAdjusted.getDayOfMonth() > contractStartDay) {
				billingPeriodStartDateAdjusted = billingPeriodStartDateAdjusted.minusDays(1);
			}

			if (!serviceStart.isEqual(billingPeriodStartDateAdjusted)) {
				monthStart = billingPeriodStartDateAdjusted;
			}
		}

		return monthStart;
	}class Solution {
    public int countEven(int num) {
			int t = 0;
			for (int j = num; j > 0; j /= 10) {
				t += j % 10;
			}
			return t % 2 == 1 ? --num / 2 : num / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
