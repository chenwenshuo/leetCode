package jingdian150;

public class Jdto11 {
    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length-1;
        int max=0;
        while (l<r){
            if (height[l]>height[r]){
                max = height[l];
                l++;
            }else {
                max = height[r];
                r--;
            }
            ans = Math.max(ans,max*(r-l)+1);
        }

        return  ans;
    }
}
