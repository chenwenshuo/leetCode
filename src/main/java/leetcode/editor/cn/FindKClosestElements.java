package leetcode.editor.cn;

//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴ 
// arr 按 升序 排列 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 333 👎 0

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements{
         public static void main(String[] args) {
            Solution solution = new FindKClosestElements().new Solution();
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0,r=arr.length-1;
        while (l<r){
            if (r-l+1==k) break;
            if (Math.abs(arr[l]-x)<= Math.abs(arr[r]-x)){
                r--;
            }else {
                l++;
            }

        }
     List<Integer> list = new ArrayList<>();
        for (int i = l; i <=r; i++) {
           list.add(arr[i]);
            }

        return list;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
