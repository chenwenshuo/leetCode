//「力扣挑战赛」心算项目的挑战比赛中，要求选手从 `N` 张卡牌中选出 `cnt` 张卡牌，若这 `cnt` 张卡牌数字总和为偶数，则选手成绩「有效」且得分为
// `cnt` 张卡牌数字总和。
//给定数组 `cards` 和 `cnt`，其中 `cards[i]` 表示第 `i` 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分
//的卡牌方案，则返回 0。
//
//**示例 1：**
//>输入：`cards = [1,2,8,9], cnt = 3`
//>
//>输出：`18`
//>
//>解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。
//
//**示例 2：**
//>输入：`cards = [3,3,1], cnt = 1`
//>
//>输出：`0`
//>
//>解释：不存在获取有效得分的卡牌方案。
//
//**提示：**
//- `1 <= cnt <= cards.length <= 10^5`
//- `1 <= cards[i] <= 1000`
//
//
// Related Topics 贪心 数组 排序 
// 👍 39 👎 0

package leetcode.editor.cn;


import java.util.*;
import java.util.stream.Collectors;

public class UOAnQW {
    public static void main(String[] args) {
        Solution solution = new UOAnQW().new Solution();
        System.out.println(solution.maxmiumScore(new int[]{8,7,6,5,1},4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxmiumScore(int[] cards, int cnt) {

        List<Integer> collect = Arrays.stream(cards).boxed().sorted((a, b) -> b - a).collect(Collectors.toList());

        List<Integer> odd=new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        int tem=0;
        int tem1=0;
        for (int i = 0; i < collect.size(); i++) {
            int num=collect.get(i);

                if (num%2==0){
                    tem+=num;
                    even.add(tem);

                }
                else{
                    tem1+=num;
                    odd.add(tem1);
                }

        }
        if (cnt>collect.size()&&(cnt-even.size())%2==1){
            return 0;
        }

        int ans=0;
        for (int i = 1; i<= cnt; i++) {

        }


        return ans;
}
//leetcode submit region end(Prohibit modification and deletion)

}}