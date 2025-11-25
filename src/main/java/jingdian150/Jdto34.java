package jingdian150;

public class Jdto34 {

    public static void main(String[] args) {
        System.out.println(new Jdto34().search(new int[]{1,2,2,3,3,3,3,6,},4));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = search(nums,target);
        if (left==-1) return new int[]{-1,-1};
        int right = search(nums,target+1);
        if (right==-1) return new int[]{left,nums.length-1};
        return new int[]{left,right-1};
    }

    private int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int ans = -1;
        while (l<=r){
            int mid = l+r>>1;
            if (nums[mid]>=target){
                ans = mid;
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return ans;
    }
}
