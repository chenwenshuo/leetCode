package hot100;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 * @Author: chenwenshuo
 * @Date: 2022/09/22/16:25
 */

public class hot4 {
    @Test
    public void test(){
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 2}, new int[]{3});
        System.out.println(medianSortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length;
        nums1 = Arrays.copyOf(nums1, nums1.length + nums2.length);

        System.arraycopy(nums2,0,nums1,length,nums2.length);

        Arrays.sort(nums1);
        int mid=nums1.length/2;
        if (nums1.length%2==0){
            return (double)(nums1[mid]+nums1[mid-1])/2;

        }
        return (double)(nums1[mid]);

    }

}
