package Sort;

public class FastSort {

    public static void main(String[] args) {
        int[] ints = new FastSort().fastSort(new int[]{0,1, 0, 0});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] fastSort(int[] nums){
        int l = 0;
        int r = nums.length-1;
        fastSort(nums,l,r);
        return nums;
    }

    //左边放小的，右边放大的，最后填坑
    private void fastSort(int[] nums, int l, int r) {
        if (l>r){
            return;
        }
        int tem = nums[l];
        int i = l,j =r;

        while (l<r){
            while (l<r&&tem<=nums[r]){
                r--;
            }
            nums[l] = nums[r];
            while (l<r&&tem>nums[l]){
                l++;
            }
            nums[r]=nums[l];

        }
        nums[l]=tem;
        fastSort(nums,i,l-1);
        fastSort(nums,l+1,j);
    }

}
