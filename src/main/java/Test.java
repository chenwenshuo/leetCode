public class Test {
    public static void main(String[] args) {
        System.out.println(getTarget(new int[]{1,2,5,5,5,7,9},5));
    }

    /**
     * 选择二：有一堆桃子，大袋子可以装5个，售价5毛钱；小袋子可以装3个，售价3毛钱；那么，N个桃子，至少要花多少钱买袋子？Tips：如果不能正好装下，则用一个袋子，例如，4个桃子可以用1个大袋装下。
     * @param nums
     * @param t
     * @return
     */
    public static int getTarget(int[] nums,int t){
        int r = nums.length-1;
        int l=0;
        while (l<=r){
            int mid=(r+l)/2;
            if (nums[mid]==t){
                while (mid>0&&nums[mid]==nums[mid-1])
                    mid--;
                return mid;

            }
            if (nums[mid]>t){
                r=mid-1;
            }
            if (nums[mid]<t){
                l=mid+1;
            }
        }

        return -1;
    }
}
