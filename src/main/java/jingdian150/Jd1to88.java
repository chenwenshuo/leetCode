package jingdian150;

public class Jd1to88 {

    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] tem = new int[m];
        System.arraycopy(nums1, 0, tem, 0, m);
        int l1 = 0, l2 = 0;
        int t = 0;
        while (l1 < m || l2 < n) {
            if (l1==m){
                nums1[t]=nums2[l2];
                l2++;
                t++;
                continue;
            }
            if (l2==n){
                nums1[t]=tem[l1];
                l1++;
                t++;
                continue;
            }
            if (tem[l1]<=nums2[l2]){
                nums1[t] = tem[l1];
                l1++;
                t++;
                continue;
            }
            nums1[t]=nums2[l2];
            l2++;
            t++;
        }
    }


    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while(len2>=0) {
             if (len1>=0&&nums1[len1]>=nums2[len2]){
                 nums1[len--] = nums1[len1--];
             }else {
                 nums1[len--] = nums2[len2--];
             }
        }

    }
}
