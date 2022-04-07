package leetcode.editor.cn;

//////给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 
//* 
////i 
//////+ 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。 
//////
////// 
//////
////// 示例 1： 
//////
////// 
//////输入：arr = [3,1,3,6]
//////输出：false
////// 
//////
////// 示例 2： 
//////
////// 
//////输入：arr = [2,1,2,6]
//////输出：false
////// 
//////
////// 示例 3： 
//////
////// 
//////输入：arr = [4,-2,2,-4]
//////输出：true
//////解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
////// 
//////
////// 
//////
////// 提示： 
//////
////// 
////// 0 <= arr.length <= 3 * 10⁴ 
////// arr.length 是偶数 
////// -10⁵ <= arr[i] <= 10⁵ 
////// 
////// Related Topics 贪心 数组 哈希表 排序 👍 143 👎 0
////
//

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayOfDoubledPairs{
         public static void main(String[] args) {
           Map<String ,Set<Integer>> map=new HashMap<>();
             HashSet<Integer> integers = new HashSet<>();
             integers.add(2);
             map.put("a",integers);
             map.get("a").add(3);
             System.out.println(map);

 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Set<Integer> set=new HashSet<>();
        for (int i : arr) {
            int a=-i;
            if (set.contains(a)){
                set.remove(a);
                continue;
            }
            set.add(i);
        }
        if (set.size()==0)
            return true;
        return  false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
