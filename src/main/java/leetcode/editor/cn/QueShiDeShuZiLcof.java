package leetcode.editor.cn;

//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 位运算 数组 哈希表 数学 二分查找 👍 283 👎 0

public class QueShiDeShuZiLcof{
         public static void main(String[] args) {
            Solution solution = new QueShiDeShuZiLcof().new Solution();
             System.out.println(solution.missingNumber(new int[]{0,1,3,4}));
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 0 1 2 3
     * 0 1 3 4
     * 1 2 3 4
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        int l=0, r=nums.length-1;
        while (l<=r){
            int mid=l+r>>1;
            if (nums[mid]==mid){
                l=mid+1;
            }
            if (nums[mid]>mid) r=mid-1;
        }

        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
