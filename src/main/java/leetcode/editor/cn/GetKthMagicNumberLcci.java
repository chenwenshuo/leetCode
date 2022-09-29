package leetcode.editor.cn;

//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 146 👎 0

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class GetKthMagicNumberLcci{
         public static void main(String[] args) {
            Solution solution = new GetKthMagicNumberLcci().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
             //1.最小堆
    public int getKthMagicNumber(int k) {
        PriorityQueue<Long> queue=new PriorityQueue();
        int[] tem=new int[]{3,5,7};
        Set<Long> set = new HashSet<>();
        set.add(1L);
        queue.add(1L);
        while (!queue.isEmpty()){
            long t=queue.poll();
            if (--k==0) return (int) t;

            for (int i : tem) {
                if (set.contains(i*t)) continue;
                queue.add(t*i);
                set.add(t*i);
            }
        }
        return -1;
    }

    //2.动态规划
    public int getKthMagicNumber1(int k) {
        //单独计算
        int[] ans = new int[k + 1];
        ans[1] = 1;
        for (int i3 = 1, i5 = 1, i7 = 1, idx = 2; idx <= k; idx++) {
            int a = ans[i3] * 3, b = ans[i5] * 5, c = ans[i7] * 7;
            int min = Math.min(a, Math.min(b, c));
            if (min == a) i3++;
            if (min == b) i5++;
            if (min == c) i7++;
            ans[idx] = min;
        }
        return ans[k];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
