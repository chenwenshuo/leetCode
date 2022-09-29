package hot100;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库的sort函数的情况下解决这个问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * @Author: chenwenshuo
 * @Date: 2022/09/29/11:45
 */
public class Hot75 {
    public static void main(String[] args) {
        new Hot75().sortColors(new int[]{2,0,2,1,1,0});
    }
    public void sortColors(int[] nums) {
        int length = nums.length;
        int[] tem=new int[3];
        for (int i = 0; i < length; i++) {
            tem[nums[i]]++;
        }

        int a=0;
        for (int i = 0; i < tem.length; i++) {
            Arrays.fill(nums,a, a+tem[i],i);
            a+=tem[i];

        }
        System.out.println(1);
    }
}
