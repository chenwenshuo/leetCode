package leetcode.editor.cn.zs.Two99;

import java.util.Arrays;

/**
 * @Author: chenwenshuo
 * @Date: 2022/06/26/10:58 上午
 */
public class Two {

    public static void main(String[] args) {
        /**
         * [20,40,20,70,30]
         * [50,20,50,40,20]
         */
       /* int[] n=new int[]{20,40,20,70,30};
        int[] m=new int[]{50,20,50,40,20};*/
     /*   int[] n=new int[]{60,60,60};
        int[] m=new int[]{10,90,10};*/

        /**
         * [3,4,5,1,1,1,3,4,5,1,1,1]
         * [1,1,1,3,4,5,1,1,1,3,4,5]
         */
        int[] n=new int[]{3,4,5,1,1,1,3,4,5,1,1,1};
        int[] m=new int[]{1,1,1,3,4,5,1,1,1,3,4,5};
        System.out.println(maximumsSplicedArray(n, m));
    }
    public static int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        int max=Math.max(sum1,sum2);
        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < 2; j++) {
                int tem = nums1[i];
                nums1[i] = nums2[i];
                nums2[i] = tem;

                int a=i+j;
                if (a<nums1.length&&j==1){
                int tem2 = nums1[a];
                nums1[a] = nums2[a];
                nums2[a] = tem2;}

                sum1 = Arrays.stream(nums1).sum();
                sum2 = Arrays.stream(nums2).sum();
                max=Math.max(Math.max(sum1,sum2),max);

                tem = nums1[i];
                nums1[i] = nums2[i];
                nums2[i] = tem;

                if (a<nums1.length&&j==1){
                    int tem2 = nums1[a];
                    nums1[a] = nums2[a];
                    nums2[a] = tem2;
                }

            }



        }

        return max;
    }
}
