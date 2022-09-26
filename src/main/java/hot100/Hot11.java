package hot100;

/**
 * 11. 盛最多水的容器
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 * @Author: chenwenshuo
 * @Date: 2022/09/23/17:47
 */
public class Hot11 {
    /**
     * 从两边向中间处理
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int length = height.length;
        int l=0;
        int r=length-1;
        int ans=0;
        while (l<r){
         ans=Math.max(ans,Math.min(height[l],height[r])*(r-l));
         if (height[l]<height[r]){
             l++;
         }else {
             r--;
         }

        }

        return ans;
    }
}
