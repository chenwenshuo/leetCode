package quene;

/**
 * @Author: chenwenshuo
 * @Date: 2022/09/26/19:56
 */
public class quickSort {

    public static void main(String[] args) {
        int[] sort = new quickSort().sort(new int[]{5, 1, 2, 3, 6, 7, 8});

    }
    public int[] sort(int[] nums){

        int l=0;
        int r=nums.length-1;
        sort(nums,l,r);

        return nums;
    }

    private void sort(int[] nums, int l, int r) {

        if (l>r) return;

        int key=nums[l];
        int i=l;

        while (l<r){
            while (nums[r]>key&&r>l){
                r--;
            }
            //1 4 3 2
            nums[l]=nums[r];
            while (nums[l]<key&&r>l){
                l++;
            }
            nums[r]=nums[l];
        }

        nums[l]=key;
        sort(nums,i,l-1);
        sort(nums,l+1,r);
    }
}
